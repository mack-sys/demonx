package com.example.live.demox;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.live.entity.DemonUser;
import com.example.live.repository.DemonUserRepo;

@SpringBootApplication
@RestController
@RequestMapping("/api/users")
@EnableJpaRepositories(basePackages = "com.example.live.repository")
@EntityScan(basePackages = "com.example.live.entity")
public class DemoxApplication {
	
	@Autowired
	private DemonUserRepo demonUserRepo;

	public static void main(String[] args) {
		SpringApplication.run(DemoxApplication.class, args);
	}
	
	@GetMapping("/")
	public String test() {
		return "Demox project working!!";
	}
	
	@PostMapping("/save")
	public DemonUser saveUser(@RequestBody DemonUser user) {
		demonUserRepo.save(user);
		return user;
	}
	
	@GetMapping("/list")
	public List<DemonUser> getAllUser(){
		return demonUserRepo.findAll();
	}

}
