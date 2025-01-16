package com.saludSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
@SpringBootApplication(scanBasePackages = "com.saludSystem")
public class SysSaludApplication {

	public static void main(String[] args) {
		SpringApplication.run(SysSaludApplication.class, args);
	}
}
