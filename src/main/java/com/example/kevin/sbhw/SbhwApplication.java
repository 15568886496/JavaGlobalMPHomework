package com.example.kevin.sbhw;

import org.junit.Test;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCrypt;

@SpringBootApplication
public class SbhwApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SbhwApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.print("hello world");
	}
}
