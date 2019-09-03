package com.ztysdmy.authenticationservice.model;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.junit.Assert;
import org.junit.Test;

public class AuthenticationTest {

	private String OathResponse  = "{\"access_token\":\"43a999cf-45d8-4cc3-8442-c903426940f9\",\"token_type\":\"bearer\",\"refresh_token\":\"69904df5-7208-432f-8f6d-c755eeda6bdb\",\"expires_in\":43199,\"scope\":\"webclient mobileclient\"}";
	
	@Test
	public void shouldCreateAuthenticationFromOAthResponse() throws Exception {
		Jsonb jsonb = JsonbBuilder.create();
		Oauth2Token authentication = jsonb.fromJson(OathResponse, Oauth2Token.class);
		Assert.assertNotNull(authentication);
		Assert.assertEquals("43a999cf-45d8-4cc3-8442-c903426940f9", authentication.getAccess_token());
	}
}
