package com.ztysdmy.authenticationservice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ztysdmy.authenticationservice.model.UserDetails;

@RestController
public class UserController {

	@RequestMapping(value= {"/user/auth"}, produces = "application/json")
	public Authentication user(OAuth2Authentication user) {
		return user.getUserAuthentication();
	}
	
}
