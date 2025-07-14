package com.saludsystem.submodules;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(scanBasePackages = {
//		"com.saludsystem.infrastructure",
//		"com.saludsystem.application",
//		"com.saludsystem.domain"
//})
//@EnableJpaRepositories(basePackages = "com.saludsystem.infrastructure.adapter.jparepository") // ✅
//@EntityScan(basePackages = "com.saludsystem.infrastructure.adapter.entity") // ✅ o donde esté UserEntity
@SpringBootApplication
public class SysSaludApplication {
	public static void main(String[] args) {
		SpringApplication.run(SysSaludApplication.class, args);
	}
}