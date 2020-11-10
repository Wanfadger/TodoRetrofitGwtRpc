package com.wanfadger.RetrofitgwtRpctodo.shared.httpclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public abstract class RestClient {
  
	private final static Client client = ClientBuilder.newClient();
	private final static String BASE_URL = "http://localhost:8080/";
	
	public static WebTarget getInstance() {
		return client.target(BASE_URL);
	}
		

}
