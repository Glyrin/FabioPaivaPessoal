package com.example.web1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Web1Application {

	public static void main(String[] args) {
		System.out.println("***************************************\nA iniciar a aplicação...");
		System.out.println("***************************************");
		SpringApplication.run(Web1Application.class, args);
		System.out.println("\n***************************************");
		System.out.println("Pode utilizar o website...\n***************************************");
	}
}
