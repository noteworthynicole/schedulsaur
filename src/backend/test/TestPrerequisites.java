package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.*;

import org.junit.Test;

import logic.*;

public class TestPrerequisites {

	private Catalog cat1 = new Catalog(new ArrayList<>(Arrays.asList(
			"CSC 101", "Fundamentals of Computer Science", "4 units", "Graded", "F, W, SP", "MATH 117 || MATH 118", "1")));
	private Catalog cat2 = new Catalog(new ArrayList<>(Arrays.asList(
			"CSC 466", "Knowledge Discovery from Data",	"4 units", "Graded", "F, SP", "CSC 349 && (STAT 302 || STAT 312 || STAT 321 || STAT 350)", "2")));
	private List<Catalog> catalogs = new ArrayList<>(Arrays.asList(cat1, cat2));
	private List<String> classesTaken1 = new ArrayList<>(Arrays.asList("MATH 118", "CSC 349"));
	private List<String> fields1 = Arrays.asList("CSC 466-01", "id1", "Lec", "prof1", "building1", "20", "11", "0", "1");
	private Section sec1 = new Section(null, fields1);
	private List<String> fields2 = Arrays.asList("CSC 466-01", "id1", "Lec", "prof1", "building1", "20", "11", "0", "1");
	
	@Test
	public void testRemovePastClasses1() {
		Map<String, Section> sections = new HashMap<>();
		sections.put(sec1.getName(), sec1);
		List<Catalog> catalogs2 = new ArrayList<>();
		catalogs2.add(cat1);
		catalogs2.add(cat2);
		Prerequisites.removeClassesTaken(sections, catalogs);
		assertTrue(sections.isEmpty());
	}
	
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
