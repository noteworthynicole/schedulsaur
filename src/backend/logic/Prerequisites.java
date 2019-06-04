package logic;

import java.sql.Statement;
import java.util.*;

public class Prerequisites {
	
	private Prerequisites() {
	    throw new IllegalStateException("Utility class");
	}
	
	public static void filterPrereqs(Map<String, Section> sections, int studentId) {
		List<Catalog> catalogs = collectCatalogClasses();
		List<String> classesTaken = getClassesTaken(String.valueOf(studentId));
		removeClassesTaken(sections, classesTaken);
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
		String pastClass = Database.dbGetPastClasses(stmt, studentId);
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
