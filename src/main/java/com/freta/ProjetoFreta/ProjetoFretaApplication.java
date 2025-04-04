package com.freta.ProjetoFreta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.freta"})
@EnableJpaRepositories(basePackages = {"com.freta.Repository"})
@EntityScan(basePackages = {"com.freta.Entity"})
public class ProjetoFretaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProjetoFretaApplication.class, args);
    }
}