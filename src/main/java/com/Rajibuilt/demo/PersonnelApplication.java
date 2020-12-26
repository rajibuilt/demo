package com.Rajibuilt.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PersonnelApplication<name> {


	private String name;



	public static void main(String[] args) {
		SpringApplication.run(PersonnelApplication.class, args);
	}




}
