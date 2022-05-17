package ai.jobiak.http;

import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayServletDb
 */
public class DisplayServletDb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayServletDb() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
						
		String userName = "root";
		String password = "admin";
		String url ="jdbc:mysql://localhost:3306/world";
		PrintWriter out = response.getWriter();
		
		try {
			
		Connection con = DriverManager.getConnection(url,userName,password);
		Statement st = con.createStatement();
		String selectSQL = "select * from signup";	
		ResultSet rs = st.executeQuery(selectSQL);
		
		while(rs.next()) {		
			
			out.println(rs.getString(1)+"::"+rs.getString(2)+"::"+rs.getString(3));
		}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
