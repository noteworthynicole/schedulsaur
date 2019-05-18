package logic;

import java.util.*;import java.util.logging.Logger;

import org.mvel2.MVEL;

public class Prerequisites {
	
	public static void main(String[] args) {
		List<String[]> list = Database.getdbAllRow(Database.CPECATSQL, Database.CSCCATSQL);
		List<Catalog> catalogs = collectCatalogClasses(list);
		List<String> classesTaken = getClassesTaken();
		replaceBooleanClasses(catalogs, classesTaken);
		//Go through the current sections and if not in the catalog class then remove
	}
	
	//for each class, access their prerequisites
	//go to the user's account and access their list of prerequisites
	//replace the class with either true or false depending on if the user has taken the class
	//remove classes that don't meet prerequisites
	public void filterOutPrerequisites(Map<String, Section> sections) { //add parameter to get user 
		List<String> classesTaken = new ArrayList<>(Arrays.asList("CPE 101"));//actually get the classes the student has taken
		//get a list of classes with the prereqs in it
		HashMap<String, List<String>> allPrereq = new HashMap<>();
		List<String> classesToRemove = new ArrayList<>();
		
		for(Map.Entry<String, Section> entry : sections.entrySet()) {
			List<String> currPrereq = allPrereq.get(entry.getValue().getEqualName());
			if(filterOutPrereqHelper(classesTaken, currPrereq, entry.getKey())) {
				classesToRemove.add(entry.getKey());
			}
		}
		
		for(String rem : classesToRemove) {
			sections.remove(rem);
		}
	}
	
	public boolean filterOutPrereqHelper(List<String> classesTaken, List<String> prereqs, String currClass) {
		/*for(String prereq : prereqs) {
			if(!classesTaken.contains(prereq)) {//Make sure the classesTaken matches prereq. ie CSC/CPE 101 and not CSC 101 and CPE 101
				return currClass; //TODO: replace this, need to use the MVEL to replace and then see if evaluates to true
			}
		}*/
		return false;
	}
	
	public static List<Catalog> collectCatalogClasses(List<String[]> strings){
		List<Catalog> catalogs = new ArrayList<>();
		for(String[] string : strings) {
			catalogs.add(new Catalog(new ArrayList<>(Arrays.asList(string))));
		}
		return catalogs;
	}
	
	public static void replaceBooleanClasses(List<Catalog> catalogs, List<String> classesTaken) {
		List<Catalog> catalogToRemove = new ArrayList<>();
		for(Catalog clatalog : catalogs) {
			//go through the string of prereqs
			if(clatalog.getPrereq(classesTaken)) {
				catalogToRemove.add(clatalog);
			}
		}
		
		catalogs.removeAll(catalogToRemove);
	}
	
	public static List<String> getClassesTaken(){
		//TODO: this is a dummy function until account is implemented
		List<String> classes = new ArrayList<>();
		classes.add("");
		return classes;
	}
}
