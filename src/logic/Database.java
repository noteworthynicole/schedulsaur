package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.*;

public class Database {
	
	// constants i guess
	private static final String CLASSNAME = "ClassName";
	private static final String UNITS = "Units";
	private static final String CREDIT = "Credit";
	private static final String TERMS = "Terms";
	private static final String PREREQS = "Prereqs";
	private static final Logger logger = Logger.getLogger("Database");
	
	// ok right now (5/2) everything just prints out stuff, we can do returns later
	
	/* course information (name, prereqs, units, etc) */
	
	// get course info for all csc classes, returns ??
	
	// get course info for all cpe classes, returns ??
	
	// this is because sonarcloud cried at me and doesn't like duplicate code
	public static ResultSet dbClassQuery(Statement stmt, String toFind, Class myClass) {
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
			return stmt.executeQuery(sql);
        }
		catch(SQLException se) {
	         //Handle errors for JDBC
			 logger.log(Level.WARNING, se.toString());
	    }
		catch(Exception e) {
	         //Handle errors for Class.forName
			logger.log(Level.WARNING, e.toString());
	    }
        return null;
	}
	
	// get course info for a specific csc/cpe class, returns a string (like from the csv)
	public static void dbClassInfo(Statement stmt, Class myClass) {
        ResultSet rs = dbClassQuery(stmt, "*", myClass);
        try {
			while(rs.next()){
				String classID = myClass.getName();
				String className = rs.getString(CLASSNAME);
			    String units = rs.getString(UNITS);
			    String credit = rs.getString(CREDIT);
			    String terms = rs.getString(TERMS);
			    String prereqs = rs.getString(PREREQS);
			    System.out.println(classID + ", " + className + ", " + units + ", " + credit + ", " + terms + ", " + prereqs);
			}
			rs.close();
		} 
        catch (Exception e) {
        	logger.log(Level.WARNING, e.toString());
		}
	}
	
	// get full name for a specific csc/cpe class, returns a string
	public static String dbClassLongName(Statement stmt, Class myClass) {
		ResultSet rs = dbClassQuery(stmt, CLASSNAME, myClass);
		String className = "N/A";
        try {
			while(rs.next()){
				className = rs.getString(CLASSNAME);
			    //System.out.println(className);
			}
			rs.close();
		} 
        catch (Exception e) {
        	logger.log(Level.WARNING, e.toString());
		}
        return className;
	}
	
	// get # of units for a specific csc/cpe class, returns a string
	public static String dbClassUnits(Statement stmt, Class myClass) {
		ResultSet rs = dbClassQuery(stmt, UNITS, myClass);
		String units = "N/A";
        try {
			while(rs.next()){
			    units = rs.getString(UNITS);
			    //System.out.println(units);
			}
			rs.close();
		} 
        catch (Exception e) {
        	logger.log(Level.WARNING, e.toString());
		}
        return units;
	}
	
	// get # of units for a specific csc/cpe class, returns a string
	public static String dbClassCredit(Statement stmt, Class myClass) {
		ResultSet rs = dbClassQuery(stmt, CREDIT, myClass);
		String credit = "N/A";
        try {
			while(rs.next()){
			    credit = rs.getString(CREDIT);
			    //System.out.println(credit);
			}
			rs.close();
		} 
        catch (Exception e) {
        	logger.log(Level.WARNING, e.toString());
		}
        return credit;
	}
	
	// get # of units for a specific csc/cpe class, returns a string
	public static String dbClassTerms(Statement stmt, Class myClass) {
		ResultSet rs = dbClassQuery(stmt, TERMS, myClass);
		String terms = "N/A";
        try {
			while(rs.next()){
			    terms = rs.getString(TERMS);
			    //System.out.println(terms);
			}
			rs.close();
		} 
        catch (Exception e) {
        	logger.log(Level.WARNING, e.toString());
		}
        return terms;
	}
	
	// get prereq list for a specific csc/cpe class, returns a string
	public static String dbClassPrereqs(Statement stmt, Class myClass) {
		ResultSet rs = dbClassQuery(stmt, PREREQS, myClass);
		String prereqs = "N/A";
        try {
			while(rs.next()){
			   //Retrieve by column name
			    prereqs = rs.getString(PREREQS);
			    //System.out.println(prereqs);
			}
			rs.close();
		} 
        catch (Exception e) {
        	logger.log(Level.WARNING, e.toString());
		}
        return prereqs;
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
			logger.log(Level.WARNING, se.toString());
	    }
		catch(Exception e) {
	         //Handle errors for Class.forName
			logger.log(Level.WARNING, e.toString());
	    }
		// above here goes before calls
		
		Class c = new Class("CSC 101");
		dbClassInfo(stmt, c);
		//System.out.println(dbClassLongName(stmt, c));
		//System.out.println(dbClassUnits(stmt, c));
		//System.out.println(dbClassCredit(stmt, c));
		//System.out.println(dbClassTerms(stmt, c));
		//System.out.println(dbClassPrereqs(stmt, c));
		
		// below here goes after calls
        try {
			stmt.close();
			conn.close();
		} 
        catch (SQLException e) {
        	logger.log(Level.WARNING, e.toString());
		}
        //above here goes after calls
	}
}
