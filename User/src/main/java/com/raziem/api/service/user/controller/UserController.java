package com.raziem.api.service.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class UserController {
	
	@GetMapping(path="users")
    @ApiOperation(value = "users", nickname = "users", response = List.class)
	 @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
	            @ApiResponse(code = 201, message = "Created"), @ApiResponse(code = 400, message = "Bad Request"),
	            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	public List<String> listUser(){
		List<String> users = new ArrayList<String>();
		users.add("Edgardo");
		users.add("Pedro");
		users.add("Juan");		
		return users;
	}
}
