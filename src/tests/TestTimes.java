package tests;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Test;
import logic.Times;

public class TestTimes {

	@Test
	public void testTimesMorning() {
		Times myTime = new Times("MWF", "08:10 AM", "09:00 AM");
		LocalTime expTime = LocalTime.of(8, 10);
		assertEquals(expTime, myTime.startTime);
	}
	
	@Test
	public void testTimesAfter() {
		Times myTime = new Times("TR", "04:10 PM", "05:00 PM");
		LocalTime expTime = LocalTime.of(4, 10);
		assertEquals(expTime, myTime.startTime);
	}
	
	@Test
	public void testTimesNoonStart() {
		Times myTime = new Times("TR", "12:10 PM", "01:00 PM");
		LocalTime expTime = LocalTime.of(12, 10);
		assertEquals(expTime, myTime.startTime);
	}
	
	@Test
	public void testTimesNoonEnd() {
		Times myTime = new Times("TR", "11:10 AM", "12:00 PM");
		LocalTime expTime = LocalTime.of(12, 10);
		assertEquals(expTime, myTime.endTime);
	}
	
	@Test
	public void testTimesNA() {
		Times myTime = new Times("N/A", "N/A", "N/A");
		assertEquals(null, myTime.endTime);
	}
	
	@Test
	public void testTimesOverlapDays() {
		Times time1 = new Times("TR", "08:10 AM", "11:00 PM");
		Times time2 = new Times("TR", "09:10 AM", "10:00 PM");
		assertTrue(time1.overlap(time2));
	}
	
	@Test
	public void testTimesNotOverlapDays() {
		Times time1 = new Times("TR", "08:10 AM", "11:00 PM");
		Times time2 = new Times("MWF", "09:10 AM", "10:00 PM");
		assertFalse(time1.overlap(time2));
	}
	
}
