package com.wanfadger.RetrofitgwtRpctodo.server.actionhandlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;
import com.wanfadger.RetrofitgwtRpctodo.shared.actionresult.TodoAction;
import com.wanfadger.RetrofitgwtRpctodo.shared.actionresult.TodoResult;
import com.wanfadger.RetrofitgwtRpctodo.shared.models.Todo;
import com.wanfadger.RetrofitgwtRpctodo.shared.retrofit.RetrofitServiceGenerator;
import com.wanfadger.RetrofitgwtRpctodo.shared.retrofit.services.TodoService;
import com.wanfadger.RetrofitgwtRpctodo.shared.utils.TodoActionCommands;

import retrofit2.Response;

public class TodoActionHandler implements ActionHandler<TodoAction , TodoResult> {

	@Inject
	public TodoActionHandler() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public TodoResult execute(TodoAction action, ExecutionContext context) throws ActionException {
		TodoService service = RetrofitServiceGenerator.createService().create(TodoService.class);
		
		if(action.getCommand().equals(TodoActionCommands.FETCH_TODOS)) {
			
		
			List<Todo> todos = new ArrayList<Todo>();
			try {
				Response<List<Todo>> todoResponse = service.fetchTodos().execute();
			    todos = todoResponse.body();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.print("ERROR "+e.getMessage());
			}
//			
//			List<Todo> todos  = Arrays.asList(
//					new Todo("1" , "todo 1") , 
//					new Todo("2" , "todo 2") ,
//					new Todo("3" , "todo 3") ,
//					new Todo("4" , "todo 4") ,
//					new Todo("5" , "todo 5"));
//			
			
			
			return new TodoResult(todos);
		}else if(action.getCommand().equals(TodoActionCommands.SAVE_TODO)) {
			Todo todo = null;
			try {
				Response<Todo> todoResponse = service.saveTodo(action.getTodo()).execute();
			     todo = todoResponse.body();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.print("Error "+e.getMessage());
			}
			
		  return new TodoResult();	
		} else {
			return null;
		}
	
	}

	@Override
	public Class<TodoAction> getActionType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void undo(TodoAction action, TodoResult result, ExecutionContext context) throws ActionException {
		// TODO Auto-generated method stub
		
	}

}
