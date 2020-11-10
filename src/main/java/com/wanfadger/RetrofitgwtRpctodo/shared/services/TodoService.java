package com.wanfadger.RetrofitgwtRpctodo.shared.services;

import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.wanfadger.RetrofitgwtRpctodo.shared.httpclient.RestClient;
import com.wanfadger.RetrofitgwtRpctodo.shared.models.Todo;

public class TodoService {
	private static TodoService instance = null;
	
	private TodoService() {

	}

	public static TodoService getInstance() {
		if(instance == null) {
			instance = new TodoService();
		}
		return instance;
	}
	
	
	private WebTarget webTarget = RestClient.getInstance().path("todos/");
	
	
	public Todo saveTodo(Todo todo) {
		Invocation.Builder builder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = builder.post(Entity.json(todo));
	    return response.readEntity(Todo.class);
	}
	
	public List<Todo> fetchTodos(){
	  Invocation.Builder builder  = webTarget.request(MediaType.APPLICATION_JSON);
	  Response response  = builder.get();	 
	 return response.readEntity(new GenericType<List<Todo>>() {}) ;
	}
	
	
	public Todo fetchTodoById(String id) {
		WebTarget todoWebTarget = webTarget.path("{id}");
		Invocation.Builder builder = todoWebTarget.resolveTemplate("id", id) .request(MediaType.APPLICATION_JSON);
		Response response = builder.get();
        Todo todo = response.readEntity(Todo.class);
		return todo;
	}
	

}
