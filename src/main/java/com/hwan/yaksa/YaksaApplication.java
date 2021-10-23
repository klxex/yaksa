package com.hwan.yaksa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class YaksaApplication {

	public static void main(String[] args) {
		SpringApplication.run(YaksaApplication.class, args);
	}

}
