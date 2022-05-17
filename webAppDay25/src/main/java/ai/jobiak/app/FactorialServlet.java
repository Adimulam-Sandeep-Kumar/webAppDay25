package ai.jobiak.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FactorialServlet implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		
		int n = 5;
		int fact = 1;
		for(int i=1;i<=n;i++) {
			
			fact *= i;
		}
		out.println("The factorial of 5 is" + fact);
	//	out.println("<hr/>");
		
		ArrayList<String> list = new ArrayList<>();
		list.add("London");list.add("Apple");list.add("Blue");
		for(String color : list) {
			
			out.println(color +"::"+ color.length()/2);
			
		}
		
		HashMap<String,String> techInventors = new HashMap<>();
		techInventors.put("Java", "James Gosling");
		techInventors.put("Cpp", "Bjarne Stroustup");
		techInventors.put("C","Dennis Ritchie");
		
		out.println(techInventors);
		
		Set<String> keys = techInventors.keySet();
		for(String key:keys) {
			
			out.println(techInventors.get(key) +"length of the values :"+techInventors.get(key).length());
			
		}
		
		
//		HashMap<String,String> Inventors = new Hashmap();
//		Inventors.put("Google", "Larry Page");
//		Inventors.put("Microsoft", "BillGates" );
//		
//		out.println(Inventors);
//	
		
	}

}
