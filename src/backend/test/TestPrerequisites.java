package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import logic.*;

public class TestPrerequisites {

	private Catalog cat1 = new Catalog(new ArrayList<>(Arrays.asList(
			"CSC 101", "Fundamentals of Computer Science", "4 units", "Graded", "F, W, SP", "MATH 117 || MATH 118", "1")));
	private Catalog cat2 = new Catalog(new ArrayList<>(Arrays.asList(
			"CSC 466", "Knowledge Discovery from Data",	"4 units", "Graded", "F, SP", "CSC 349 && (STAT 302 || STAT 312 || STAT 321 || STAT 350)", "2")));
	private List<Catalog> catalogs = new ArrayList<>(Arrays.asList(cat1, cat2));
	private List<String> classesTaken1 = new ArrayList<>(Arrays.asList("MATH 118", "CSC 349"));
	
	
	@Test
	public void testNoClassesTaken() {
		List<Catalog> testCatalogs = new ArrayList<>();
		testCatalogs.addAll(catalogs);
		Prerequisites.replaceBooleanClasses(testCatalogs, new ArrayList<>());
		assertTrue(testCatalogs.isEmpty());
	}
	
	@Test
	public void testOnlyOneClass() {
		List<Catalog> testCatalogs = new ArrayList<>();
		testCatalogs.addAll(catalogs);
		Prerequisites.replaceBooleanClasses(testCatalogs, classesTaken1);
		assertEquals(1, testCatalogs.size());
	}
	
	@Test
	public void testTwoClass1() {
		List<Catalog> testCatalogs = new ArrayList<>();
		testCatalogs.addAll(catalogs);
		List<String> classesTaken2 = new ArrayList<>();
		classesTaken2.addAll(classesTaken1);
		classesTaken2.add("STAT 312");
		Prerequisites.replaceBooleanClasses(testCatalogs, classesTaken2);
		assertEquals(2, testCatalogs.size());
	}
	
	@Test
	public void testTwoClass2() {
		List<Catalog> testCatalogs = new ArrayList<>();
		testCatalogs.addAll(catalogs);
		List<String> classesTaken2 = new ArrayList<>();
		classesTaken2.addAll(classesTaken1);
		classesTaken2.add("STAT 312");
		classesTaken2.remove(0);
		Prerequisites.replaceBooleanClasses(testCatalogs, classesTaken2);
		assertEquals(1, testCatalogs.size());
	}
}
