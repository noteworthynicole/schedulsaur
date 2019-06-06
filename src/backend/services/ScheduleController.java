package services;


import java.util.Arrays;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import logic.GenerateSchedules;
import logic.Schedule;

@RestController
public class ScheduleController {
	private Schedule[] potentialSchedules = null;
	int head = 0;
	int tail = 10;

	@CrossOrigin(origins = RESTURI.EXTERNAL_DOMAIN)
	@GetMapping(RESTURI.GET_SCHEDULES)
	public Schedule[] getSchedules(@PathVariable String studentId, @PathVariable String availNum) {
		potentialSchedules = GenerateSchedules.generateSchedules();
		if(potentialSchedules.length == 0) {
			return new Schedule[] {};
		}else {
			if(potentialSchedules.length <= 10) {
				return potentialSchedules;
			}else {
				return Arrays.copyOfRange(potentialSchedules, head, tail);
			}
		}
	}
	
	@CrossOrigin(origins = RESTURI.EXTERNAL_DOMAIN)
	@GetMapping(RESTURI.GET_NEXT_SCHEDULES)
	public Schedule[] getNextSchedules() {
		if(potentialSchedules.length <= 10) {
			return potentialSchedules;
		}else {
			head += 10;
			tail += 10;
			return Arrays.copyOfRange(potentialSchedules, head, tail);
		}
	}
	
}
