package com.loader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
		"com.saludsystem.infrastructure",
		"com.saludsystem.application",
		"com.saludsystem.domain"
})
@EnableJpaRepositories(basePackages = "com.saludsystem.infrastructure.adapter.jparepository") // ✅
@EntityScan(basePackages = "com.saludsystem.infrastructure.adapter.entity") // ✅ o donde esté UserEntity
public class SysSaludApplication {
	public static void main(String[] args) {
		SpringApplication.run(SysSaludApplication.class, args);
	}
}