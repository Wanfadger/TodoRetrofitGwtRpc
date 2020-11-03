package com.wanfadger.RetrofitgwtRpctodo.shared.actionresult;

import java.util.List;

import com.gwtplatform.dispatch.rpc.shared.Result;
import com.wanfadger.RetrofitgwtRpctodo.shared.models.Todo;

public class TodoResult implements Result {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Todo todo;
	private List<Todo> todos;

	public TodoResult() {
		// TODO Auto-generated constructor stub
	}
	

	
	public TodoResult(Todo todo) {
		  this.todo = todo;
	}
	
	public TodoResult(List<Todo> todos) {
		  this.todos = todos;
	}



	public Todo getTodo() {
		return todo;
	}


	public List<Todo> getTodos() {
		return todos;
	}
	
	
	
	
	
	
	
	
	
	
	

}
