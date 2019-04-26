package tests;

import static org.junit.Assert.*;

import java.time.LocalTime;
import java.util.*;

import org.junit.Test;
import logic.Times;

public class TestTimes {
	
	private Times time1 = new Times("TR", "08:10 AM", "11:00 AM");
	private Times time2 = new Times("TR", "09:10 AM", "10:00 PM");
	
	@Test
	public void testTimesNull() {
		Times myTime1 = new Times("N/A", LocalTime.of(8, 10), LocalTime.of(10, 0));
		Times myTime2 = new Times("N/A", "N/A", "N/A");
		assertNotEquals(myTime1, myTime2);
	}
	
	@Test
	public void testTimesToString() {
		Times myTime = new Times("TH", "07:10 PM", "09:00 PM");
		assertTrue(myTime.toString().contains("19"));
	}

	@Test
	public void testTimesMorning() {
		Times myTime = new Times("MWF", "08:10 AM", "09:00 AM");
		LocalTime expTime = LocalTime.of(8, 10);
		assertEquals(expTime, myTime.getStartTime());
	}
	
	@Test
	public void testTimesAfter() {
		Times myTime = new Times("TR", "04:10 PM", "05:00 PM");
		LocalTime expTime = LocalTime.of(4 + 12, 10);
		assertEquals(expTime, myTime.getStartTime());
	}
	
	@Test
	public void testTimesNoonStart() {
		Times myTime = new Times("TR", "12:10 PM", "01:00 PM");
		LocalTime expTime = LocalTime.of(12, 10);
		assertEquals(expTime, myTime.getStartTime());
	}
	
	@Test
	public void testTimesNoonEnd() {
		Times myTime = new Times("TR", "11:10 AM", "12:00 PM");
		LocalTime expTime = LocalTime.of(12, 00);
		assertEquals(expTime, myTime.getEndTime());
	}
	
	@Test
	public void testTimesNA() {
		Times myTime = new Times("N/A", "N/A", "N/A");
		assertEquals(null, myTime.getEndTime());
	}
	
	@Test
	public void testTimesOverlapDays() {
		assertFalse(Times.compatible(time1, time2));
	}
	
	@Test
	public void testTimesOverlapDays2() {
		assertFalse(Times.compatible(time1, time2));
	}
	
	@Test
	public void testTimesNotOverlapDays() {
		Times mytime1 = new Times("TR", "10:10 AM", "11:00 PM");
		Times mytime2 = new Times("MWF", "09:10 AM", "10:00 PM");
		assertTrue(Times.compatible(mytime1, mytime2));
	}
	
	@Test
	public void testListTimes() {
		List<Times> list1 = new ArrayList<>();
		List<Times> list2 = new ArrayList<>();
		list1.add(time1);
		list1.add(time2);
		list2.add(time1);
		list2.add(time2);
		assertEquals(list1, list2);
	}
	
	@Test
	public void testListTimesNull() {
		List<Times> list1 = new ArrayList<>();
		List<Times> list2 = new ArrayList<>();
		list1.add(time1);
		list1.add(time2);
		list2.add(time1);
		list2.add(time2);
		assertEquals(list1, list2);
	}
	
}
