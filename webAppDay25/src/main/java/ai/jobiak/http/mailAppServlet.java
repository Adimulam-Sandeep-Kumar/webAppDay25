package ai.jobiak.http;

import java.io.*;
import java.sql.*;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mailAppServlet
 */
public class mailAppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mailAppServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    private Connection connect() {
    	
		String userName = "root";
		String password = "admin";
		String url ="jdbc:mysql://localhost:3306/sandeep";
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
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con = connect();	
		PrintWriter out = response.getWriter();
		
		  while(true) {
			  
		  out.println("Menu"); 
		  out.println("----------------");
		  out.println("1.First"); 
		  out.println("2.Next");
		  out.println("3.Previous");
		  out.println("4.Last");
		  out.println("5.Go to #"); 
		  out.println("6.Exit");
		  out.println("Enter the Option : ");
		  
		  Scanner sc = new Scanner(System.in); 
		  
		  try {
		  Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		  String selectsql = "select * from mailApp";
		  ResultSet rs = st.executeQuery(selectsql);
		  int option = sc.nextInt();
		  switch(option) {
		  
		  case 1:
			 			  
			  rs.first();
			  out.println(rs.getString(1)+"::"+rs.getString(2)+"::"+rs.getString(3)+"::"+rs.getString(4)+"::"+rs.getString(5));
			  break;
		
		  case 2:
			  
			  rs.first();
			  rs.next();
			  out.println(rs.getString(1)+"::"+rs.getString(2)+"::"+rs.getString(3)+"::"+rs.getString(4)+"::"+rs.getString(5));
			  break;
		
		  case 3:
			  
			  rs.first();
			  rs.next();
			  rs.previous();
			  out.println(rs.getString(1)+"::"+rs.getString(2)+"::"+rs.getString(3)+"::"+rs.getString(4)+"::"+rs.getString(5));
			  break;
			
		  case 4:
			  
			  rs.afterLast();
			  rs.last();
			  out.println(rs.getString(1)+"::"+rs.getString(2)+"::"+rs.getString(3)+"::"+rs.getString(4)+"::"+rs.getString(5));
			  break;
			  
		  case 5:
			  
			  out.println("Enter the Mail Number : ");		  
			  int num = sc.nextInt();
			  rs.absolute(num);
			  out.println(rs.getString(1)+"::"+rs.getString(2)+"::"+rs.getString(3)+"::"+rs.getString(4)+"::"+rs.getString(5));
			  break;
			  
		  case 6:
			  
			  out.println("Exited");
			  break;
			  
		  default:
			
			out.println("Please enter a valid Option");
			
		  
		  }
		  	  
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		  }
		
		
		
	}

}
