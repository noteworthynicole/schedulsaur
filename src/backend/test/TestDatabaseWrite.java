package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.*;

import logic.Class;
import logic.Database;

public class TestDatabaseWrite {
	
	private Class testClass1 = new Class("CSC 309");
	private String encryptedPW1 = "gvznyfoyzhzfi";
	private String dbPW1 = Database.mostSecureEncryptionEver(encryptedPW1);
	private String dbURL1 = "jdbc:mysql://schedulsaur-database.coiryrpvj04m.us-west-1.rds.amazonaws.com?useSSL=false";
	private String dbUsername1 = "schedulsaur";
	private Logger logger1 = Logger.getLogger("Database");
	
	@Test
	public void testWriteStudent() {
		Database db = new Database();
		Statement stmt = null;
			try (Connection conn = DriverManager.getConnection(dbURL1,dbUsername1,dbPW1)){
				stmt = conn.createStatement();
				// calls go here
				stmt.close();
			} catch(SQLException se) {
				//Handle errors for JDBC
				logger1.log(Level.WARNING, se.toString());
			} catch(Exception e) {
				//Handle errors for Class.forName
				logger1.log(Level.WARNING, e.toString());
		}
	}
}
