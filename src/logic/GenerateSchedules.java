package logic;
import java.io.*;
import java.util.*;
import java.util.Map.*;
import java.util.logging.*;
import java.util.stream.*;

/*
 * General:
 * Need to cross reference with curriculum major to determine
 * 	1) The prerequisites
 * 	2) The number of units
 *  3) The classes to take
 * */

public class GenerateSchedules {
	
	private static final Logger logger = Logger.getLogger("GenerateSchedules");
	
	public static void main(String[] args) throws FileNotFoundException{
		Map<String, logic.Section> hashMapInit = parseDbsCreateSections();
		//Likely put a filter here to get rid of classes that are not relevant
		Map<logic.DoubleTimes, List<logic.Section>> hashMapTime = classesByTime(hashMapInit);
		//Sort - keyset -> list 
		List<logic.DoubleTimes> doubleTimesList1 = sortByKey(hashMapTime);
		//Greedy
		List<List<logic.DoubleTimes>> doubleTimesList2 = greedySchedule(4, doubleTimesList1);
		if(!doubleTimesList2.isEmpty()) {
			//Need to use the times from doubleTimes2 List for a schedule
			logger.log(Level.INFO, doubleTimesList2.get(0).toString());
		}
	}
	   
	   public static Map<String, logic.Section> parseDbsCreateSections(){
		   List<String[]> list = logic.Database.getdbAllRow();
		   HashMap<String, logic.Section> hashMapInit = new HashMap<>();
		   for(int i=0; i< list.size(); i++) {
			   logic.Section currSection = createSection(list.get(i));
			   String currKey = list.get(i)[0].substring(0, 10);
			   if(checkLab(hashMapInit, currSection)) {
				   hashMapInit.put(currKey, currSection);
			   }
		   }
		   return hashMapInit;
	   }
	   
	   public static logic.Section createSection(String[] line) {
		   //0 - class department, number, and section
		   List<String> fields = new ArrayList<>();
		   fields.add(line[0].substring(0, 10));
		   //1 - class id number 
		   fields.add(line[1]);
		   //2 - class type (lec, lab, act)
		   fields.add(line[2]);
		   //3 - prof name
		   fields.add(line[3]);
		   //4 - day of the week, 5 - start time, 6 - end time
		   logic.DoubleTimes time = new logic.DoubleTimes(line[4], line[5], line[6]);
		   //7 - location
		   fields.add(line[7]);
		   //8 - the maxCapacity
		   fields.add(line[8]);
		   //9 - the enrolled
		   fields.add(line[9]);
		   //10 - the wait list
		   fields.add(line[10]);
		   //11 - the id number used in the database
		   fields.add(line[11]);
		   return new logic.Section(time, fields);
	   }
	   
	   //adds to the hashtable if it is a lab section for the same lecture
	   //Returns true if does not add, needing to add class as separate
	   //Returns false if it adds, thus not needing to add the class again
	   public static boolean checkLab(Map<String, logic.Section> hashMap, logic.Section currSection) {
		   if (currSection.getType().equals("Lab")) {
			   //This grabs the prefix of the class if a lab, goes back one section to attach to lec version
			   String lecKey = currSection.getName().substring(0,8) + 
					   String.format("%02d", (Integer.valueOf(currSection.getName().substring(8)) - 1));
			   //Here is where the lab is added to where the lecture section 
			   if(hashMap.containsKey(lecKey)) {
				   logic.Section currList = hashMap.get(lecKey);
				   currList.addClass(currSection);
			   }
			   return false;
		   }
		   return true;
	   }
	   
	   public static Map<logic.DoubleTimes, List<logic.Section>> classesByTime(Map<String, logic.Section> hashMapInit){
		   HashMap<logic.DoubleTimes, List<logic.Section>> hashMapTime = new HashMap<>();
			for(Entry<String, logic.Section> entry : hashMapInit.entrySet()) {
				logic.Section currSection = entry.getValue();
				//Check to not add classes with nonexistent times
				if(!currSection.getTimes().getLecDay().contains("N/A")) {
					//The line below never evaluates to true, even though I am feeding in multiple times that should be the same
					if(hashMapTime.containsKey(currSection.getTimes())) {
						//add the section to the section list
						List<logic.Section> currList = hashMapTime.get(currSection.getTimes());
						currList.add(currSection);
					}else {
						//add the time as a new value 
						List<logic.Section> currValue = new ArrayList<>();
						currValue.add(currSection);
						hashMapTime.put(currSection.getTimes(), currValue);
					}
				}
			}
		 return hashMapTime;
	   }
	   
	   public void filterClassName(Map<String, logic.Section> hashmap, String string){
		   //Uses mutation to filter out classes by name
		   Set<String> keys = hashmap.keySet();
		   List<String> keysToRemove = new ArrayList<>();
		   for(String key: keys) {
			   if(key.contains(string)) {
				   keysToRemove.add(key);
			   }
		   }
		   for(String key: keysToRemove) {
			   hashmap.remove(key);
		   }
	   }

	   // Sort Times for Greedy Algorithm
	   public static List<logic.DoubleTimes> sortByKey(Map<logic.DoubleTimes, List<logic.Section>> hashmap) {
	   	Set<logic.DoubleTimes> keys = hashmap.keySet();
	   	List<logic.DoubleTimes> d = keys.stream().collect(Collectors.toList());
	   	Collections.sort(d, (t1, t2) -> t1.compareTo(t2)); 
	   	return d;
	   }
	   
