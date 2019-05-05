package test;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;
import logic.*;

public class TestMain {
	
	private String name1 = "name1";
	private String name2 = "name2";
	private List<String> fields1 = Arrays.asList(name1, "id1", "Lec", "prof1", "building1", "20", "11", "0");
	private List<String> fields2 = Arrays.asList(name2, "id2", "Lec", "prof2", "building2", "10", "0", "4");
	private List<String> fields3 = Arrays.asList(name1, "id1", "Lec", "prof3", "building3", "11", "11", "0");
	private List<String> fields4 = Arrays.asList(name2, "id2", "Lec", "prof4", "building4", "10", "14", "4");
	private Section sec1 = new Section(null, fields1);
	private Section sec2 = new Section(null, fields2); 
	private Section sec3 = new Section(null, fields3);
	private Section sec4 = new Section(null, fields4);
	
	private String mwf = "MWF";
	private String tr = "TR";
	private String mtrf = "MWRF";
	private String one = "01:00 PM";
	private String two = "02:00 PM";
	private String seven = "07:10 AM";
	private String eight = "08:10 AM";
	private String nine = "09:00 AM";
	private String ten = "10:10 AM";
	private String eleven = "11:10 AM";
	
	private DoubleTimes time1 = new DoubleTimes(mwf, seven, nine);
	private DoubleTimes time2 = new DoubleTimes(mwf, eight, nine);
	private DoubleTimes time3 = new DoubleTimes(tr, eight, nine);
	private DoubleTimes time4 = new DoubleTimes(tr, ten, eleven);
	private DoubleTimes time5 = new DoubleTimes(mwf, ten, eleven);
	private DoubleTimes time6 = new DoubleTimes(mtrf, eight, eleven);
	private DoubleTimes time7 = new DoubleTimes(tr, one, two);
	
	/*@SuppressWarnings("static-access")
	@Test
	public void testMain() throws FileNotFoundException {
		Main main = new Main();
		main.inputFile = null;
		String[] args = {"testfile.csv"};
		try {
			main.main(args);
			//This should run
			assertTrue(true);
		} catch (FileNotFoundException e) {
			assertTrue(false);
		}
	}*/
	
	/*@SuppressWarnings("static-access")
	@Test
	public void testParseParameters1()  throws FileNotFoundException {
		Main main = new Main();
		main.inputFile = null;
		String[] args = {"testfile.csv"};
		main.parseParameters(args);
		assertTrue(main.inputFile != null);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testParseParameters2() throws FileNotFoundException {
		Main main = new Main();
		main.inputFile = null;
		String[] args = {"testfile.csv", "nothing"};
		try {
			main.main(args);
			assertTrue(false);
		} catch (Exception e) {
			//This should run
			assertTrue(true);
		}
	}*/
	
	@Test
	public void testSort1() {
		HashMap<DoubleTimes, List<Section>> hashMap = new HashMap<>();
		hashMap.put(time1, null);
		hashMap.put(time2, null);
		hashMap.put(time3, null);
		List<DoubleTimes> output = Main.sortByKey(hashMap);
		assertTrue(output.get(0).compareTo(output.get(1)) < 1);
	}
	
	@Test
	public void testSort2() {
		HashMap<DoubleTimes, List<Section>> hashMap = new HashMap<>();
		hashMap.put(time7, null);
		hashMap.put(time6, null);
		hashMap.put(time4, null);
		hashMap.put(time5, null);
		List<DoubleTimes> output = Main.sortByKey(hashMap);
		assertTrue(output.get(0).compareTo(output.get(1)) < 1);
	}
	
	@Test
	public void testGreedyHelper1() {
		List<DoubleTimes> original = Arrays.asList(time1, time2, time3, time4, time5, time6, time7);
		List<DoubleTimes> output = Main.greedyHelper(4, 6, original); //should start at the end
		assertTrue(output.contains(time1));
	}
	
	@Test
	public void testGreedyHelper2() {
		List<DoubleTimes> original = Arrays.asList(time1, time2, time3, time4, time5, time6, time7);
		List<DoubleTimes> output = Main.greedyHelper(4, 0, original); //should start at the beginning
		assertTrue(output.contains(time5));
	}
	
	@Test
	public void testGreedy1() {
		List<DoubleTimes> original = Arrays.asList(time1, time2, time3, time4, time5, time6, time7);
		List<List<DoubleTimes>> output = Main.greedySchedule(4, original);
		assertEquals(3, output.size());
	}
	
	@Test
	public void testGreedy2() {
		List<DoubleTimes> original = Arrays.asList(time1, time2, time3, time4, time5, time6, time7);
		List<List<DoubleTimes>> output = Main.greedySchedule(3, original);
		assertEquals(5, output.size());
	}
	
	@Test
	public void testGreedy3() {
		List<DoubleTimes> original = Arrays.asList(time1, time2, time3, time4, time5, time6, time7);
		List<List<DoubleTimes>> output = Main.greedySchedule(2, original);
		assertEquals(7, output.size());
	}
	
	@Test
	public void testAllCompatible1() {
		List<DoubleTimes> original = Arrays.asList(time1, time3);
		assertFalse(Main.allCompatible(original, time2));
	}
	
	@Test
	public void testAllCompatible2() {
		List<DoubleTimes> original = Arrays.asList(time1, time3);
		assertTrue(Main.allCompatible(original, time4));
	}
	
	@Test
	public void testCreateSection() {
		String[] line = new String[] {"CSC-309-02-2194", "6799", "Lab", "Falessi, D", "MWF", "11:10 AM", "12:00 PM", "N/A", "27", "25", "2"};
		Section sec = Main.createSection(line);
		assertTrue("6799".equals(sec.getId()));
	}
	
	@Test
	public void testFilterClassName(){
		Main main = new Main();
		HashMap<String, Section> hashmap = new HashMap<>();
		hashmap.put(name1, sec1);
		hashmap.put(name2, sec2);
		main.filterClassName(hashmap, name1);
		assertFalse(hashmap.containsKey(name1));
	}
	
	@Test
	public void testFilerAvailableClass1(){
		Main main = new Main();
		HashMap<String, Section> hashmap = new HashMap<>();
		hashmap.put(name1, sec1);
		hashmap.put(name2, sec2);
		main.filerAvailableClass(hashmap);
		assertEquals(2, hashmap.size());
	}
	
	@Test
	public void testFilerAvailableClass2(){
		Main main = new Main();
		HashMap<String, Section> hashmap = new HashMap<>();
		hashmap.put(name1, sec3);
		hashmap.put(name2, sec4);
		main.filerAvailableClass(hashmap);
		assertEquals(0, hashmap.size());
	}
	
}
