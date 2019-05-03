package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	// ok right now (5/2) everything just prints out stuff, we can do returns later
	
	/* course information (name, prereqs, units, etc) */
	
	// get course info for all csc classes, returns ??
	
	// get course info for all cpe classes, returns ??
	
	// this is because sonarcloud cried at me and doesn't like duplicate code
	public static ResultSet dbClass_Main(Statement stmt, String toFind, Class myClass) {
        try {
			String classID = myClass.getName();
			// now we do a lookup, but it depends if it's csc/cpe tho
			String department = classID.substring(0,3);
			String sql = "";
			// yes the database has them capitalized, but you know
			if(department.equalsIgnoreCase("csc")) {
		        sql = "SELECT " + toFind + " FROM schedulsaurdb.catalog_csc WHERE ClassID LIKE \"" + classID + "\"";
			}
			else if(department.equalsIgnoreCase("cpe")) {
				sql = "SELECT " + toFind + " FROM schedulsaurdb.catalog_cpe WHERE ClassID LIKE \"" + classID + "\"";
			}
			else {
				// fix this later for other majors I Guess
			}
			ResultSet rs = stmt.executeQuery(sql);
			return rs;
        }
		catch(SQLException se) {
	         //Handle errors for JDBC
	         se.printStackTrace();
	    }
		catch(Exception e) {
	         //Handle errors for Class.forName
	         e.printStackTrace();
	    }
        return null;
	}
	
	// get course info for a specific csc/cpe class, returns a string (like from the csv)
	public static void dbClassInfo(Statement stmt, Class myClass) {
        ResultSet rs = dbClass_Main(stmt, "*", myClass);
        try {
			while(rs.next()){
			   //Retrieve by column name
				String classID = myClass.getName();
				String className = rs.getString("ClassName");
			    String units = rs.getString("Units");
			    String credit = rs.getString("Credit");
			    String terms = rs.getString("Terms");
			    String prereqs = rs.getString("Prereqs");
			    System.out.println(classID + ", " + className + ", " + units + ", " + credit + ", " + terms + ", " + prereqs);
			}
			rs.close();
		} 
        catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// get full name for a specific csc/cpe class, returns a string
	public static void dbClassLongName(Statement stmt, Class myClass) {
		ResultSet rs = dbClass_Main(stmt, "ClassName", myClass);
        try {
			while(rs.next()){
			   //Retrieve by column name
				String className = rs.getString("ClassName");
			    System.out.println(className);
			}
			rs.close();
		} 
        catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// get # of units for a specific csc/cpe class, returns a string
	public static void dbClassUnits(Statement stmt, Class myClass) {
		ResultSet rs = dbClass_Main(stmt, "Units", myClass);
        try {
			while(rs.next()){
			   //Retrieve by column name
			    String units = rs.getString("Units");
			    System.out.println(units);
			}
			rs.close();
		} 
        catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// get # of units for a specific csc/cpe class, returns a string
	public static void dbClassCredit(Statement stmt, Class myClass) {
		ResultSet rs = dbClass_Main(stmt, "Credit", myClass);
        try {
			while(rs.next()){
			   //Retrieve by column name
			    String credit = rs.getString("Credit");
			    System.out.println(credit);
			}
			rs.close();
		} 
        catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// get # of units for a specific csc/cpe class, returns a string
	public static void dbClassTerms(Statement stmt, Class myClass) {
		ResultSet rs = dbClass_Main(stmt, "Terms", myClass);
        try {
			while(rs.next()){
			   //Retrieve by column name
			    String terms = rs.getString("Terms");
			    System.out.println(terms);
			}
			rs.close();
		} 
        catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// get prereq list for a specific csc/cpe class, returns a string
	public static void dbClassPrereqs(Statement stmt, Class myClass) {
		ResultSet rs = dbClass_Main(stmt, "Prereqs", myClass);
        try {
			while(rs.next()){
			   //Retrieve by column name
			    String prereqs = rs.getString("Prereqs");
			    System.out.println(prereqs);
			}
			rs.close();
		} 
        catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/* section information (the other stuff) */
	
	// get section info for Literally Every csc class, returns ??
	
	// get section info for Literally Every cpe class, returns ??
	
	// get section info for a specific csc/cpe class, returns ??
	
	public static void main(String[] args) {
		// below here goes before calls
		Connection conn = null;
		Statement stmt = null;
		try {
	        conn = DriverManager.getConnection("jdbc:mysql://schedulsaur-database.coiryrpvj04m.us-west-1.rds.amazonaws.com?useSSL=false","schedulsaur","teambulbasaur");
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
		// above here goes before calls
		
		Class c = new Class("CSC 101");
		dbClassInfo(stmt, c);
		dbClassLongName(stmt, c);
		dbClassUnits(stmt, c);
		dbClassCredit(stmt, c);
		dbClassTerms(stmt, c);
		dbClassPrereqs(stmt, c);
		
		// below here goes after calls
        try {
			stmt.close();
			conn.close();
		} 
        catch (SQLException e) {
			e.printStackTrace();
		}
        //above here goes after calls
	}
}
