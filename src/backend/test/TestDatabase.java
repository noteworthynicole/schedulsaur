package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import static org.junit.Assert.*;
import org.junit.Test;
import logic.Database;

@RunWith(Suite.class)
@SuiteClasses({ TestDatabaseRead.class, TestDatabaseWrite.class })
public class TestDatabase {
   
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
