import java.io.*;
import java.util.*;

public class Main {
	@SuppressWarnings("serial")
	public static void main(String[] args) throws FileNotFoundException{
		parseParameters(args);
		Scanner fileScanner = new Scanner(_inputFile);
		Hashtable<String, List<Section>> hashTable = new Hashtable<>();
		while (fileScanner.hasNextLine()) {  
			   String line = fileScanner.nextLine();
			   String[] array = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
			   System.out.println(Arrays.toString(array));
			   Section currSection = createSection(array);
			   String currKey = array[0].substring(0, 10);
			   //TODO: make more sophisticated version of connecting lec/lab of classes
			   if(checkLab(hashTable, currSection)) {
				   hashTable.put(currKey, new ArrayList<Section>(){{add(currSection);}});
			   }
			}
		fileScanner.close();
		System.out.println(hashTable);
		System.out.println(hashTable.get("CSC-300-01"));
		System.out.println("complete");
	}
	
	   private static File _inputFile = null;

	   private static void parseParameters(String [] args)
	   {
	      for (int i = 0; i < args.length; i++)
	      { 
	         if (_inputFile != null)
	         {
	            System.err.println("too many files specified");
	            System.exit(1);
	         }
	         else
	         {
	            _inputFile = new File(args[i]);
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
	   private static boolean checkLab(Hashtable<String, List<Section>> hashTable, Section currSection) {
		   if (currSection.type.equals("Lab")) {
			   //This grabs the prefix of the class if a lab, goes back one section to attach to lec version
			   String lecKey = currSection.name.substring(0,8) + 
					   String.format("%02d", (Integer.valueOf(currSection.name.substring(8)) - 1));
			   System.out.println(lecKey);
			   //Here is where the lab is added to where the lecture section 
			   if(hashTable.containsKey(lecKey)) {
				   List<Section> currList = hashTable.get(lecKey);
				   currList.add(currSection);
				   hashTable.put(lecKey, currList);
			   }
			   return false;
		   }
		   return true;
	   }
}
