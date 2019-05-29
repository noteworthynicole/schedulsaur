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

import logic.Database;

public class TestDatabaseWrite {
	
	 @Test
	   public void testWriteStudent() {
	      Database db = new Database();
	      Statement stmt = null;
			try (Connection conn = DriverManager.getConnection(DBSITE,SCHEDELSAUR,mostSecureEncryptionEver(ENCRYPTEDPW))){
				stmt = conn.createStatement();
				// calls go here
				stmt.close();
			} catch(SQLException se) {
				//Handle errors for JDBC
				logger.log(Level.WARNING, se.toString());
			} catch(Exception e) {
				//Handle errors for Class.forName
				logger.log(Level.WARNING, e.toString());
	   }

}
