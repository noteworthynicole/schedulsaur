package test;

import static org.junit.Assert.*;

import java.util.*;

import logic.Section;

import org.junit.Test;

public class TestSection {
	
	List<String> fields1 = Arrays.asList("name1", "id1", "Lec", "prof1", "building1", "0", "11", "0");
	List<String> fields2 = Arrays.asList("name2", "id2", "Lec", "prof2", "building2", "10", "0", "4");
	private Section sec1 = new Section(null, fields1);
	private Section sec2 = new Section(null, fields2); 
	
	@Test
	public void testSecionNoPrereq() {
		assertEquals(new ArrayList<>(), sec1.getPrerec());
	}
	
	@Test
	public void testSecionNoPrereqToString() {
		assertTrue(sec1.toString().contains("prof1"));
	}
	
	@Test
	public void testSecionLabToString() {
		sec1.addClass(sec2);
		assertTrue(sec1.toString().contains("building2"));
	}
	
	@Test
	public void testSecionAddClass() {
		sec1.addClass(sec2);
		assertEquals(sec1.getLab(), sec2);
	}
	
	@Test
	public void testgetInteger1() {
		int act = Section.getInteger("0");
		assertEquals(0, act);
	}
	
	@Test
	public void testgetInteger2() {
		int act = Section.getInteger("10");
		assertEquals(10, act);
	}
	
	@Test
	public void testgetInteger3() {
		int act = Section.getInteger("N/A");
		assertEquals(0, act);
	}
	
	@Test
	public void testGetEnrolled() {
		int act = sec1.getEnrolled();
		assertEquals(11, act);
	}
	
	@Test
	public void testGetEnrolled2() {
		int act = sec2.getEnrolled();
		assertEquals(0, act);
	}
	
	@Test
	public void testGetMaxCapacity1() {
		int act = sec1.getMaxCapacity();
		assertEquals(0, act);
	}
	
	@Test
	public void testGetWaitList1() {
		int act = sec1.getWaitList();
		assertEquals(0, act);
	}
	
	@Test
	public void testGetWaitList2() {
		int act = sec2.getWaitList();
		assertEquals(4, act);
	}
	
	@Test
	public void testType() {
		String act = sec1.getType();
		assertEquals("Lec", act);
	}
	
}
