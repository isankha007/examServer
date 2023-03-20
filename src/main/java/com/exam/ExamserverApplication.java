package com.exam;

import com.exam.entity.Role;
import com.exam.entity.User;
import com.exam.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {

	Logger logger= LoggerFactory.getLogger(ExamserverApplication.class);

	@Autowired
    private UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		User user=new User();
		user.setFirstName("sankhadeep");
		user.setLastName("Chatterjee");
		user.setUserName("Nemo");
		user.setPassword("Nemo");
		user.setEmail("Sankhadeep2007@gmail.com");
		user.setProfilePic("default.png");
		user.setPhone("12345678");

		Role role1=new Role();
		role1.setRoleId(44L);
		role1.setRoleName("ADMIN");

		//Set<Role> userRole
		user.getRoles().add(role1);

		User user1 = userService.createUser(user);
		logger.info("User ->{}",user1);
	}
}
