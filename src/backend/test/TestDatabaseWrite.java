package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

import logic.Class;
import logic.Database;

public class TestDatabaseWrite {
	
	private Class testClass = new Class("CSC 309");
	private String encryptedPW = "gvznyfoyzhzfi";
	private String dbPW = Database.mostSecureEncryptionEver(encryptedPW);
	private String dbURL = "jdbc:mysql://schedulsaur-database.coiryrpvj04m.us-west-1.rds.amazonaws.com?useSSL=false";
	private String dbUsername = "schedulsaur";
	private Logger logger = Logger.getLogger("Database");
	
	@Test
	public void testGetClassQuery() {
		Statement stmt = null;
		try (Connection conn = DriverManager.getConnection(dbURL,dbUsername,dbPW)){
			stmt = conn.createStatement();
			ResultSet rs = Database.dbClassQuery(stmt, "ClassID", testClass);
			assertEquals("CSC 309", rs.getString(1));
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
	public void testGetClassInfo() {
		Statement stmt = null;
		try (Connection conn = DriverManager.getConnection(dbURL,dbUsername,dbPW)){
			stmt = conn.createStatement();
			assertEquals("CSC 309, Software Engineering II, 4 units	Graded, W, SP, CSC 308 && CSC/CPE 357", Database.dbClassInfo(stmt, testClass));
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
	public void testGetAllRows() {
		Statement stmt = null;
		try (Connection conn = DriverManager.getConnection(dbURL,dbUsername,dbPW)){
			stmt = conn.createStatement();
			assertEquals("CPE 100", Database.dbAllRows(stmt, "SELECT * FROM schedulsaurdb.catalog_cpe;").get(0)[0]);
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
	public void testGetStudentInfo() {
		Statement stmt = null;
		try (Connection conn = DriverManager.getConnection(dbURL,dbUsername,dbPW)){
			stmt = conn.createStatement();
			assertEquals("Tommy", Database.dbGetStudentInfo(stmt, "1").get(0));
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
