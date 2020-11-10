package com.wanfadger.RetrofitgwtRpctodo.server.actionhandlers;

import java.util.List;

import javax.inject.Inject;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;
import com.wanfadger.RetrofitgwtRpctodo.shared.actionresult.TodoAction;
import com.wanfadger.RetrofitgwtRpctodo.shared.actionresult.TodoResult;
import com.wanfadger.RetrofitgwtRpctodo.shared.models.Todo;
import com.wanfadger.RetrofitgwtRpctodo.shared.services.TodoService;
import com.wanfadger.RetrofitgwtRpctodo.shared.utils.TodoActionCommands;


public class TodoActionHandler implements ActionHandler<TodoAction , TodoResult> {
	
	@Inject
	public TodoActionHandler() {
	 	
	}
	
	
	@Override
	public TodoResult execute(TodoAction action, ExecutionContext context) throws ActionException {
		if(action.getCommand().equals(TodoActionCommands.FETCH_TODOS)) {
			
//			List<Todo> todos  = Arrays.asList(
//					new Todo("1" , "todo 1") , 
//					new Todo("2" , "todo 2") ,
//					new Todo("3" , "todo 3") ,
//					new Todo("4" , "todo 4") ,
//					new Todo("5" , "todo 5"));
			
			
			List<Todo> todos = TodoService.getInstance().fetchTodos(); 
			
			return new TodoResult(todos);
			
		}else if(action.getCommand().equals(TodoActionCommands.SAVE_TODO)) {
 
			
		  return new TodoResult(TodoService.getInstance().saveTodo(action.getTodo()));	
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
