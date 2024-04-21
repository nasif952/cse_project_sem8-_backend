package com.nasifproject.pcbuilder;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@RestController
// this tell that this framework is a rest api controller
public class PcbuilderApplication implements CommandLineRunner {
	//manually to add buildlinks
	@Autowired
	private BuildsService buildsService;

	public static void main(String[] args) {
		SpringApplication.run(PcbuilderApplication.class, args);
	}
	//manually to add buildlinks
	@Override
	public void run(String... args) throws Exception {
		buildsService.addBuildLinksToAllBuilds(); // This will execute after the application starts
	}



}
