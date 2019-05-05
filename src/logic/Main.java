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

public class Main {
	
	private static final Logger logger = Logger.getLogger("Main");
	
	public static void main(String[] args) throws FileNotFoundException{
		parseParameters(args);
		HashMap<String, Section> hashMapInit = parseFileCreateSections();
		//Likely put a filter here to get rid of classes that are not relevant
		HashMap<DoubleTimes, List<Section>> hashMapTime = classesByTime(hashMapInit);
		//Sort - keyset -> list 
		List<DoubleTimes> doubleTimesList1 = sortByKey(hashMapTime); 
		//Greedy
		List<List<DoubleTimes>> doubleTimesList2 = greedySchedule(4, doubleTimesList1);
		if(!doubleTimesList2.isEmpty()) {
			//Need to use the times from doubleTimes2 List for a schedule
			logger.log(Level.INFO, doubleTimesList2.get(0).toString());
		}
	}
	
	   public static File inputFile = null;

	   public static void parseParameters(String [] args)
	   {
		  Logger logger = Logger.getLogger("param");
	      for (int i = 0; i < args.length; i++)
	      { 
	         if (inputFile != null)
	         {
	        	logger.log(Level.WARNING, "too many files specified");
	            System.exit(1);
	         }
	         else
	         {
	            inputFile = new File(args[i]);
	         }
	      }
	   }
	   
	   public static HashMap<String, Section> parseFileCreateSections() throws FileNotFoundException{
		   //This function parses through the file and creates sections of both lecture and lab
		   Scanner fileScanner = new Scanner(inputFile);
			HashMap<String, Section> hashMapInit = new HashMap<>();
			try {
				while (fileScanner.hasNextLine()) {  
					   String line = fileScanner.nextLine();
					   String[] array = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
					   Section currSection = createSection(array);
					   String currKey = array[0].substring(0, 10);
					   if(checkLab(hashMapInit, currSection)) {
						   hashMapInit.put(currKey, currSection);
					   }
					   //last class store as temp variable
					}
			}catch(Exception e) {
				logger.log(Level.WARNING, e.toString());
			}finally {
				fileScanner.close();
			}
			return hashMapInit;
	   }
	   
	   public static Section createSection(String[] line) {
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
		   DoubleTimes time = new DoubleTimes(line[4], line[5], line[6]); 
		   //7 - location
		   fields.add(line[7]);
		   //8 - the maxCapacity
		   fields.add(line[8]);
		   //9 - the enrolled
		   fields.add(line[9]);
		   //10 - the wait list
		   fields.add(line[10]);
		   return new Section(time, fields);
	   }
	   
	   //adds to the hashtable if it is a lab section for the same lecture
	   //Returns true if does not add, needing to add class as separate
	   //Returns false if it adds, thus not needing to add the class again
	   public static boolean checkLab(Map<String, Section> hashMap, Section currSection) {
		   if (currSection.getType().equals("Lab")) {
			   //This grabs the prefix of the class if a lab, goes back one section to attach to lec version
			   String lecKey = currSection.getName().substring(0,8) + 
					   String.format("%02d", (Integer.valueOf(currSection.getName().substring(8)) - 1));
			   //Here is where the lab is added to where the lecture section 
			   if(hashMap.containsKey(lecKey)) {
				   Section currList = hashMap.get(lecKey);
				   currList.addClass(currSection);
			   }
			   return false;
		   }
		   return true;
	   }
	   
	   public static HashMap<DoubleTimes, List<Section>> classesByTime(Map<String, Section> hashMapInit){
		   HashMap<DoubleTimes, List<Section>> hashMapTime = new HashMap<>();
			for(Entry<String, Section> entry : hashMapInit.entrySet()) {
				Section currSection = entry.getValue();
				//Check to not add classes with nonexistent times
				if(!currSection.getTimes().getLecDay().contains("N/A")) {
					//The line below never evaluates to true, even though I am feeding in multiple times that should be the same
					if(hashMapTime.containsKey(currSection.getTimes())) {
						//add the section to the section list
						List<Section> currList = hashMapTime.get(currSection.getTimes());
						currList.add(currSection);
					}else {
						//add the time as a new value 
						List<Section> currValue = new ArrayList<>();
						currValue.add(currSection);
						hashMapTime.put(currSection.getTimes(), currValue);
					}
				}
			}
		 return hashMapTime;
	   }
	   
	   public void filterClassName(Map<String, Section> hashmap, String string){
		   //Uses mutation to filter out classes by name
		   Set<String> keys = hashmap.keySet();
		   for(String key: keys) {
			   if(key.contains(string)) {
				   hashmap.remove(key);
			   }
		   }
	   }

	   // Sort Times for Greedy Algorithm - Untested
	   public static List<DoubleTimes> sortByKey(Map<DoubleTimes, List<Section>> hashmap) {
	   	Set<DoubleTimes> keys = hashmap.keySet();
	   	List<DoubleTimes> d = keys.stream().collect(Collectors.toList());
	   	Collections.sort(d, (t1, t2) -> t1.compareTo(t2)); 
	   	return d;
	   }
	   
	   public void filerAvailableClass(Map<String, Section> hashmap) {
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
	   
	   //prototype for greedy
	   public static List<List<DoubleTimes>> greedySchedule(int n, List<DoubleTimes> d){
		   //n is the number of classes (all classes default to 4 units)
		   //d is the list of DoubleTimes?
	        int k = d.size();
	        List<List<DoubleTimes>> m = new ArrayList<>();
	        //I'm not sure if this will give all options, but it should give at least every different time as an option
	        for(int i=0; i < k; i++) {
	        	List<DoubleTimes> temp = greedyHelper(n, i, d);
	        	if(temp.size() == n) {
	        		m.add(temp);
	        	}
	        }
	        return m;
	    }
	   
	   public static List<DoubleTimes> greedyHelper(int n, int i, List<DoubleTimes> d){
		   int k = d.size();
		   List<DoubleTimes> schedule = new ArrayList<>();
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
	   
	   public static boolean allCompatible(List<DoubleTimes> schedule, DoubleTimes potential) {
		   for(DoubleTimes times : schedule) {
			   if(!times.compatible(potential)) {
				   return false;
			   }
		   }
		   return true;
	   }

}
