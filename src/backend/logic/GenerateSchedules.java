package logic;
import java.util.*;
import java.util.Map.*;
import java.util.stream.*;

/*
 * General:
 * Need to cross reference with curriculum major to determine
 * 	1) The prerequisites
 * 	2) The number of units
 *  3) The classes to take
 * */

public class GenerateSchedules {
	
	public static Schedule[] generateSchedules(String studentId){
		Map<String, Section> hashMapInit = parseDbsCreateSections();
		//filter with prereqs - need the user's id to get past classes
		//Prerequisites.filterPrereqs(hashMapInit, studentId);
		
		Map<DoubleTimes, List<Section>> hashMapTime = classesByTime(hashMapInit);
		//filter with time availability - need the user's id to get off time
		//Nicole - convert the boolean table to Times for compatibility
		
		//Sort - keyset -> list 
		List<DoubleTimes> doubleTimesList1 = sortByKey(hashMapTime);
		//Greedy
		List<List<DoubleTimes>> doubleTimesList2 = greedySchedule(4, doubleTimesList1);
		//Getting the different combinations of classes
		List<List<Section>> schedules = getPotentialSchedules(hashMapTime, doubleTimesList2);
		//putting the classes into ScheduleRow objects for the frontend
		return listsOfSchedules(schedules);

	}
	
	public static Schedule[] listsOfSchedules(List<List<Section>> doubleTimes) {
		List<Schedule> outerList = new ArrayList<>();
		for(int i=0; i<doubleTimes.size(); i++) {
			List<ScheduleRow> innerList = new ArrayList<>();
			for(Section sec : doubleTimes.get(i)) {
				sec.addToScheduleRow(innerList);
			}
			//Jack, add the new time availability for when people have classes here where the null is
			outerList.add(new Schedule((ScheduleRow[]) innerList.toArray(), null));
		}
		return (Schedule[]) outerList.toArray();
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
	   
	   public static Map<String, Section> parseDbsCreateSections(){
		   List<String[]> list = Database.getdbAllRow(Database.CPESECSQL, Database.CSCSECSQL);
		   HashMap<String, Section> hashMapInit = new HashMap<>();
		   for(int i=0; i< list.size(); i++) {
			   Section currSection = createSection(list.get(i));
			   String currKey = list.get(i)[0].substring(0, 10);
			   if(checkLab(hashMapInit, currSection)) {
				   hashMapInit.put(currKey, currSection);
			   }
		   }
		   return hashMapInit;
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
	   
	public static Map<DoubleTimes, List<Section>> classesByTime(Map<String, Section> hashMapInit){
		HashMap<logic.DoubleTimes, List<Section>> hashMapTime = new HashMap<>();
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
	public static List<logic.DoubleTimes> sortByKey(Map<logic.DoubleTimes, List<Section>> hashmap) {
		Set<logic.DoubleTimes> keys = hashmap.keySet();
		List<logic.DoubleTimes> sortedList = keys.stream().collect(Collectors.toList());
		Collections.sort(sortedList, (t1, t2) -> t1.compareTo(t2)); 
		return sortedList;
	}
	   
	public void filterAvailableClass(Map<String, Section> hashmap) {
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
	public static List<List<DoubleTimes>> greedySchedule(int numOfClasses, List<DoubleTimes> doubleTimesList){
		//n is the number of classes (all classes default to 4 units)
		//d is the list of DoubleTimes?
		int listSize = doubleTimesList.size();
		List<List<DoubleTimes>> mySchedule = new ArrayList<>();
		//I'm not sure if this will give all options, but it should give at least every different time as an option
		for(int i = 0; i < listSize; i++) {
			List<DoubleTimes> temp = greedyHelper(numOfClasses, i, doubleTimesList);
			if(temp.size() == numOfClasses) {
				mySchedule.add(temp);
			}
		}
		return mySchedule;
	}
	   
	public static List<DoubleTimes> greedyHelper(int numOfClasses, int currentIndex, List<DoubleTimes> doubleTimesList){
		int listSize = doubleTimesList.size();
		List<DoubleTimes> schedule = new ArrayList<>();
		schedule.add(doubleTimesList.get(currentIndex));
		for(int j = currentIndex + 1; j < listSize + currentIndex; j++) {
			if(j < listSize && allCompatible(schedule, doubleTimesList.get(j))) {
				schedule.add(doubleTimesList.get(j));
				if(schedule.size() >= numOfClasses) {
					return schedule; //stop because this is an optimal solution
				}
			} else if(j >= listSize && allCompatible(schedule, doubleTimesList.get(j - currentIndex - 1))){//loop back around
				schedule.add(doubleTimesList.get(j - currentIndex - 1));
				if(schedule.size() >= numOfClasses) {
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
	   	
	public static List<List<Section>> getPotentialSchedules(Map<DoubleTimes, List<Section>> hashmap, List<List<DoubleTimes>> listDoubleTimes) {
		List<List<Section>> schedules = new ArrayList<>();
		List<List<Section>> temps = new ArrayList<>();
		for (int i = 0; i < listDoubleTimes.size(); i++) {
			for (int k = 0; k < listDoubleTimes.get(i).size(); k++) {
				temps.add(hashmap.get(listDoubleTimes.get(i).get(k)));
			}
			for (int j = 0; j < getCombos(temps, 0).size(); j++) {
				schedules.add(getCombos(temps, 0).get(j));
			}
		}
		return schedules;
	}

	
	// i is used for recursion, for the initial call this should be 0
	private static List<List<Section>> getCombos(List<List<Section>> input, int i) {
		
		// stop condition
		if(i == input.size()) {
			// return a list with an empty list
			List<List<Section>> result = new ArrayList<>();
			result.add(new ArrayList<Section>());
			return result;
		}
		
		List<List<Section>> result = new ArrayList<>();
		List<List<Section>> recursive = getCombos(input, i+1); // recursive call
		
		// for each element of the first list of input
		for(int j = 0; j < input.get(i).size(); j++) {
			// add the element to all combinations obtained for the rest of the lists
			for(int k = 0; k < recursive.size(); k++) {
				// copy a combination from recursive
				List<Section> newList = new ArrayList<>();
				for(Section section : recursive.get(k)) {
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
	public static List<List<Section>> getFirstSchedules(Map<DoubleTimes, List<Section>> hashmap, List<List<DoubleTimes>> listDoubleTimes) {
		List<List<Section>> schedules = new ArrayList<>();
		List<Section> schedule = new ArrayList<>();
		for (int i = 0; i < listDoubleTimes.size(); i++) {
			for (int j = 0; j < listDoubleTimes.get(i).size(); j++) {
				schedule.add(hashmap.get(listDoubleTimes.get(i).get(j)).get(0));
			}
			schedules.add(schedule);
		}
		return schedules;
	}


	// filter out schedules with duplicate courses
	public void filterPotentialSchedules(List<List<Section>> potentialSchedule) {
		Set<String> names = new HashSet<>();
		int[] arr = new int[potentialSchedule.size()];
		int count = 0;
		for (int i = 0; i < potentialSchedule.size(); i++) {
			for (int j = 0; j < potentialSchedule.get(i).size(); j++) {
				if (!names.add(potentialSchedule.get(i).get(j).getName())) {
					arr[count++]= i;
				}
			}
			names = new HashSet<>();
		}
		for (int i = 0; i < count; i++) {
			potentialSchedule.remove(arr[i]);
		}
	}

	   // return a string for database for schedules

}
