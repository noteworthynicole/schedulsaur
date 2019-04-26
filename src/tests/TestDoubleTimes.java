package tests;

import static org.junit.Assert.*;

import java.time.LocalTime;
import java.util.*;

import org.junit.Test;
import logic.DoubleTimes;
import logic.Times;

public class TestDoubleTimes {
	private DoubleTimes time1 = new DoubleTimes("MTRF", "10:10 AM", "01:00 PM");
	private DoubleTimes time2 = new DoubleTimes("MWF", "11:10 AM", "12:00 PM");
	
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
	public void testDoubleTimesEquals_Same() {
		DoubleTimes myTime1 = new DoubleTimes("MTRF", "11:10 AM", "02:00 PM");
		DoubleTimes myTime2 = new DoubleTimes("MTRF", "11:10 AM", "02:00 PM");
		assertTrue(myTime1.equals(myTime2));
	}
	
	@Test
	public void testDoubleTimesEquals_Different() {
		DoubleTimes myTime1 = new DoubleTimes("MTRF", "10:10 AM", "01:00 PM");
		DoubleTimes myTime2 = new DoubleTimes("MTRF", "11:10 AM", "02:00 PM");
		assertFalse(myTime1.equals(myTime2));
	}
	
	@Test
	public void testDoubleTimesEquals_EqualLab() {
		DoubleTimes myTime1 = new DoubleTimes("MTRF", "10:10 AM", "01:00 PM");
		DoubleTimes myTime2 = new DoubleTimes("MTRF", "10:10 AM", "01:00 PM");
		Times myLab = new Times("TH", "07:10 PM", "09:00 PM");
		myTime1.setLabTime(myLab);
		myTime2.setLabTime(myLab);
		assertTrue(myTime1.equals(myTime2));
	}
	
	@Test
	public void testDoubleTimesEquals_NullLab() {
		DoubleTimes myTime1 = new DoubleTimes("MTRF", "10:10 AM", "01:00 PM");
		DoubleTimes myTime2 = new DoubleTimes("MTRF", "10:10 AM", "01:00 PM");
		Times myLab = new Times("TH", "07:10 PM", "09:00 PM");
		myTime2.setLabTime(myLab);
		assertFalse(myTime1.equals(myTime2));
	}
}
