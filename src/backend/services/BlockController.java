package services;

import java.io.IOException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonMappingException;

import logic.ScheduleBlock;
import logic.User;

@RestController
public class BlockController {
	
	String[] days = {"Su", "M", "T", "W", "H", "F", "Sa"};
	boolean[][] blocks = {{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
			{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
			{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
			{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
			{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
			{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
			{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}};

	@CrossOrigin(origins = RESTURI.EXTERNAL_DOMAIN)
	@GetMapping(RESTURI.GET_SAMPLE_BLOCK)
	/* http://localhost:8080/avail */
	public ScheduleBlock getBlock() { 
		return new ScheduleBlock(013000607, 1, days, blocks);
	}
	
	@CrossOrigin(origins = RESTURI.EXTERNAL_DOMAIN)
	@PostMapping(RESTURI.POST_BLOCK) 
	public void userPost(@RequestBody User user) throws JsonMappingException, IOException {
			
		/* This is where a connection to the DB is established and info is updated
		 * 
		 * On success return 200
		 *  */
	}
}
