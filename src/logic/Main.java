package logic;
import java.io.*;
import java.util.*;
import java.util.Map.*;
import java.util.logging.*;

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
		//Greedy
		
		logger.log(Level.INFO, "main completed");
	}
	
	   private static File inputFile = null;

	   private static void parseParameters(String [] args)
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
	   
	   private static HashMap<String, Section> parseFileCreateSections() throws FileNotFoundException{
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
	   
	   private static Section createSection(String[] line) {
		   //0 - class department, number, and section
		   String className = line[0].substring(0, 10);
		   //1 - class id number 
		   String id = line[1];
		   //2 - class type (lec, lab, act)
		   String type = line[2];
		   //3 - prof name
		   String prof = line[3];
		   //4 - day of the week, 5 - start time, 6 - end time
		   DoubleTimes time = new DoubleTimes(line[4], line[5], line[6]); 
		   //5 - location
		   String location = line[7];
		   return new Section(className, id, type, prof, time, location);
	   }
	   
	   //adds to the hashtable if it is a lab section for the same lecture
	   //Returns true if does not add, needing to add class as separate
	   //Returns false if it adds, thus not needing to add the class again
	   private static boolean checkLab(HashMap<String, Section> hashMap, Section currSection) {
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
	   
	   private static HashMap<DoubleTimes, List<Section>> classesByTime(HashMap<String, Section> hashMapInit){
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
	   
	   public void filterClassName(HashMap<String, Section> hashmap, String string){
		   //Uses mutation to filter out classes by name
		   Set<String> keys = hashmap.keySet();
		   for(String key: keys) {
			   if(key.contains(string)) {
				   hashmap.remove(key);
			   }
		   }
	   }
	   
	   //filter by Times
	   
	   //prototype for greedy
	   public static List<List<DoubleTimes>> greedySchedule(int n, List<DoubleTimes> d){
		   //n is the number of units
		   //d is the list of DoubleTimes?
	        int k = d.size();
	        List<List<DoubleTimes>> M = new ArrayList<>();
	        
	        //I'm not sure if this will give all options, but it should give at least every different time as an option
	        for(int i=0; i < k; i++) {
	        	M.add(new ArrayList<>());
	        	M.get(i).add(d.get(i));
	        	for(int j=i; j<k+i; j++) {
	        		if(j < k) {
	        			if(M.get(i).get(M.get(i).size() - 1).compatible(d.get(j))) {
	        				M.get(i).add(d.get(j));
	        				if(M.size() >= n) {
	        					break; //stop because this is an optimal solution
	        				}
	        			}
	        		}else {//loop back around
	        			if(M.get(i).get(M.get(i).size() - 1).compatible(d.get(j - i))) {
	        				//Double check this logic
	        				M.get(i).add(d.get(j - i));
	        				if(M.size() >= n) {
	        					break;
	        				}
	        			}
	        		}
	        	}
	        }
	        
	        return M;
	    }

}
