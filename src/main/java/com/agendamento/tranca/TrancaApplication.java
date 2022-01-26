package com.agendamento.tranca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages="com.agendamento.tranca.repository")
@EnableAutoConfiguration
@EntityScan(basePackages="com.agendamento.tranca.model")
@ComponentScan(basePackages="com.agendamento.tranca.controllers")
@SpringBootApplication
public class TrancaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrancaApplication.class, args);
	}

}
