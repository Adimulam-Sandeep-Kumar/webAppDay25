package ai.jobiak.http;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignupForm1Servlet
 */

public class SignupForm1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupForm1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
    private Connection connect() {
    	
		String userName = "root";
		String password = "admin";
		String url ="jdbc:mysql://localhost:3306/world";
		Connection con = null;
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,userName,password);	 
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return con;
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String fnameStr = request.getParameter("fname");
			String emailStr = request.getParameter("email");
			String mobileStr = request.getParameter("mobile");
					
			Connection con = connect();
			int count = 0;
			try {
				PreparedStatement ps = con.prepareStatement("insert into signup values(?,?,?)");
				ps.setString(1, fnameStr);
				ps.setString(2, emailStr);
				ps.setString(3, mobileStr);
				
				count = ps.executeUpdate();
				
			} catch (SQLException e) {	
				e.printStackTrace();
			}						
			response.getWriter().println(count  + "Record Inserted");
			
	}

}
