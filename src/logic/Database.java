package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	/* @nicole/jack: so we need the below two bits of code somewhere in your main:
	   
	   //goes before any database calls
	   Connection conn = null;
		Statement stmt = null;
		try {
			java.lang.Class.forName("com.mysql.jdbc.Driver");              //STEP 3: Open a connection
	        //System.out.println("Connecting to database...");
	        conn = DriverManager.getConnection("jdbc:mysql://schedulsaur-database.coiryrpvj04m.us-west-1.rds.amazonaws.com?useSSL=false","schedulsaur","teambulbasaur");              //STEP 4: Execute a query
	        //System.out.println("Creating statement...");
	        stmt = conn.createStatement();
		}
		catch(SQLException se) {
	         //Handle errors for JDBC
	         se.printStackTrace();
	    }
		catch(Exception e) {
	         //Handle errors for Class.forName
	         e.printStackTrace();
	    }
		
	   //goes after all database calls
	   try {
			stmt.close();
			conn.close();
		} 
        catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	 */
	
	/* and now for the functions */
	// ok right now (5/2) everything just prints out stuff, we can do returns later
	
	/* course information (name, prereqs, units, etc) */
	
	// get course info for all csc classes, returns ??
	
	// get course info for all cpe classes, returns ??
	
	// get course info for a specific csc/cpe class, returns a string (like from the csv)
	public static void dbClassInfo(Statement stmt, Class myClass) {
        try {
			String classID = myClass.getName();
			// now we do a lookup, but it depends if it's csc/cpe tho
			String department = classID.substring(0,3);
			String sql = "";
			// yes the database has them capitalized, but you know
			if(department.equalsIgnoreCase("csc")) {
		        sql = "SELECT * FROM schedulsaurdb.catalog_csc WHERE ClassID LIKE \"" + classID + "\"";
			}
			else if(department.equalsIgnoreCase("cpe")) {
				sql = "SELECT * FROM schedulsaurdb.catalog_cpe WHERE ClassID LIKE \"" + classID + "\"";
			}
			else {
				// fix this later for other majors I Guess
			}
	        ResultSet rs = stmt.executeQuery(sql);              //STEP 5: Extract data from result set
	        while(rs.next()){
	           //Retrieve by column name
	        	String className = rs.getString("ClassName");
	            String units = rs.getString("Units");
	            String credit = rs.getString("Credit");
	            String terms = rs.getString("Terms");
	            String prereqs = rs.getString("Prereqs");
	            System.out.println(classID + ", " + className + ", " + units + ", " + credit + ", " + terms + ", " + prereqs);
	        }
	        rs.close();
		}
		catch(SQLException se) {
	         //Handle errors for JDBC
	         se.printStackTrace();
	    }
		catch(Exception e) {
	         //Handle errors for Class.forName
	         e.printStackTrace();
	    }
	}
	
	// get full name for a specific csc/cpe class, returns a string
	public static void dbClassLongName(Statement stmt, Class myClass) {
		try {
			String classID = myClass.getName();
			// now we do a lookup, but it depends if it's csc/cpe tho
			String department = classID.substring(0,3);
			String sql = "";
			// yes the database has them capitalized, but you know
			if(department.equalsIgnoreCase("csc")) {
		        sql = "SELECT ClassName FROM schedulsaurdb.catalog_csc WHERE ClassID LIKE \"" + classID + "\"";
			}
			else if(department.equalsIgnoreCase("cpe")) {
				sql = "SELECT ClassName FROM schedulsaurdb.catalog_cpe WHERE ClassID LIKE \"" + classID + "\"";
			}
			else {
				// fix this later for other majors I Guess
			}
	        ResultSet rs = stmt.executeQuery(sql);              //STEP 5: Extract data from result set
	        while(rs.next()){
	           //Retrieve by column name
	           String className = rs.getString("ClassName");
	           System.out.println(className);
	        }
	        rs.close();
		}
		catch(SQLException se) {
	         //Handle errors for JDBC
	         se.printStackTrace();
	    }
		catch(Exception e) {
	         //Handle errors for Class.forName
	         e.printStackTrace();
	    }
	}
	
	// get # of units for a specific csc/cpe class, returns a string
	public static void dbClassUnits(Statement stmt, Class myClass) {
		try {
			String classID = myClass.getName();
			// now we do a lookup, but it depends if it's csc/cpe tho
			String department = classID.substring(0,3);
			String sql = "";
			// yes the database has them capitalized, but you know
			if(department.equalsIgnoreCase("csc")) {
		        sql = "SELECT Units FROM schedulsaurdb.catalog_csc WHERE ClassID LIKE \"" + classID + "\"";
			}
			else if(department.equalsIgnoreCase("cpe")) {
				sql = "SELECT Units FROM schedulsaurdb.catalog_cpe WHERE ClassID LIKE \"" + classID + "\"";
			}
			else {
				// fix this later for other majors I Guess
			}
	        ResultSet rs = stmt.executeQuery(sql);              //STEP 5: Extract data from result set
	        while(rs.next()){
	           //Retrieve by column name
	           String units = rs.getString("Units");
	           System.out.println(units);
	        }
	        rs.close();
		}
		catch(SQLException se) {
	         //Handle errors for JDBC
	         se.printStackTrace();
	    }
		catch(Exception e) {
	         //Handle errors for Class.forName
	         e.printStackTrace();
	    }
	}
	
	// get # of units for a specific csc/cpe class, returns a string
	public static void dbClassCredit(Statement stmt, Class myClass) {
		try {
			String classID = myClass.getName();
			// now we do a lookup, but it depends if it's csc/cpe tho
			String department = classID.substring(0,3);
			String sql = "";
			// yes the database has them capitalized, but you know
			if(department.equalsIgnoreCase("csc")) {
		        sql = "SELECT Credit FROM schedulsaurdb.catalog_csc WHERE ClassID LIKE \"" + classID + "\"";
			}
			else if(department.equalsIgnoreCase("cpe")) {
				sql = "SELECT Credit FROM schedulsaurdb.catalog_cpe WHERE ClassID LIKE \"" + classID + "\"";
			}
			else {
				// fix this later for other majors I Guess
			}
	        ResultSet rs = stmt.executeQuery(sql);              //STEP 5: Extract data from result set
	        while(rs.next()){
	           //Retrieve by column name
	           String credit = rs.getString("Credit");
	           System.out.println(credit);
	        }
	        rs.close();
		}
		catch(SQLException se) {
	         //Handle errors for JDBC
	         se.printStackTrace();
	    }
		catch(Exception e) {
	         //Handle errors for Class.forName
	         e.printStackTrace();
	    }
	}
	
	// get # of units for a specific csc/cpe class, returns a string
	public static void dbClassTerms(Statement stmt, Class myClass) {
		try {
			String classID = myClass.getName();
			// now we do a lookup, but it depends if it's csc/cpe tho
			String department = classID.substring(0,3);
			String sql = "";
			// yes the database has them capitalized, but you know
			if(department.equalsIgnoreCase("csc")) {
		        sql = "SELECT Terms FROM schedulsaurdb.catalog_csc WHERE ClassID LIKE \"" + classID + "\"";
			}
			else if(department.equalsIgnoreCase("cpe")) {
				sql = "SELECT Terms FROM schedulsaurdb.catalog_cpe WHERE ClassID LIKE \"" + classID + "\"";
			}
			else {
				// fix this later for other majors I Guess
			}
	        ResultSet rs = stmt.executeQuery(sql);              //STEP 5: Extract data from result set
	        while(rs.next()){
	           //Retrieve by column name
	           String terms = rs.getString("Terms");
	           System.out.println(terms);
	        }
	        rs.close();
		}
		catch(SQLException se) {
	         //Handle errors for JDBC
	         se.printStackTrace();
	    }
		catch(Exception e) {
	         //Handle errors for Class.forName
	         e.printStackTrace();
	    }
	}
	
	// get prereq list for a specific csc/cpe class, returns a string
	public static void dbClassPrereqs(Statement stmt, Class myClass) {
		try {
			String classID = myClass.getName();
			// now we do a lookup, but it depends if it's csc/cpe tho
			String department = classID.substring(0,3);
			String sql = "";
			// yes the database has them capitalized, but you know
			if(department.equalsIgnoreCase("csc")) {
		        sql = "SELECT Prereqs FROM schedulsaurdb.catalog_csc WHERE ClassID LIKE \"" + classID + "\"";
			}
			else if(department.equalsIgnoreCase("cpe")) {
				sql = "SELECT Prereqs FROM schedulsaurdb.catalog_cpe WHERE ClassID LIKE \"" + classID + "\"";
			}
			else {
				// fix this later for other majors I Guess
			}
	        ResultSet rs = stmt.executeQuery(sql);              //STEP 5: Extract data from result set
	        while(rs.next()){
	           //Retrieve by column name
	           String prereqs = rs.getString("Prereqs");
	           System.out.println(prereqs);
	        }
	        rs.close();
		}
		catch(SQLException se) {
	         //Handle errors for JDBC
	         se.printStackTrace();
	    }
		catch(Exception e) {
	         //Handle errors for Class.forName
	         e.printStackTrace();
	    }
	}
	
	/* section information (the other stuff) */
	
	// get section info for Literally Every csc class, returns ??
	
	// get section info for Literally Every cpe class, returns ??
	
	// get section info for a specific csc/cpe class, returns ??
	
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			java.lang.Class.forName("com.mysql.jdbc.Driver");              //STEP 3: Open a connection
	        //System.out.println("Connecting to database...");
	        conn = DriverManager.getConnection("jdbc:mysql://schedulsaur-database.coiryrpvj04m.us-west-1.rds.amazonaws.com?useSSL=false","schedulsaur","teambulbasaur");              //STEP 4: Execute a query
	        //System.out.println("Creating statement...");
	        stmt = conn.createStatement();
		}
		catch(SQLException se) {
	         //Handle errors for JDBC
	         se.printStackTrace();
	    }
		catch(Exception e) {
	         //Handle errors for Class.forName
	         e.printStackTrace();
	    }
		
		Class c = new Class("CSC 101");
		//System.out.println(c.getName());
		dbClassInfo(stmt, c);
		dbClassLongName(stmt, c);
		dbClassUnits(stmt, c);
		dbClassCredit(stmt, c);
		dbClassTerms(stmt, c);
		dbClassPrereqs(stmt, c);
		
        try {
			stmt.close();
			conn.close();
		} 
        catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	/* the below code was from a tutorial, pls don't touch, i still need to look at it 
	public static void main(String[] args)
	  {
		  Connection conn = null;
	      Statement stmt = null;
	      try{
	         //STEP 2: Register JDBC driver
	         java.lang.Class.forName("com.mysql.jdbc.Driver");              //STEP 3: Open a connection
	         System.out.println("Connecting to database...");
	         conn = DriverManager.getConnection("jdbc:mysql://schedulsaur-database.coiryrpvj04m.us-west-1.rds.amazonaws.com?useSSL=false","schedulsaur","teambulbasaur");              //STEP 4: Execute a query
	         System.out.println("Creating statement...");
	         stmt = conn.createStatement();
	         String sql;
	         sql = "SELECT Title FROM schedulsaurdb.sections_csc";
	         ResultSet rs = stmt.executeQuery(sql);              //STEP 5: Extract data from result set
	         while(rs.next()){
	            //Retrieve by column name
	            String title = rs.getString("Title");                 //Display values
	            System.out.println("title: " + title);
	         }
	         //STEP 6: Clean-up environment
	         rs.close();
	         stmt.close();
	         conn.close();
	      }catch(SQLException se){
	         //Handle errors for JDBC
	         se.printStackTrace();
	      }catch(Exception e){
	         //Handle errors for Class.forName
	         e.printStackTrace();
	      }finally{
	         //finally block used to close resources
	         try{
	            if(stmt!=null)
	               stmt.close();
	         }catch(SQLException se2){
	         }// nothing we can do
	         try{
	            if(conn!=null)
	               conn.close();
	         }catch(SQLException se){
	            se.printStackTrace();
	         }//end finally try
	      }//end try
	      System.out.println("Goodbye!");
	  } */
}
