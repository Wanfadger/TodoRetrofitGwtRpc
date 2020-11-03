package com.wanfadger.RetrofitgwtRpctodo.shared.retrofit;

import com.wanfadger.RetrofitgwtRpctodo.shared.retrofit.services.TodoService;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServiceGenerator {

	private static String BASE_URL = "http://localhost:8080/";
	
	private static Retrofit retrofit;

	private static OkHttpClient.Builder okhttpBuilder = new OkHttpClient.Builder();
	
	public static Retrofit createService() {
		if(retrofit == null) {
		  retrofit = new Retrofit.Builder()
				  .baseUrl(BASE_URL)
				  .addConverterFactory(GsonConverterFactory.create())
				  .client(okhttpBuilder.build())
				  .build();
		}
		
		return retrofit;
		
	}
	
	public static <S> S createService(Class<S> service) {
		
		return null;
	}
	
	
}
