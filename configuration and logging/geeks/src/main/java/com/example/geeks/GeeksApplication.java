package com.example.geeks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;

@SpringBootApplication
public class GeeksApplication implements CommandLineRunner {

	@Value("${library.books.no-of-days}")
	private int days;
	private Logger logger = LoggerFactory.getLogger(GeeksApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(GeeksApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
//		System.out.println("No of days: "+days);
		logger.error("No of days: "+days);
	}

}
