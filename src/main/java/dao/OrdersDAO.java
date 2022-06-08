package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Cart;
import model.Orders;
import model.Product;

public class OrdersDAO {
	//insert information of Order to data source, that including list of 
	//products in cart (c) and information of buyer in Order o
	public void insertOrder(Orders o, Cart c) throws Exception {
		List<Product> items;
		Connection conn = new DBContext().getConnection();
		Statement stm = conn.createStatement();
		String sql = "insert into ShoppingDB.dbo.Orders (user_mail, order_id, order_status, order_date, order_discount_code, order_address)"
				+ "value ("+o.getUserMail()+","+o.getOrderId()+","+o.getStatus()+","+o.getOrderDate()+","+o.getDiscount()+","+o.getAddress()+");";
		int rs = stm.executeUpdate(sql);
		
		double total = c.getAmount();
		int orderID = o.getOrderId();
		items = c.getItems();
		for(Product i : items) {
			String sql2 = "insert into ShoppingDB.dbo.Orders_detail (order_id, product_id, amount_product, price_product)"
					+ "value ("+orderID+","+i.getId()+","+total+","+i.getPrice()+");";
			rs = stm.executeUpdate(sql2);
		}
		stm.close();
		conn.close();
	}
}
