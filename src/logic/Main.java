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
	
	public static Logger logger = Logger.getLogger("Main");
	
	public static void main(String[] args){
		parseParameters(args);
		HashMap<String, Section> hashMapInit = parseFileCreateSections();
		//Likely put a filter here to get rid of classes that are not relevant
		HashMap<DoubleTimes, List<Section>> hashMapTime = classesByTime(hashMapInit);
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
	   
	   private static HashMap<String, Section> parseFileCreateSections(){
		   //This function parses through the file and creates sections of both lecture and lab
		   Scanner fileScanner = null;
			try {
				fileScanner = new Scanner(inputFile);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
}
