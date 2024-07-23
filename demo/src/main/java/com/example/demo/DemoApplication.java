package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Bean
	CommandLineRunner init(UserRepository userRepository){
		return args -> {
			Optional<User> userOptional = userRepository.findByUsername("8804506100");
			if(userOptional.isEmpty()){
				User user = new User();
				user.setUsername("987654321");
				user.setPassword(passwordEncoder.encode("aman123"));
				user.setEmail("aman@electrowaves.com");
				user.setFirstName("Aman");
				user.setLastName("deep");
				user.setAddress("123 Main St");
				user.setCity("Delhi");
				user.setState("Delhi");
				user.setPinCode("12345");
				user.setCountry("INDIA");
				user.setRole("ADMIN");
				userRepository.save(user);
			}
		};
	}
}
