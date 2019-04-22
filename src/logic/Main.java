package logic;
import java.io.*;
import java.util.*;

/*
 * General:
 * Need to cross reference with curriculum major to determine
 * 	1) The prerequisites
 * 	2) The number of units
 * 	3) The "category"?
 * 
 * Changes to make:
 * 	1) Create a LIST of classes 
 *  2) If lab, add as a field in the class (last element in the list, very easy to find)
 *  3) Add lab time to the list of class time
 *  4) Then organize classes by times in a HashTable
 *   
 * Code Smells to address:
 *  1) Not sure yet, but we have do it
 * 
 * */

public class Main {
	public static void main(String[] args) throws FileNotFoundException{
		parseParameters(args);
		Scanner fileScanner = new Scanner(inputFile);
		HashMap<String, Section> hashMap = new HashMap<>();
		try {
			while (fileScanner.hasNextLine()) {  
				   String line = fileScanner.nextLine();
				   String[] array = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
				   Section currSection = createSection(array);
				   String currKey = array[0].substring(0, 10);
				   if(checkLab(hashMap, currSection)) {
					   hashMap.put(currKey, currSection);
				   }
				   //last class store as temp variable
				}
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			fileScanner.close();
		}
		//System.out.println(hashMap);
		//System.out.println("main completed");
	}
	
	   private static File inputFile = null;

	   private static void parseParameters(String [] args)
	   {
	      for (int i = 0; i < args.length; i++)
	      { 
	         if (inputFile != null)
	         {
	            System.out.println("too many files specified");
	            System.exit(1);
	         }
	         else
	         {
	            inputFile = new File(args[i]);
	         }
	      }
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
		   Times time = new Times(line[4], line[5], line[6]); 
		   //5 - location
		   String location = line[7];
		   return new Section(className, id, type, prof, time, location);
	   }
	   
	   //adds to the hashtable if it is a lab section for the same lecture
	   //Returns true if does not add, needing to add class as separate
	   //Returns false if it adds, thus not needing to add the class again
	   private static boolean checkLab(HashMap<String, Section> hashMap, Section currSection) {
		   if (currSection.type.equals("Lab")) {
			   //This grabs the prefix of the class if a lab, goes back one section to attach to lec version
			   String lecKey = currSection.name.substring(0,8) + 
					   String.format("%02d", (Integer.valueOf(currSection.name.substring(8)) - 1));
			   //Here is where the lab is added to where the lecture section 
			   if(hashMap.containsKey(lecKey)) {
				   Section currList = hashMap.get(lecKey);
				   currList.addClass(currSection);
			   }
			   return false;
		   }
		   return true;
	   }
}
