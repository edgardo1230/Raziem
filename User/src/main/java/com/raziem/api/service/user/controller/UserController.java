package com.raziem.api.service.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@GetMapping(path="users")
	public List<String> listUser(){
		List<String> users = new ArrayList<String>();
		users.add("Edgardo");
		users.add("Pedro");
		users.add("Juan");		
		return users;
	}
}
