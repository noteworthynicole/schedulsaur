package test;

import static org.junit.Assert.*;

import java.util.*;

import logic.*;

import org.junit.Test;

public class TestScheduleRow {
	
	String name1 = "CSC-309-01";
	String name2 = "name2";
	List<String> fields1 = Arrays.asList(name1, "id1", "Lec", "prof1", "building1", "20", "11", "0", "1");
	List<String> fields2 = Arrays.asList(name2, "id2", "Lec", "prof2", "building2", "10", "0", "4", "2");
	List<String> fields3 = Arrays.asList(name1, "id1", "Lec", "prof3", "building3", "11", "11", "0", "3");
	List<String> fields4 = Arrays.asList(name2, "id2", "Lec", "prof4", "building4", "10", "14", "4", "4");
	Section sec1 = new Section(new DoubleTimes("MTRF", "11:10 AM", "02:00 PM"), fields1);
	Section sec2 = new Section(new DoubleTimes("MTRF", "12:10 AM", "03:00 PM"), fields2); 
	Section sec3 = new Section(new DoubleTimes("MWF", "09:10 AM", "10:00 AM"), fields3);
	Section sec4 = new Section(new DoubleTimes("MWF", "01:10 PM", "02:00 PM"), fields4); 
	
	@Test
	public void testConvert() {
		List<Section> sections = new ArrayList<>();
		sections.add(sec1);
		List<ScheduleRow> sr = new ArrayList<>();
		for(Section section : sections) {
			section.addToScheduleRow(sr);
		}
		assertEquals(1, sr.size());
	}
	
	@Test
	public void testConvert2() {
		List<Section> sections = new ArrayList<>();
		Section secOne = sec1;
		secOne.addClass(sec2);
		sections.add(secOne);
		List<ScheduleRow> sr = new ArrayList<>();
		for(Section section : sections) {
			section.addToScheduleRow(sr);
		}
		assertEquals(2, sr.size());
	}
	
	@Test
	public void testConvert3() {
		List<Section> sections = new ArrayList<>();
		Section secOne = sec1;
		secOne.addClass(sec2);
		Section secTwo = sec3;
		secTwo.addClass(sec4);
		sections.add(secOne);
		sections.add(secTwo);
		List<ScheduleRow> sr = new ArrayList<>();
		for(Section section : sections) {
			section.addToScheduleRow(sr);
		}
		assertEquals(4, sr.size());
	}
	
	@Test
	public void testConvert4() {
		List<Section> sections = new ArrayList<>(Arrays.asList(sec1, sec2, sec3, sec4));
		List<ScheduleRow> sr = new ArrayList<>();
		for(Section section : sections) {
			section.addToScheduleRow(sr);
		}
		assertEquals(4, sr.size());
	}
}
