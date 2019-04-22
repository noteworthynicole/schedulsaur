package tests;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;
import logic.Class;

public class TestClass {

	@Test
	public void testClassStringNoPreReq() {
		String name = "CSC-309-01";
		Class testClass = new Class("CSC-309-01");
		assertTrue(testClass.toString().contains(name));
	}
	
	@Test
	public void testClassStringWithPreReq() {
		String name = "CSC-309-01";
		String name2 = "CSC-308-01";
		ArrayList<Class> prerec = new ArrayList<Class>();
		prerec.add(new Class(name2));
		Class testClass = new Class("CSC-309-01", prerec);
		assertTrue(testClass.toString().contains(name) && testClass.toString().contains(name2));
	}
	
}
