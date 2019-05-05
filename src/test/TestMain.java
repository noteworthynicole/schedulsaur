package test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;
import java.util.*;

import org.junit.Test;
import logic.Main;
import logic.Section;

public class TestMain {
	
	private String name1 = "name1";
	private String name2 = "name2";
	List<String> fields1 = Arrays.asList(name1, "id1", "Lec", "prof1", "building1", "20", "11", "0");
	List<String> fields2 = Arrays.asList(name2, "id2", "Lec", "prof2", "building2", "10", "0", "4");
	List<String> fields3 = Arrays.asList(name1, "id1", "Lec", "prof3", "building3", "11", "11", "0");
	List<String> fields4 = Arrays.asList(name2, "id2", "Lec", "prof4", "building4", "10", "14", "4");
	private Section sec1 = new Section(null, fields1);
	private Section sec2 = new Section(null, fields2); 
	private Section sec3 = new Section(null, fields3);
	private Section sec4 = new Section(null, fields4); 
	
	@SuppressWarnings("static-access")
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
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testParseParameters() {
		Main main = new Main();
		main.inputFile = null;
		String[] args = {"testfile.csv"};
		main.parseParameters(args);
		assertTrue(main.inputFile != null);
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
