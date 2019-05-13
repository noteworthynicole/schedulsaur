package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

import logic.Class;
import logic.Database;

public class TestDatabase {
	
	private Class testClass = new Class("CSC 309");
	private String encrypted_pw = "gvznyfoyzhzfi";
	private String db_pw = Database.mostSecureEncryptionEver(encrypted_pw);
	private String db_url = "jdbc:mysql://schedulsaur-database.coiryrpvj04m.us-west-1.rds.amazonaws.com?useSSL=false";
	private String db_username = "schedulsaur";
	private Logger logger = Logger.getLogger("Database");
	
	@Test
	public void testGetClassLongName() {
		Statement stmt = null;
		try (Connection conn = DriverManager.getConnection(db_url,db_username,db_pw)){
	        stmt = conn.createStatement();
	        assertEquals("Software Engineering II", Database.dbClassLongName(stmt, testClass));
			stmt.close();
		}
		catch(SQLException se) {
	         //Handle errors for JDBC
			logger.log(Level.WARNING, se.toString());
	    }
		catch(Exception e) {
	         //Handle errors for Class.forName
			logger.log(Level.WARNING, e.toString());
	    }
	}
	
	@Test
	public void testGetClassUnits() {
		Statement stmt = null;
		try (Connection conn = DriverManager.getConnection(db_url,db_username,db_pw)){
	        stmt = conn.createStatement();
	        assertEquals("4 units", Database.dbClassUnits(stmt, testClass));
			stmt.close();
		}
		catch(SQLException se) {
	         //Handle errors for JDBC
			logger.log(Level.WARNING, se.toString());
	    }
		catch(Exception e) {
	         //Handle errors for Class.forName
			logger.log(Level.WARNING, e.toString());
	    }
	}
	
	@Test
	public void testGetClassCredit() {
		Statement stmt = null;
		try (Connection conn = DriverManager.getConnection(db_url,db_username,db_pw)){
	        stmt = conn.createStatement();
			assertEquals("Graded", Database.dbClassCredit(stmt, testClass));
			stmt.close();
		}
		catch(SQLException se) {
	         //Handle errors for JDBC
			logger.log(Level.WARNING, se.toString());
	    }
		catch(Exception e) {
	         //Handle errors for Class.forName
			logger.log(Level.WARNING, e.toString());
	    }
	}
	
	@Test
	public void testGetClassTerms() {
		Statement stmt = null;
		try (Connection conn = DriverManager.getConnection(db_url,db_username,db_pw)){
	        stmt = conn.createStatement();
			assertEquals("W, SP", Database.dbClassTerms(stmt, testClass));
			stmt.close();
		}
		catch(SQLException se) {
	         //Handle errors for JDBC
			logger.log(Level.WARNING, se.toString());
	    }
		catch(Exception e) {
	         //Handle errors for Class.forName
			logger.log(Level.WARNING, e.toString());
	    }
	}
	
	@Test
	public void testGetClassPrereqs() {
		Statement stmt = null;
		try (Connection conn = DriverManager.getConnection(db_url,db_username,db_pw)){
	        stmt = conn.createStatement();
			assertEquals("CSC 308 && CSC/CPE 357", Database.dbClassPrereqs(stmt, testClass));
			stmt.close();
		}
		catch(SQLException se) {
	         //Handle errors for JDBC
			logger.log(Level.WARNING, se.toString());
	    }
		catch(Exception e) {
	         //Handle errors for Class.forName
			logger.log(Level.WARNING, e.toString());
	    }
	}
}
