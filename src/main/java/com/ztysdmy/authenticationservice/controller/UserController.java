package com.ztysdmy.authenticationservice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@RequestMapping(value= {"/user"}, produces = "application/json")
	public Map<String, String> user(OAuth2Authentication user) {
		
		HashMap<String, String> result = new HashMap<>();
		result.put("user", user.toString());
		return result;
	}
	
}
