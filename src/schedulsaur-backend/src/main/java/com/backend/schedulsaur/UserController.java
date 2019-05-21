package com.backend.schedulsaur;

import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.schedulsaur.*;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class UserController {
	
	/* Have to use this CrossOrigin annotation, otherwise browser will not allow HTTP requests */
	@CrossOrigin(origins = "http://localhost:3000")
	/* http://localhost:8080/hello */
	@GetMapping("/hello") 
	public User getSampleUser() { 
		/* This is where the database will be accessed, and the proper user info returned */
		return new User("Davide Falessi", "CS", null, "2016-2017", "Spring", 16);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/user") 
	public void userPost(@RequestBody User user) throws JsonParseException, JsonMappingException, IOException {
			
		/* This is where a connection to the DB is established and info is updated
		 * 
		 * On success return 200
		 *  */
		System.out.println(user.getName());
	}
	
	
	
}
