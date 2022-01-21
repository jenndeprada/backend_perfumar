package com.perfumar.perfumar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@SpringBootApplication
public class PerfumarApplication {

	private static Logger log = LogManager.getLogger(PerfumarApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PerfumarApplication.class, args);



	}

}
