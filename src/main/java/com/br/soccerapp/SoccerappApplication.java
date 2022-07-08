package com.br.soccerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SoccerappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoccerappApplication.class, args);
	}

}
