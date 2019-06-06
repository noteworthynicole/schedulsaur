package logic;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Prerequisites {
	
	private static String encryptedPW = "gvznyfoyzhzfi";
	private static String dbPW = Database.mostSecureEncryptionEver(encryptedPW);
	private static String dbURL = "jdbc:mysql://schedulsaur-database.coiryrpvj04m.us-west-1.rds.amazonaws.com?useSSL=false";
	private static String dbUsername = "schedulsaur";
	private static Logger logger = Logger.getLogger("Database");
	
	
	private Prerequisites() {
	    throw new IllegalStateException("Utility class");
	}
	
	public static void filterPrereqs(Map<String, Section> sections, int studentId) {
		List<Catalog> catalogs = collectCatalogClasses();
		List<String> classesTaken = getClassesTaken(String.valueOf(studentId));
		removeClassesTaken(sections, catalogs);
		replaceBooleanClasses(catalogs, classesTaken);
		removeIneligbleClasses(catalogs, sections);
	}
	
	//Access the database to get all the catalog info
	public static List<Catalog> collectCatalogClasses(){
		List<String[]> strings = Database.getdbAllRow(Database.CPECATSQL, Database.CSCCATSQL);
		List<Catalog> catalogs = new ArrayList<>();
		for(String[] string : strings) {
			catalogs.add(new Catalog(new ArrayList<>(Arrays.asList(string))));
		}
		return catalogs;
	}
	
	//Heads up - need to be sure that there aren't any commas, else split by that instead
	public static List<String> getClassesTaken(String studentId){
		Statement stmt = null;
		String pastClass = "";
		try (Connection conn = DriverManager.getConnection(dbURL,dbUsername,dbPW)){
			stmt = conn.createStatement();
			pastClass = Database.dbGetStudentPastClasses(stmt, studentId);
			stmt.close();
		} catch(SQLException se) {
			//Handle errors for JDBC
			logger.log(Level.WARNING, se.toString());
		} catch(Exception e) {
			//Handle errors for Class.forName
			logger.log(Level.WARNING, e.toString());
		}
		
		return new ArrayList<>(Arrays.asList(pastClass.split("(?<!\\G\\S+)\\s")));
	}
	
	//checks to see if the class meets prereqs
	//makes call to make the prereqs a boolean expression
	//removes class from catalogs if they don't meet
	public static void replaceBooleanClasses(List<Catalog> catalogs, List<String> classesTaken) {
		List<Catalog> catalogToRemove = new ArrayList<>();
		for(Catalog catalog : catalogs) {
			//go through the string of prereqs
			if(!catalog.getPrereq(classesTaken)) {
				catalogToRemove.add(catalog);
			}
		}
		catalogs.removeAll(catalogToRemove);
	}
	
	public static void removeClassesTaken(Map<String, Section> sections, List<Catalog> catalogs) {
		List<String> pastClassNums = new ArrayList<>();
		List<String> classesToRemove = new ArrayList<>();
		for(Catalog cat : catalogs) {
			pastClassNums.add(cat.getClassNum());
		}
		for(Section sec : sections.values()) {
			if(pastClassNums.contains(sec.getClassNum())) {
				classesToRemove.add(sec.getName());
			}
		}
		for(String classToRemove : classesToRemove) {
			sections.remove(classToRemove);
		}
	}
	
	//does the actual filtering to remove classes that don't meet prereqs
	public static void removeIneligbleClasses(List<Catalog> catalogs, Map<String, Section> sections) {
		List<String> sectionsToRemove = new ArrayList<>();
		List<String> eligibleClasses = new ArrayList<>();
		for(Catalog catalog : catalogs) {
			eligibleClasses.add(catalog.getEqualName());
		}
		for(Map.Entry<String, Section> entry : sections.entrySet()) {
			if(!eligibleClasses.contains(entry.getValue().getEqualName())) {
				sectionsToRemove.add(entry.getKey());
			}
		}
		for(String key : sectionsToRemove) {
			sections.remove(key);
		}
	}
	
}
