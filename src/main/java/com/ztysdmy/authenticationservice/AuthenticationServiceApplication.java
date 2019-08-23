package com.ztysdmy.authenticationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
/**
 * https://stackoverflow.com/questions/49601371/spring-boot-oauth2-full-authentication-is-required-to-access-this-resource
 * @author dmytro.tyshchenko
 *
 */
@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
public class AuthenticationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationServiceApplication.class, args);
	}

}
