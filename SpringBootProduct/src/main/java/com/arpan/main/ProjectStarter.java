package com.arpan.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.arpan"})
@EnableJpaRepositories("com.arpan.repository")
@EntityScan("com.arpan.beans")
public class ProjectStarter{

	public static void main(String[] args) {
		    SpringApplication.run(ProjectStarter.class, args);
	}

}
