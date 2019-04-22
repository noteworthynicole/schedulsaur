package tests;

import static org.junit.Assert.*;

import java.util.*;

import logic.Section;

import org.junit.Test;

public class TestSection {

	private Section sec1 = new Section("name1", "id1", "Lec", "prof1", null, "building1");
	private Section sec2 = new Section("name2", "id2", "Lab", null, "prof2", null, "building2"); 
	
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
	
}
