package com;
import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class DisplayServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	static final String DB_URL = "jdbc:sqlserver://localhost:1434;database=Master";
	   static final String USER = "sa";
	   static final String PASS = "Sajala@27";
	   Connection conn=null;
	   protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws  ServletException, IOException
	{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		 System.out.println("test");
		try 
		{
			 System.out.println("test1");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      if(conn!=null)
		    	  System.out.println("connected");
		      System.out.println("Creating statement...");
		      Statement stmt = conn.createStatement();
	         
	          String sql="select * from Student order by name";
	          ResultSet rs = stmt.executeQuery(sql);
	          out.println("<h1>Candidate Details<h1>");
	          out.println("<table><tr><th>CandidateID  </th><th>Name  </th><th>phoneNumber   </th><th>Email    </th><th>DateOfBirth  </th></tr>");
	          while(rs.next())
	          {
	             int id  = rs.getInt("id");
	             String name = rs.getString("name");
	             String phone = rs.getString("phone");
	             String emailid = rs.getString("emailid");
	             String dob = rs.getString("dob");
	             out.print("<tr><td>"+id+"</td><td>"+name    +"</td><td>"+phone   +"</td><td>"+emailid    +"</td><td>"+dob  +"</td></tr>");
	            System.out.println("Entered servlet");
	    	}
	          out.print("</table>");
	          out.println("</body></html>");
	        out.close();
		}
	    catch(SQLException | ClassNotFoundException e)
	    {
	        	  e.printStackTrace();
	    }
}
}
