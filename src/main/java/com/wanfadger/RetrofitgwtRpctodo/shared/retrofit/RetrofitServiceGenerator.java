package com.wanfadger.RetrofitgwtRpctodo.shared.retrofit;

import com.wanfadger.RetrofitgwtRpctodo.shared.retrofit.services.TodoService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServiceGenerator {

	private static String BASE_URL = "http://localhost:8080/";
	
	private static Retrofit retrofit;

	private static OkHttpClient.Builder okhttpBuilder = new OkHttpClient.Builder();
	
	private static HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor()
			.setLevel(Level.BASIC);
	
	
	
	private static Retrofit getInstance() {
		
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
		
			return getInstance().create(service);
			
	}
	
	
}
