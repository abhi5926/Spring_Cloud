package com.example.SpringJDBCDemoProject;

import com.example.SpringJDBCDemoProject.model.Alien;
import com.example.SpringJDBCDemoProject.repo.AlienRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcDemoProjectApplication {

	public static void main(String[] args) {

		ApplicationContext context =SpringApplication.run(SpringJdbcDemoProjectApplication.class, args);

		Alien alien1 = context.getBean(Alien.class);
		alien1.setId(11);
		alien1.setName("Abhishek");
		alien1.setTech("java");

		AlienRepo repo = context.getBean(AlienRepo.class);
		repo.save(alien1);

		System.out.println(repo.findAll());

	}

}
