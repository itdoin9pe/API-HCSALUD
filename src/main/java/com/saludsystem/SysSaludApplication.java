package com.saludsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.saludsystem")
public class SysSaludApplication {

	public static void main(String[] args) {
		SpringApplication.run(SysSaludApplication.class, args);
	}
}