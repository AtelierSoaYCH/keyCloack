package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

@SpringBootApplication
@RestController()
@RequestMapping("/plant")

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public ApplicationRunner run(PlantRepository plantRepository) throws Exception {
		return (ApplicationArguments args) -> {
			List<Plant> plants = Arrays.asList(
					new Plant("subalpine fir", "abies lasiocarpa", "pinaceae"),
					new Plant("sour cherry", "prunus cerasus", "rosaceae"),
					new Plant("asian pear", "pyrus pyrifolia", "rosaceae"));
			plantRepository.saveAll(plants);
		};
	}

	@GetMapping("/test")
	public String test() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Jwt jwt = (Jwt) auth.getPrincipal();
		System.out.println(jwt.getClaimAsString("email"));
		System.out.println(jwt.getClaimAsString("preferred_username"));
		System.out.println(jwt.getClaimAsString("family_name"));
		System.out.println(jwt.getClaimAsString("scope"));
		return jwt.getClaimAsString("email");
	}

}
