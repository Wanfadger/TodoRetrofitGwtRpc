package com.wanfadger.RetrofitgwtRpctodo.shared.retrofit.services;

import java.util.List;

import com.wanfadger.RetrofitgwtRpctodo.shared.models.Todo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface TodoService {

	@GET("todos")
	Call<List<Todo>> fetchTodos();
	
	@POST("todos")
	Call<Todo> saveTodo(@Body Todo todo);
	
	@GET("todos/{id}")
	Call<Todo> fetchTodoById(@Path("id") String id);
	
	@DELETE("todos/{id}")
	Call<Void> deleteTodoById(@Path("id") String id);
	
	@PUT("todos/{id}")
	Call<Todo> updateTodo(@Path("id") String id , @Body Todo todo);
	
	
	
	
	
	
}
