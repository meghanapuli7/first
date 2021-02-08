package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class NewJdbc 
{
	static final String DB_URL = "jdbc:sqlserver://localhost:1434;database=Master";
	//  Database credentials
	   static final String USER = "sa";
	   static final String PASS = "Sajala@27";
	   public static void main(String[] args) throws ClassNotFoundException, Exception
	   {
		   Candidate e1=new Candidate("megh",99888,"meg@gmail.com", "2006-04-08");
		   Candidate e2=new Candidate("a",778881122,"a@gmail.com","2007-04-09");
		   Candidate e3=new Candidate("b",99888777,"b@gmail.com","2008-02-07");
		   Candidate e4=new Candidate("c",998886661,"c@gmail.com","2005-07-02");
		   Candidate e5=new Candidate("meghana",9988668,"d@gmail.com","2009-07-04");
		   Connection conn = null;
		   try
		   {
		      //STEP 2: Register JDBC driver
			   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			   //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		    //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      ArrayList<Candidate> list = new ArrayList<Candidate>();
		        list.add(e1);
				list.add(e2);
				list.add(e3);
				list.add(e4);
				list.add(e5);
				for(Candidate e:list)
				{	
				PreparedStatement stmt1=conn.prepareStatement("insert into Student(name,phone,emailid,dob) values(?,?,?,?)");  
		       stmt1.setString(1,e.ename);  
		       stmt1.setLong(2, e.ephone);
			   stmt1.setString(3, e.eemailid);
			   stmt1.setString(4,e.edob);
			   stmt1.execute();
				 }    
				System.out.println("Records inserted......");
				}
		        catch(Exception se)
		        {
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }
		   }
		}
