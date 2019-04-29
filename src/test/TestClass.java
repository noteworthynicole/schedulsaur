package test;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;
import logic.Class;

public class TestClass {

	private String csc309 = "CSC-309-01";
	
	@Test
	public void testClassStringNoPreReq() {
		Class testClass = new Class(csc309);
		assertTrue(testClass.getName().contains(csc309));
	}
	
	@Test
	public void testClassStringWithPreReq() {
		String name2 = "CSC-308-01";
		ArrayList<Class> prerec = new ArrayList<>();
		prerec.add(new Class(name2));
		prerec.add(new Class(name2));
		Class testClass = new Class(csc309, prerec);
		assertTrue(testClass.toString().contains(name2));
	}

	
}
