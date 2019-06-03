package test;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;
import logic.*;

public class TestCombos {
	
	private String mwf = "MWF";
	private String tr = "TR";
	private String seven = "07:10 AM";
	private String eight = "08:10 AM";
	private String nine = "09:00 AM";
	private String eleven = "11:10 AM";
	private String two = "02:00 PM";
	private String noon = "12:00 PM";
	private String one = "01:10 PM";
	
	private String name = "Falessi, D";
	private String na = "N/A";
	private String lab = "Lab";
	
	private boolean[][] expected = {{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
			{false, false, false, false, true, false, false, false, false, false, false, false, false, false, false},
			{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
			{false, false, false, false, true, false, false, false, false, false, false, false, false, false, false},
			{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
			{false, false, false, false, true, false, false, false, false, false, false, false, false, false, false},
			{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}};
	
	private DoubleTimes time1 = new DoubleTimes(mwf, seven, nine);
	private DoubleTimes time2 = new DoubleTimes(mwf, eight, nine);
	private DoubleTimes time3 = new DoubleTimes(tr, eight, nine);
	
	private String[] line1 = new String[] {"CSC-309-02-2194", "6799", lab, name, mwf, eleven, noon, na, "28", "25", "2", "5"};
	private String[] line2 = new String[] {"CSC-309-02-2195", "6798", lab, name, mwf, one, two, na, "27", "22", "1", "4"};
	private String[] line3 = new String[] {"CSC-308-02-2196", "6899", lab, name, mwf, eleven, noon, na, "29", "21", "0", "3"};
	private String[] line4 = new String[] {"CSC-308-02-2197", "6398", lab, name, mwf, one, two, na, "26", "20", "8", "2"};
	
	@Test
	public void testCombo1() {
		Section sec1 = GenerateSchedules.createSection(line1);
		Section sec2 = GenerateSchedules.createSection(line2);
		Section sec3 = GenerateSchedules.createSection(line3);
		Section sec4 = GenerateSchedules.createSection(line4);
		List<List<Section>> sections = new ArrayList<>();
		List<Section> section1 = new ArrayList<>();
		List<Section> section2 = new ArrayList<>();
		section1.add(sec1);
		section1.add(sec2);
		sections.add(section1);
		section2.add(sec3);
		section2.add(sec4);
		sections.add(section2);
		List<List<Section>> output = GenerateSchedules.getCombos(sections, 0);
		assertTrue(output.size() == 4);
	}
	
	@Test
	public void testCombo2() {
		Section sec1 = GenerateSchedules.createSection(line1);
		Section sec2 = GenerateSchedules.createSection(line2);
		Section sec3 = GenerateSchedules.createSection(line3);
		Section sec4 = GenerateSchedules.createSection(line4);
		List<List<Section>> sections = new ArrayList<>();
		List<Section> section1 = new ArrayList<>();
		section1.add(sec1);
		section1.add(sec2);
		section1.add(sec3);
		section1.add(sec4);
		sections.add(section1);
		List<List<Section>> output = GenerateSchedules.getCombos(sections, 0);
		assertTrue(output.size() == 4);
	}
	
	@Test
	public void testPotential1() {
		HashMap<DoubleTimes, List<Section>> hashMap = new HashMap<>();
		List<List<DoubleTimes>> dts = new ArrayList<>();
		List<DoubleTimes> dt1 = new ArrayList<>();
		List<DoubleTimes> dt2 = new ArrayList<>();
		List<DoubleTimes> dt3 = new ArrayList<>();
		List<Section> section1 = new ArrayList<>();
		List<Section> section2 = new ArrayList<>();
		List<Section> section3 = new ArrayList<>();
		Section sec1 = GenerateSchedules.createSection(line1);
		Section sec2 = GenerateSchedules.createSection(line2);
		section1.add(sec1);
		section1.add(sec2);
		section2.add(sec1);
		section2.add(sec2);
		section3.add(sec1);
		section3.add(sec2);
		hashMap.put(time1, section1);
		hashMap.put(time2, section2);
		hashMap.put(time3, section3);
		dt1.add(time1);
		dts.add(dt1);
		dt2.add(time2);
		dts.add(dt2);
		dt3.add(time3);
		dts.add(dt3);
		List<List<Section>> output = GenerateSchedules.getPotentialSchedules(hashMap, dts);
		assertTrue(output.size() == 14);
	}
	
	@Test
	public void testPotential2() {
		HashMap<DoubleTimes, List<Section>> hashMap = new HashMap<>();
		List<List<DoubleTimes>> dts = new ArrayList<>();
		List<DoubleTimes> dt = new ArrayList<>();
		List<Section> section1 = new ArrayList<>();
		List<Section> section2 = new ArrayList<>();
		List<Section> section3 = new ArrayList<>();
		Section sec1 = GenerateSchedules.createSection(line1);
		Section sec2 = GenerateSchedules.createSection(line2);
		Section sec3 = GenerateSchedules.createSection(line3);
		Section sec4 = GenerateSchedules.createSection(line4);
		section1.add(sec1);
		section2.add(sec2);
		section2.add(sec3);
		section2.add(sec4);
		section3.add(sec1);
		section3.add(sec2);
		section3.add(sec3);
		section3.add(sec4);
		hashMap.put(time1, section1);
		hashMap.put(time2, section2);
		hashMap.put(time3, section3);
		dt.add(time1);
		dt.add(time2);
		dt.add(time3);
		dts.add(dt);
		List<List<Section>> output = GenerateSchedules.getPotentialSchedules(hashMap, dts);
		assertTrue(output.size() == 12);
	}
	
	@Test
	public void getBlockData1() {
		boolean[][] blocks = new boolean[7][15];
		for (int i = 0; i < blocks.length; i++) {
			Arrays.fill(blocks[i], false);
		}
		Section sec1 = GenerateSchedules.createSection(line1);
		GenerateSchedules.getBlockData(sec1, blocks);
		assertTrue(Arrays.deepEquals(expected, blocks));
	}
	
}