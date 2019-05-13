package test;

import static org.junit.Assert.*;
import java.util.*;

import logic.DoubleTimes;
import logic.GenerateSchedules;
import logic.Section;
import org.junit.Test;

public class TestGenerateSchedules {
	
	public test.TestSection ts = new test.TestSection();
	
	String mwf = "MWF";
	String tr = "TR";
	String mtrf = "MWRF";
	String one = "01:00 PM";
	String two = "02:00 PM";
	String seven = "07:10 AM";
	String eight = "08:10 AM";
	String nine = "09:00 AM";
	String ten = "10:10 AM";
	String eleven = "11:10 AM";
	
	DoubleTimes time1 = new DoubleTimes(mwf, seven, nine);
	DoubleTimes time2 = new DoubleTimes(mwf, eight, nine);
	DoubleTimes time3 = new DoubleTimes(tr, eight, nine);
	DoubleTimes time4 = new DoubleTimes(tr, ten, eleven);
	DoubleTimes time5 = new DoubleTimes(mwf, ten, eleven);
	DoubleTimes time6 = new DoubleTimes(mtrf, eight, eleven);
	DoubleTimes time7 = new DoubleTimes(tr, one, two);
	
	@Test
	public void testSort1() {
		HashMap<DoubleTimes, List<Section>> hashMap = new HashMap<>();
		hashMap.put(time1, null);
		hashMap.put(time2, null);
		hashMap.put(time3, null);
		List<DoubleTimes> output = GenerateSchedules.sortByKey(hashMap);
		assertTrue(output.get(0).compareTo(output.get(1)) < 1);
	}
	
	@Test
	public void testSort2() {
		HashMap<DoubleTimes, List<Section>> hashMap = new HashMap<>();
		hashMap.put(time7, null);
		hashMap.put(time6, null);
		hashMap.put(time4, null);
		hashMap.put(time5, null);
		List<DoubleTimes> output = GenerateSchedules.sortByKey(hashMap);
		assertTrue(output.get(0).compareTo(output.get(1)) < 1);
	}
	
	@Test
	public void testGreedyHelper1() {
		List<DoubleTimes> original = Arrays.asList(time1, time2, time3, time4, time5, time6, time7);
		List<DoubleTimes> output = GenerateSchedules.greedyHelper(4, 6, original); //should start at the end
		assertTrue(output.contains(time1));
	}
	
	@Test
	public void testGreedyHelper2() {
		List<DoubleTimes> original = Arrays.asList(time1, time2, time3, time4, time5, time6, time7);
		List<DoubleTimes> output = GenerateSchedules.greedyHelper(4, 0, original); //should start at the beginning
		assertTrue(output.contains(time5));
	}
	
	@Test
	public void testGreedy1() {
		List<DoubleTimes> original = Arrays.asList(time1, time2, time3, time4, time5, time6, time7);
		List<List<DoubleTimes>> output = GenerateSchedules.greedySchedule(4, original);
		assertEquals(3, output.size());
	}
	
	@Test
	public void testGreedy2() {
		List<DoubleTimes> original = Arrays.asList(time1, time2, time3, time4, time5, time6, time7);
		List<List<DoubleTimes>> output = GenerateSchedules.greedySchedule(3, original);
		assertEquals(5, output.size());
	}
	
	@Test
	public void testGreedy3() {
		List<DoubleTimes> original = Arrays.asList(time1, time2, time3, time4, time5, time6, time7);
		List<List<DoubleTimes>> output = GenerateSchedules.greedySchedule(2, original);
		assertEquals(7, output.size());
	}
	
	@Test
	public void testAllCompatible1() {
		List<DoubleTimes> original = Arrays.asList(time1, time3);
		assertFalse(GenerateSchedules.allCompatible(original, time2));
	}
	
	@Test
	public void testAllCompatible2() {
		List<DoubleTimes> original = Arrays.asList(time1, time3);
		assertTrue(GenerateSchedules.allCompatible(original, time4));
	}
	
	@Test
	public void testCreateSection() {
		String[] line = new String[] {"CSC-309-02-2194", "6799", "Lab", "Falessi, D", "MWF", "11:10 AM", "12:00 PM", "N/A", "27", "25", "2", "3"};
		Section sec = GenerateSchedules.createSection(line);
		assertTrue("6799".equals(sec.getNum()));
	}
	
	@Test
	public void testFilterClassName(){
		GenerateSchedules main = new GenerateSchedules();
		HashMap<String, Section> hashmap = new HashMap<>();
		hashmap.put("CSC-309-01", ts.sec1);
		hashmap.put("CSC-309-03", ts.sec2);
		main.filterClassName(hashmap, ts.name1);
		assertFalse(hashmap.containsKey("CSC-309-01"));
	}
	
	@Test
	public void testFilerAvailableClass1(){
		GenerateSchedules schedule = new GenerateSchedules();
		HashMap<String, Section> hashmap = new HashMap<>();
		hashmap.put(ts.name1, ts.sec1);
		hashmap.put(ts.name2, ts.sec2);
		schedule.filterAvailableClass(hashmap);
		assertEquals(2, hashmap.size());
	}
	
	@Test
	public void testFilerAvailableClass2(){
		GenerateSchedules schedule = new GenerateSchedules();
		HashMap<String, Section> hashmap = new HashMap<>();
		hashmap.put(ts.name1, ts.sec3);
		hashmap.put(ts.name2, ts.sec4);
		schedule.filterAvailableClass(hashmap);
		assertEquals(0, hashmap.size());
	}
	
}