	   public void filterAvailableClass(Map<String, logic.Section> hashmap) {
		   Set<String> keys = hashmap.keySet();
		   Set<String> keysToRemove = new HashSet<>();
		   for(String key: keys) {
			   if(!hashmap.get(key).isAvailable()) {
				   keysToRemove.add(key);
			   }
		   }
		   //Necessary so not error if all keys are removed
		   for(String key: keysToRemove) {
			   hashmap.remove(key);
		   }
	   }
	   
	   //filter by Times
	   
	   //main greedy schedule. Create one schedule with each class as it's own start
	   public static List<List<logic.DoubleTimes>> greedySchedule(int n, List<logic.DoubleTimes> d){
		   //n is the number of classes (all classes default to 4 units)
		   //d is the list of DoubleTimes?
	        int k = d.size();
	        List<List<logic.DoubleTimes>> m = new ArrayList<>();
	        //I'm not sure if this will give all options, but it should give at least every different time as an option
	        for(int i=0; i < k; i++) {
	        	List<logic.DoubleTimes> temp = greedyHelper(n, i, d);
	        	if(temp.size() == n) {
	        		m.add(temp);
	        	}
	        }
	        return m;
	    }
	   
	   public static List<logic.DoubleTimes> greedyHelper(int n, int i, List<logic.DoubleTimes> d){
		   int k = d.size();
		   List<logic.DoubleTimes> schedule = new ArrayList<>();
		   schedule.add(d.get(i));
		   for(int j=i+1; j<k+i; j++) {
	    		if(j < k && allCompatible(schedule, d.get(j))) {
    				schedule.add(d.get(j));
    				if(schedule.size() >= n) {
    					return schedule; //stop because this is an optimal solution
    				}
	    		}else if(j >= k && allCompatible(schedule, d.get(j - i - 1))){//loop back around
    				schedule.add(d.get(j - i - 1));
    				if(schedule.size() >= n) {
    					return schedule;
	    			}
	    		}
	    	}
	       	return schedule;
	   }
	   
	   public static boolean allCompatible(List<logic.DoubleTimes> schedule, logic.DoubleTimes potential) {
		   for(logic.DoubleTimes times : schedule) {
			   if(!times.compatible(potential)) {
				   return false;
			   }
		   }
		   return true;
	   }

	   // Gets a list of all the potential schedules - list<section>
	   public static List<List<logic.Section>> getPotentialSchedules(Map<logic.DoubleTimes, List<logic.Section>> hashmap, List<List<logic.DoubleTimes>> dt) {
	   	List<List<logic.Section>> schedules = new ArrayList<List<logic.Section>>();
	   	List<List<logic.Section>> temps = new ArrayList<List<logic.Section>>();
	   	for (int i = 0; i < dt.size(); i++) {
	   		for (int k = 0; k < dt.get(i).size(); k++) {
	   			temps.add(hashmap.get(dt.get(i).get(k)));
	   		}
	   		for (int j = 0; j < getCombos(temps, 0).size(); j++) {
	   			schedules.add(getCombos(temps, 0).get(j));
	   	}
	   	return schedules;
	   }

		// i is used for recursion, for the initial call this should be 0
		private static List<List<logic.Section>> getCombos(List<List<logic.Section>> input, int i) {
			
			// stop condition
			if(i == input.size()) {
				// return a list with an empty list
				List<List<logic.Section>> result = new ArrayList<List<logic.Section>>();
				result.add(new ArrayList<logic.Section>());
				return result;
			}
			
			List<List<logic.Section>> result = new ArrayList<List<logic.Section>>();
			List<List<logic.Section>> recursive = getCombos(input, i+1); // recursive call
			
			// for each element of the first list of input
			for(int j = 0; j < input.get(i).size(); j++) {
				// add the element to all combinations obtained for the rest of the lists
				for(int k = 0; k < recursive.size(); k++) {
		                        // copy a combination from recursive
					List<logic.Section> newList = new ArrayList<logic.Section>();
					for(logic.Section section : recursive.get(k)) {
						newList.add(section);
					}
					// add element of the first list
					newList.add(input.get(i).get(j));
		                        // add new combination to result
					result.add(newList);
				}
			}
			return result;
		}

	   // just returns a list of list of sections with the first element used
	   public static List<List<logic.Section>> getFirstSchedules(Map<logic.DoubleTimes, List<logic.Section>> hashmap, List<List<logic.DoubleTimes>> dt) {
	   	List<List<logic.Section>> schedules = new ArrayList<>();
	   	List<logic.Section> schedule = new ArrayList<>();
	   	for (int i = 0; i < dt.size(); i++) {
	   		for (int k = 0; k < dt.get(i).size(); k++) {
	   			schedule.add(hashmap.get(dt.get(i).get(k)).get(0));
	   		}
	   		schedules.add(schedule);
	   	}
	   	return schedules;
	   }


	   // filter out schedules with duplicate courses
	   public void filterPotentialSchedules(List<List<logic.Section>> ps) {
		   	Set<String> names = new HashSet<>();
		   	int[] arr = new int[ps.size()];
		   	int count = 0;
		   	for (int i = 0; i < ps.size(); i++) {
		   	schedule = ps.get(i);
			   	for (int j = 0; j < ps.get(i).size(); j++) {
			   		if (!names.add(ps.get(i).get(j).getName())) {
			   			arr[count++]= i;
			   		}
			   	}
		   	names = new HashSet<>();
		   	}
		 
		   for (int i = 0; i < count; i++) {
			   ps.remove(arr[i]);
		   }
	   }

	   // return a string for database for schedules

}
