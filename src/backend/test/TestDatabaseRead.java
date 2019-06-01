package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import logic.Database;
import org.junit.Test;

import logic.Class;

import static org.junit.Assert.assertEquals;

public class TestDatabaseRead {
	
	private Class testClass = new Class("CSC 309");
	private String encryptedPW = "gvznyfoyzhzfi";
	private String dbPW = Database.mostSecureEncryptionEver(encryptedPW);
	private String dbURL = "jdbc:mysql://schedulsaur-database.coiryrpvj04m.us-west-1.rds.amazonaws.com?useSSL=false";
	private String dbUsername = "schedulsaur";
	private Logger logger = Logger.getLogger("Database");
	
	@Test
	public void testGetClassLongName() {
		Statement stmt = null;
		try (Connection conn = DriverManager.getConnection(dbURL,dbUsername,dbPW)){
			stmt = conn.createStatement();
			assertEquals("Software Engineering II", Database.dbClassLongName(stmt, testClass));
			stmt.close();
		} catch(SQLException se) {
			//Handle errors for JDBC
			logger.log(Level.WARNING, se.toString());
		} catch(Exception e) {
			//Handle errors for Class.forName
			logger.log(Level.WARNING, e.toString());
		}
	}
	
	@Test
	public void testGetClassUnits() {
		Statement stmt = null;
		try (Connection conn = DriverManager.getConnection(dbURL,dbUsername,dbPW)){
			stmt = conn.createStatement();
			assertEquals("4 units", Database.dbClassUnits(stmt, testClass));
			stmt.close();
		} catch(SQLException se) {
			//Handle errors for JDBC
			logger.log(Level.WARNING, se.toString());
		} catch(Exception e) {
			//Handle errors for Class.forName
			logger.log(Level.WARNING, e.toString());
		}
	}
	
	@Test
	public void testGetClassCredit() {
		Statement stmt = null;
		try (Connection conn = DriverManager.getConnection(dbURL,dbUsername,dbPW)){
			stmt = conn.createStatement();
			assertEquals("Graded", Database.dbClassCredit(stmt, testClass));
			stmt.close();
		} catch(SQLException se) {
			//Handle errors for JDBC
			logger.log(Level.WARNING, se.toString());
		} catch(Exception e) {
			//Handle errors for Class.forName
			logger.log(Level.WARNING, e.toString());
		}
	}
	
	@Test
	public void testGetClassTerms() {
		Statement stmt = null;
		try (Connection conn = DriverManager.getConnection(dbURL,dbUsername,dbPW)){
		stmt = conn.createStatement();
			assertEquals("W, SP", Database.dbClassTerms(stmt, testClass));
			stmt.close();
		} catch(SQLException se) {
			//Handle errors for JDBC
			logger.log(Level.WARNING, se.toString());
		} catch(Exception e) {
			//Handle errors for Class.forName
			logger.log(Level.WARNING, e.toString());
		}
	}
	
	@Test
	public void testGetClassPrereqs() {
		Statement stmt = null;
		try (Connection conn = DriverManager.getConnection(dbURL,dbUsername,dbPW)){
		stmt = conn.createStatement();
			assertEquals("CSC 308 && CSC/CPE 357", Database.dbClassPrereqs(stmt, testClass));
			stmt.close();
		} catch(SQLException se) {
			//Handle errors for JDBC
			logger.log(Level.WARNING, se.toString());
		} catch(Exception e) {
			//Handle errors for Class.forName
			logger.log(Level.WARNING, e.toString());
		}
	}
}
