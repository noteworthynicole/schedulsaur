package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import logic.Class;
import logic.Database;

public class TestDatabase {
	
	@Test
	public void testGetClassLongName() {
		Statement stmt = null;
		Class testClass = new Class("CSC 309");
		
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://schedulsaur-database.coiryrpvj04m.us-west-1.rds.amazonaws.com?useSSL=false","schedulsaur","teambulbasaur");
	        stmt = conn.createStatement();
	        assertEquals("Software Engineering II", Database.dbClassLongName(stmt, testClass));
			stmt.close();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetClassUnits() {
		Statement stmt = null;
		Class testClass = new Class("CSC 309");
		
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://schedulsaur-database.coiryrpvj04m.us-west-1.rds.amazonaws.com?useSSL=false","schedulsaur","teambulbasaur");
	        stmt = conn.createStatement();
	        assertEquals("4 units", Database.dbClassUnits(stmt, testClass));
			stmt.close();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetClassCredit() {
		Statement stmt = null;
		Class testClass = new Class("CSC 309");
		
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://schedulsaur-database.coiryrpvj04m.us-west-1.rds.amazonaws.com?useSSL=false","schedulsaur","teambulbasaur");
	        stmt = conn.createStatement();
	        assertEquals("Graded", Database.dbClassCredit(stmt, testClass));
			stmt.close();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetClassTerms() {
		Statement stmt = null;
		Class testClass = new Class("CSC 309");
		
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://schedulsaur-database.coiryrpvj04m.us-west-1.rds.amazonaws.com?useSSL=false","schedulsaur","teambulbasaur");
	        stmt = conn.createStatement();
	        assertEquals("W, SP", Database.dbClassTerms(stmt, testClass));
			stmt.close();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetClassPrereqs() {
		Statement stmt = null;
		Class testClass = new Class("CSC 309");
		
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://schedulsaur-database.coiryrpvj04m.us-west-1.rds.amazonaws.com?useSSL=false","schedulsaur","teambulbasaur");
	        stmt = conn.createStatement();
	        assertEquals("CSC 308 && CSC/CPE 357", Database.dbClassPrereqs(stmt, testClass));
			stmt.close();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
