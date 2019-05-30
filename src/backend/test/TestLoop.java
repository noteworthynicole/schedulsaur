package test;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;
import logic.*;

public class TestLoop {

	@Test
	public void testNoLoopBody() {
		ScheduleRow[][] schedules = GenerateSchedules.listsOfSchedules(new ArrayList<>());
		assertEquals(0, schedules.length);
	}
	
	@Test
	public void testOneBody() {
		//List<DoubleTimes> schedule, DoubleTimes potential
		List<DoubleTimes> schedule = new ArrayList<>();
		schedule.add(new DoubleTimes("MWF", "08:10 AM", "11:00 AM"));
		DoubleTimes potential = new DoubleTimes("MW", "09:10 AM", "10:00 AM");
		boolean actual = GenerateSchedules.allCompatible(schedule, potential);
		assertFalse(actual);
	}
	
	@Test
	public void testSetNumberLoops() {
		Map<String, Section> map = GenerateSchedules.parseDbsCreateSections();
		assertFalse(map.isEmpty());
	}

}
