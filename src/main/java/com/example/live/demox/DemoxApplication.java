package com.example.live.demox;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/api/users")
public class DemoxApplication {
	
	@Autowired
	private DemonUserRepo demonUserRepo;

	public static void main(String[] args) {
		SpringApplication.run(DemoxApplication.class, args);
	}
	
	@GetMapping("/")
	public String test() {
		return "Demox project working";
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
