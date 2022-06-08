package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Product;

public class ListProductDAO {
	//return the list of products by product name
	public List<Product> search(String chracters) throws Exception {
		List<Product> items = new ArrayList<>();
		Connection conn = new DBContext().getConnection();
		Statement stm = conn.createStatement();
		String sql = "select * from ShoppingDB.dbo.Products order by product_name";
		ResultSet rs = stm.executeQuery(sql);
		while(rs.next()) {
			int productID = rs.getInt(1);
			String productName = rs.getString(2);
			String productInfor = rs.getString(3);
			float productPrice = rs.getFloat(4);
			String productImageLink = rs.getString(5);
			String productType = rs.getString(6);
			String productBrand = rs.getString(7);
			Product p = new Product(productID, productName, productInfor, productPrice, productImageLink, productType, productBrand);
			items.add(p);
		}
		rs.close();
		stm.close();
		conn.close();
		return items;
	}
	public Product getProduct(String character) throws Exception {
		Product p = new Product();
		Connection conn = new DBContext().getConnection();
		Statement stm = conn.createStatement();
		String sql = "select * from ShoppingDB.dbo.Products where product_name like '%"+character+"%'";
		ResultSet rs = stm.executeQuery(sql);
		while(rs.next()) {
			int productID = rs.getInt(1);
			String productName = rs.getString(2);
			String productInfor = rs.getString(3);
			float productPrice = rs.getFloat(4);
			String productImageLink = rs.getString(5);
			String productType = rs.getString(6);
			String productBrand = rs.getString(7);
			p = new Product(productID, productName, productInfor, productPrice, productImageLink, productType, productBrand);
		}
		rs.close();
		stm.close();
		conn.close();
		return p;
	}
}
