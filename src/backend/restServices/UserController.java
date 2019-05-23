package restServices;

import java.io.IOException;

import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonMappingException;

import logic.User;

@RestController
public class UserController {
	
	/* Have to use this CrossOrigin annotation, otherwise browser will not allow HTTP requests */
	@CrossOrigin(origins = RESTURI.EXTERNAL_DOMAIN)
	/* http://localhost:8080/hello */
	@GetMapping(RESTURI.GET_SAMPLE_USER) 
	public User getSampleUser() { 
		/* This is where the database will be accessed, and the proper user info returned */
		return new User("Davide Falessi", "CS", null, "2016-2017", "Spring", 16);
	}
	
	@CrossOrigin(origins = RESTURI.EXTERNAL_DOMAIN)
	@PostMapping(RESTURI.POST_USER) 
	public void userPost(@RequestBody User user) throws JsonParseException, JsonMappingException, IOException {
			
		/* This is where a connection to the DB is established and info is updated
		 * 
		 * On success return 200
		 *  */
		System.out.println(user.getName());
	}

}
