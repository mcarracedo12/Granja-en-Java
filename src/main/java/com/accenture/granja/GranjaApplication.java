package com.accenture.granja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.accenture.granja.ui.GranjaUI;

@SpringBootApplication
public class GranjaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GranjaApplication.class, args);
		GranjaUI granjaUi = new GranjaUI();
		granjaUi.start();
	}
}
