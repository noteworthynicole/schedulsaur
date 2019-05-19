package logic;

import java.util.*;

public class Prerequisites {
	
	public static void main(String[] args) {
		Map<String, Section> sections = new HashMap<>();
		List<Catalog> catalogs = collectCatalogClasses();
		List<String> classesTaken = getClassesTaken();
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
	
	//This is a dummy function. Replace with actual call to database when implemented
	public static List<String> getClassesTaken(){
		List<String> classes = new ArrayList<>();
		classes.add("");
		return classes;
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
