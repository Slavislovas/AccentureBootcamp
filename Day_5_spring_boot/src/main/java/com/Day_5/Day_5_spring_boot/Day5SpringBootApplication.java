package com.Day_5.Day_5_spring_boot;

import com.Day_5.Day_5_spring_boot.Model.Student;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@SpringBootApplication
public class Day5SpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day5SpringBootApplication.class, args);
	}
}
