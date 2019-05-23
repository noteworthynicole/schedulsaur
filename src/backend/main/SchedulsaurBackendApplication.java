package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"services"})
public class SchedulsaurBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulsaurBackendApplication.class, args);
	}

}
