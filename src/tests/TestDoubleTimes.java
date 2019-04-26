package tests;

import static org.junit.Assert.*;

import java.time.LocalTime;
import java.util.*;

import org.junit.Test;
import logic.DoubleTimes;
import logic.Times;

public class TestDoubleTimes {
	private String one = "01:00 PM";
	private String seven = "07:10 PM";
	private String nine = "09:00 PM";
	private String ten = "10:10 AM";
	
	@Test
	public void testDoubleTimesGetLecStartTime() {
		DoubleTimes myTime = new DoubleTimes("MTRF", "11:10 AM", "02:00 PM");
		assertEquals(LocalTime.of(11, 10), myTime.getLecStartTime());
	}
	
	@Test
	public void testDoubleTimesGetLecEndTime() {
		DoubleTimes myTime = new DoubleTimes("MTRF", "11:10 AM", "02:00 PM");
		assertEquals(LocalTime.of(14, 00), myTime.getLecEndTime());
	}
	
	@Test
	public void testDoubleTimesGetLecDay() {
		DoubleTimes myTime = new DoubleTimes("MTRF", "11:10 AM", "02:00 PM");
		assertEquals("MTRF", myTime.getLecDay());
	}
	
	@Test
	public void testDoubleTimesToString() {
		DoubleTimes myTime = new DoubleTimes("MTRF", "11:10 AM", "02:00 PM");
		assertEquals("DoubleTimes Lec: (Time MTRF 11:10 14:00) Lab: null", myTime.toString());
	}
	
	@Test
	public void testDoubleTimesEqualsSame() {
		DoubleTimes myTime1 = new DoubleTimes("MTRF", "11:10 AM", "02:00 PM");
		DoubleTimes myTime2 = new DoubleTimes("MTRF", "11:10 AM", "02:00 PM");
		assertTrue(myTime1.equals(myTime2));
	}
	
	@Test
	public void testDoubleTimesEqualsDifferent() {
		DoubleTimes myTime1 = new DoubleTimes("MTRF", ten, one);
		DoubleTimes myTime2 = new DoubleTimes("MTRF", "11:10 AM", "02:00 PM");
		assertFalse(myTime1.equals(myTime2));
	}
	
	@Test
	public void testDoubleTimesEqualsEqualLab() {
		DoubleTimes myTime1 = new DoubleTimes("MTRF", ten, one);
		DoubleTimes myTime2 = new DoubleTimes("MTRF", ten, one);
		Times myLab = new Times("TH", seven, nine);
		myTime1.setLabTime(myLab);
		myTime2.setLabTime(myLab);
		assertTrue(myTime1.equals(myTime2));
	}
	
	@Test
	public void testDoubleTimesEqualsNullLab() {
		DoubleTimes myTime1 = new DoubleTimes("MTRF", ten, one);
		DoubleTimes myTime2 = new DoubleTimes("MTRF", ten, one);
		Times myLab = new Times("TH", seven, nine);
		myTime2.setLabTime(myLab);
		assertFalse(myTime1.equals(myTime2));
	}
	
	@Test
	public void testDoubleTimesHashCodeNullLab() {
		DoubleTimes myTime1 = new DoubleTimes("MTRF", ten, one);
		DoubleTimes myTime2 = new DoubleTimes("MTRF", ten, one);
		assertEquals(myTime1.hashCode(), myTime2.hashCode());
	}
	
	@Test
	public void testDoubleTimesHashCodeEqualLab() {
		DoubleTimes myTime1 = new DoubleTimes("MTRF", ten, one);
		DoubleTimes myTime2 = new DoubleTimes("MTRF", ten, one);
		Times myLab = new Times("TH", seven, nine);
		myTime1.setLabTime(myLab);
		myTime2.setLabTime(myLab);
		assertEquals(myTime1.hashCode(), myTime2.hashCode());
	}
	
	@Test
	public void testDoubleTimesOverlapNullLabsTrue() {
		DoubleTimes myTime1 = new DoubleTimes("MTWF", "11:10 AM", one);
		DoubleTimes myTime2 = new DoubleTimes("MTWF", "12:10 AM", one);
		assertFalse(myTime1.compatible(myTime2));
	}
	
	@Test
	public void testDoubleTimesOverlapNullLabsFalse() {
		DoubleTimes myTime1 = new DoubleTimes("MW", "11:10 AM", one);
		DoubleTimes myTime2 = new DoubleTimes("MW", "01:10 PM", "02:00 PM");
		assertTrue(myTime1.compatible(myTime2));
	}
	
	@Test
	public void testDoubleTimes_Overlap_Labs() {
		DoubleTimes myTime1 = new DoubleTimes("MW", "11:10 AM", one);
		DoubleTimes myTime2 = new DoubleTimes("MW", "01:10 PM", "02:00 PM");
		Times myLab = new Times("TH", seven, nine);
		myTime1.setLabTime(myLab);
		myTime2.setLabTime(myLab);
		assertFalse(myTime1.compatible(myTime2));
	}
}
