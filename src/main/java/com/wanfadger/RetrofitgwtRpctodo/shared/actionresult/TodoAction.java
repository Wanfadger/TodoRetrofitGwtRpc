package com.wanfadger.RetrofitgwtRpctodo.shared.actionresult;

import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;
import com.wanfadger.RetrofitgwtRpctodo.shared.models.Todo;

public class TodoAction extends UnsecuredActionImpl<TodoResult> implements IsSerializable {

	private String command;
	private Todo todo;
	private List<Todo> todos;
	
	public TodoAction() {
		// TODO Auto-generated constructor stub
	}
	
	public TodoAction(String command) {
	this.command = command;
	}
	
	public TodoAction(String command , Todo todo) {
		this.command = command;
		this.todo = todo;
	}
	
	public TodoAction(String command , List<Todo> todos) {
		this.command = command;
		this.todos = todos;
	}

	public String getCommand() {
		return command;
	}

	public Todo getTodo() {
		return todo;
	}

	public List<Todo> getTodos() {
		return todos;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public void setTodo(Todo todo) {
		this.todo = todo;
	}

	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}
	
	
	
	
	
	
	
	
}
