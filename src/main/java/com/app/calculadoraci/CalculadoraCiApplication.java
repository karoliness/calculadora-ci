package com.app.calculadoraci;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalculadoraCiApplication {
	private static final Logger logger = LoggerFactory.getLogger(CalculadoraCiApplication.class);

	public static void main(String[] args) {
		double numero1= 5f;
		double numero2= 3f;
		var calculadora = new Calculadora(numero1,numero2);
	
		SpringApplication.run(CalculadoraCiApplication.class, args);
		logger.info("A soma de {} e {} é: {}", numero1, numero2, calculadora.soma());
	}

}
