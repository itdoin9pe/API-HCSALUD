package com.saludSystem;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
@SpringBootApplication(scanBasePackages = "com.saludSystem")
public class SysSaludApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().load();
		dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
		SpringApplication.run(SysSaludApplication.class, args);
	}
}
