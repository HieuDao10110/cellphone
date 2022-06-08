package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;

import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(true);
		session.setAttribute("error", "");
		Cookie arr[] = request.getCookies();
		session.setAttribute("fillUser", "");
		session.setAttribute("fillPass", "");
		if(arr!=null) {
					for(Cookie c : arr) {
			if(c.getName().equals("user")) {
				session.setAttribute("fillUser", c.getValue());
			}
			if(c.getName().equals("password")) {
				session.setAttribute("fillPass", c.getValue());
			}
		}
		}
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");// vietnamese
		try {
			//destroy session--
			//To make sure the session is properly maintained, 
			//you must call this method before the response is committed.
			//If the container is using cookies to maintain session integrity and is asked to create a new session when the response is committed,
			//an IllegalStateException is thrown.
	//request.getSession(true).invalidate();
			//make sure that email is valid
			String regexMail = "^[A-Za-z0-9+_.-]+@(.+)$";
//			^                 # start-of-string
//			(?=.*[0-9])       # a digit must occur at least once
//			(?=.*[a-z])       # a lower case letter must occur at least once
//			(?=.*[A-Z])       # an upper case letter must occur at least once
//			(?=.*[@#$%^&+=])  # a special character must occur at least once
//			(?=\S+$)          # no whitespace allowed in the entire string
//			.{8,}             # anything, at least eight places though
//			$                 # end-of-string
			String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
			//collect data from a login form
			String userID = request.getParameter("user");
			String password = request.getParameter("pass");
			String rem = request.getParameter("remember");
			Account acc = new Account();
			acc.setName(userID); acc.setPwd(password);
			//read information of account in web.xml
			String uid = getServletContext().getInitParameter("username");
			String pwd = getServletContext().getInitParameter("password");
			
			//create new session
			HttpSession session = request.getSession(true);
			if(!password.matches(regex)||!userID.matches(regexMail)) {
				session.setAttribute("error", "invalid syntax");
				response.sendRedirect("login.jsp");
			} else {
				if (userID != null && acc.getPwd().equals(pwd) && acc.getName().equalsIgnoreCase(uid)) {
					//add user and pass to cookie
					if(rem != null) {
						//save cookie
						Cookie userC = new Cookie("user",userID);
						Cookie passC = new Cookie("password",password);
						//set time alive of cookie
						userC.setMaxAge(9000);
						passC.setMaxAge(9000);
						//add cookie to the browser
						response.addCookie(userC);
						response.addCookie(passC);
					}
					//set session
					session.setAttribute("user", userID);
					response.sendRedirect("admin/index.jsp");
				} else {
					session.setAttribute("error", "wrong username or password");
					response.sendRedirect("login.jsp");
				}
			}
		} catch (NullPointerException e) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);			
			response.getWriter().println(e);
		} catch (Exception ex) {
			response.getWriter().println(ex);
		}
	}
}
