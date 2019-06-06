package services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonMappingException;

import logic.Database;
import logic.User;

@RestController
public class UserController {
	private String encryptedPW = "gvznyfoyzhzfi";
	private String dbPW = Database.mostSecureEncryptionEver(encryptedPW);
	private String dbURL = "jdbc:mysql://schedulsaur-database.coiryrpvj04m.us-west-1.rds.amazonaws.com?useSSL=false";
	private String dbUsername = "schedulsaur";
	private Logger logger = Logger.getLogger("Database");
	
	/* Have to use this CrossOrigin annotation, otherwise browser will not allow HTTP requests */
	@CrossOrigin(origins = RESTURI.EXTERNAL_DOMAIN)
	/* http://localhost:8080/hello */
	@GetMapping(RESTURI.GET_SAMPLE_USER) 
	public User getSampleUser() { 
		/* This is where the database will be accessed, and the proper user info returned */
		String[] fields = {"id", "name", "major", "minor", "cy", "upq", "utq", "email", "password", "prev"};
		return new User(fields);
	}
	
	@CrossOrigin(origins = RESTURI.EXTERNAL_DOMAIN)
	@GetMapping(RESTURI.GET_USER)
	public User getUser(@PathVariable String email) {
		Statement stmt = null;
		try (Connection conn = DriverManager.getConnection(dbURL,dbUsername,dbPW)){
			stmt = conn.createStatement();
			User user  = new User(Database.dbGetStudent(stmt, email));
			stmt.close();
			return user;
		} catch(SQLException se) {
			//Handle errors for JDBC
			logger.log(Level.WARNING, se.toString());
		} catch(Exception e) {
			//Handle errors for Class.forName
			logger.log(Level.WARNING, e.toString());
		}
	
		return null;
	}
	
	@CrossOrigin(origins = RESTURI.EXTERNAL_DOMAIN)
	@PutMapping(RESTURI.PUT_USER)
	public void putUser(@RequestBody User user) {
		Statement stmt = null;
		try (Connection conn = DriverManager.getConnection(dbURL,dbUsername,dbPW)){
			stmt = conn.createStatement();
			Database.dbUpdateStudentFields(stmt, user.getId(), user.getSubsetFields());
			stmt.close();
		} catch(SQLException se) {
			//Handle errors for JDBC
			logger.log(Level.WARNING, se.toString());
		} catch(Exception e) {
			//Handle errors for Class.forName
			logger.log(Level.WARNING, e.toString());
		}
		
	}
	
	@CrossOrigin(origins = RESTURI.EXTERNAL_DOMAIN)
	@PostMapping(RESTURI.POST_USER) 
	public User postUser(@RequestBody User user) throws JsonMappingException, IOException {
		Statement stmt = null;
		try (Connection conn = DriverManager.getConnection(dbURL,dbUsername,dbPW)){
			stmt = conn.createStatement();
			String user_id = Database.dbGenerateStudentId(stmt);
			user.setId(user_id);
			Database.dbWriteStudent(stmt, user.getAllFields());
			stmt.close();
		} catch(SQLException se) {
			//Handle errors for JDBC
			logger.log(Level.WARNING, se.toString());
		} catch(Exception e) {
			//Handle errors for Class.forName
			logger.log(Level.WARNING, e.toString());
		}
		
		return user;
	}

}
