package com.ztysdmy.authenticationservice;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

//https://golb.hplar.ch/2019/01/java-11-http-client.html
public class AuthTest {
	
	@Test
	public void test() throws Exception {
		
		var request = HttpRequest.newBuilder()
				  .uri(new URI("http://localhost:8087/oauth/token"))
				  .header("Content-Type", "application/x-www-form-urlencoded")
				  .POST(ofFormData(formData())).build();
		
		var httpClient = httpClientWithBasicAithentication();
		
		var response = httpClient.send(request, BodyHandlers.ofString());
		System.out.println(response.body());
	}
	
	
	private HttpClient httpClientWithBasicAithentication() {

		HttpClient client = HttpClient.newBuilder().authenticator(new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("dima", "dima".toCharArray());
			}
		}).build();
		return client;
	}
	
	private HashMap<String, String> formData() {
		var result = new HashMap<String, String>();
		
		result.put("grant_type", "password");
		result.put("username", "dima");
		result.put("password", "dima");
		
		return result;
	}
	
	private BodyPublisher ofFormData(HashMap<String, String> data) {
		var builder = new StringBuilder();
		for (Map.Entry<String, String> entry : data.entrySet()) {
			if (builder.length() > 0) {
				builder.append("&");
			}
			builder.append(URLEncoder.encode(entry.getKey().toString(), StandardCharsets.UTF_8));
			builder.append("=");
			builder.append(URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8));
		}
		
		return BodyPublishers.ofString(builder.toString());
	}
	
}
