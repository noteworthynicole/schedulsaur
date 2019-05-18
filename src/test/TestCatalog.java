package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.*;

import org.junit.Test;
import logic.*;

public class TestCatalog {

	private Catalog cat1 = new Catalog(new ArrayList<>(Arrays.asList(
			"CSC 101", "Fundamentals of Computer Science", "4 units", "Graded", "F, W, SP", "MATH 117 || MATH 118", "1")));
	private Catalog cat2 = new Catalog(new ArrayList<>(Arrays.asList(
			"CSC 466", "Knowledge Discovery from Data",	"4 units", "Graded", "F, SP", "CSC 349 && (STAT 302 || STAT 312 || STAT 321 || STAT 350)", "2")));
	
	@Test
	public void testGetUnits() {
		assertEquals(4, cat1.getUnits());
	}
	
	@Test
	public void testGetName() {
		assertEquals("CSC 466", cat2.getName());
	}
	
	@Test
	public void testGetPrereq1() {
		assertFalse(cat1.getPrereq(new ArrayList<>()));
	}
	
	@Test
	public void testGetPrereq2() {
		assertTrue(cat2.getPrereq(new ArrayList<>(Arrays.asList("CSC 349", "STAT 312"))));
	}
}
