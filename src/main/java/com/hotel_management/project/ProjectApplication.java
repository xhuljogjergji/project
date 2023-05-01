package com.hotel_management.project;

import com.hotel_management.project.entity.user.User;
import com.hotel_management.project.entity.user.UserRole;
import com.hotel_management.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectApplication   {
	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

}
