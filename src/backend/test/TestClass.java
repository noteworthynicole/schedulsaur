package backend.test;

import static org.junit.Assert.*;

import org.junit.Test;
import backend.logic.Class;

public class TestClass {

	private String csc309 = "CSC-309-01";
	
	@Test
	public void testClassStringNoPreReq() {
		Class testClass = new Class(csc309);
		assertTrue(testClass.getName().contains("CSC-309"));
	}
	
	@Test
	public void testClassUnits() {
		Class testClass = new Class(csc309);
		testClass.setUnits(4);
		assertEquals(4, testClass.getUnits());
	}
	
	@Test
	public void testClassEquality1() {
		Class testClass1 = new Class(csc309);
		Class testClass2 = new Class(csc309);
		testClass2.setUnits(2);
		assertNotEquals(testClass1, testClass2);
	}
	
	@Test
	public void testClassEquality2() {
		Class testClass1 = new Class(csc309);
		assertNotEquals(testClass1, null);
	}
	
	@Test
	public void testClassEquality3() {
		Class testClass1 = new Class(csc309);
		Class testClass2 = new Class(csc309);
		assertEquals(testClass1, testClass2);
	}
	
	@Test
	public void testClassEquality4() {
		Class testClass1 = new Class(csc309);
		Class testClass2 = new Class("CSC-309-03");
		assertEquals(testClass1, testClass2);
	}

	
}
