package services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
import logic.ScheduleBlock;
import logic.TimePreference;

@RestController
public class BlockController {
	
	private String encryptedPW = "gvznyfoyzhzfi";
	private String dbPW = Database.mostSecureEncryptionEver(encryptedPW);
	private String dbURL = "jdbc:mysql://schedulsaur-database.coiryrpvj04m.us-west-1.rds.amazonaws.com?useSSL=false";
	private String dbUsername = "schedulsaur";
	private Logger logger = Logger.getLogger("Database");
	
	String[] days = {"Su", "M", "T", "W", "R", "F", "Sa"};
	boolean[][] blocks = {{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
			{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
			{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
			{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
			{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
			{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
			{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}};

	@CrossOrigin(origins = RESTURI.EXTERNAL_DOMAIN)
	@GetMapping(RESTURI.GET_SAMPLE_BLOCK)
	/* http://localhost:8080/avail */
	public ScheduleBlock getSampleBlock() { 
		return new ScheduleBlock("013000607", "1", "name", blocks);
	}
	
	@CrossOrigin(origins = RESTURI.EXTERNAL_DOMAIN)
	@GetMapping(RESTURI.GET_BLOCK)
	public ScheduleBlock getBlock(@PathVariable String studentId, @PathVariable String availNum) {
		Statement stmt = null;
		try (Connection conn = DriverManager.getConnection(dbURL,dbUsername,dbPW)){
			stmt = conn.createStatement();
			String name = Database.dbGetTimePref(stmt, studentId, availNum);
			String[] block = Database.dbGetStudentTimeAvails(stmt, studentId, availNum);
			ScheduleBlock temp = new ScheduleBlock();
			boolean [][] frontBlock = temp.toFEFormat(block);
			stmt.close();
			return new ScheduleBlock(studentId, availNum, name, frontBlock);
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
	@GetMapping(RESTURI.GET_ALL_PREFS)
	public ArrayList<TimePreference> getAllPrefs(@PathVariable String studentId) {
		ArrayList<TimePreference> preferences = new ArrayList<TimePreference>();
		Statement stmt = null;
		try (Connection conn = DriverManager.getConnection(dbURL,dbUsername,dbPW)){
			stmt = conn.createStatement();
			preferences = Database.dbGetAllTimePrefs(stmt, studentId);
			stmt.close();
			return preferences;
		} catch(SQLException se) {
			//Handle errors for JDBC
			logger.log(Level.WARNING, se.toString());
		} catch(Exception e) {
			//Handle errors for Class.forName
			logger.log(Level.WARNING, e.toString());
		}
		return preferences;
		
	}
	
	@CrossOrigin(origins = RESTURI.EXTERNAL_DOMAIN)
	@PutMapping(RESTURI.PUT_PREF)
	public void putBlock(@PathVariable String studentId, @PathVariable String availNum, @PathVariable String name) {
		Statement stmt = null;
		try (Connection conn = DriverManager.getConnection(dbURL,dbUsername,dbPW)){
			stmt = conn.createStatement();
			Database.dbPutTimePref(stmt, studentId, availNum, name);
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
	@PostMapping(RESTURI.POST_BLOCK) 
	public ScheduleBlock postBlock(@RequestBody ScheduleBlock block) throws JsonMappingException, IOException {
		TimePreference time = new TimePreference(block.getStudentId(), block.getAvailNum(), block.getName());
		Statement stmt = null;
		try (Connection conn = DriverManager.getConnection(dbURL,dbUsername,dbPW)){
			stmt = conn.createStatement();
			String block_id = Database.dbGenerateTimeId(stmt, block.getStudentId());
			block.setAvailNum(block_id);
			time.setAvailNum(block_id);
			Database.dbPostTimePref(stmt, time.getAllFields());
			Database.dbPostTimeAvail(stmt, block.getStudentId(), block.getAvailNum(), block.toDBFormat());
			System.out.println((block.getStudentId() + block.getAvailNum()));
			stmt.close();
		} catch(SQLException se) {
			//Handle errors for JDBC
			logger.log(Level.WARNING, se.toString());
		} catch(Exception e) {
			//Handle errors for Class.forName
			logger.log(Level.WARNING, e.toString());
		}
		
		return block;

	}
}
