package com.wanfadger.RetrofitgwtRpctodo.client.application.home;

import javax.inject.Inject;

import com.google.gwt.core.client.GWT;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.smartgwt.client.util.SC;
import com.wanfadger.RetrofitgwtRpctodo.client.application.ApplicationPresenter;
import com.wanfadger.RetrofitgwtRpctodo.client.place.NameTokens;
import com.wanfadger.RetrofitgwtRpctodo.shared.actioncallbacks.AsyncCallbackImpl;
import com.wanfadger.RetrofitgwtRpctodo.shared.actionresult.TodoAction;
import com.wanfadger.RetrofitgwtRpctodo.shared.actionresult.TodoResult;
import com.wanfadger.RetrofitgwtRpctodo.shared.models.Todo;
import com.wanfadger.RetrofitgwtRpctodo.shared.utils.TodoActionCommands;

public class HomePagePresenter extends Presenter<HomePagePresenter.MyView, HomePagePresenter.MyProxy> implements HomeUiHandlers {
    interface MyView extends View , HasUiHandlers<HomePagePresenter> {
    	HomePanel homePanel();
    }

    
    
    private DispatchAsync dispatcher;
    
    
    @ProxyStandard
    @NameToken(NameTokens.home)
    interface MyProxy extends ProxyPlace<HomePagePresenter> {
    }

    @Inject
    HomePagePresenter(EventBus eventBus,
                      MyView view,
                      MyProxy proxy , final DispatchAsync dispatchAsync) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_SetMainContent);
        this.dispatcher = dispatchAsync;
        getView().setUiHandlers(this);
        
    }

    @Override
    protected void onBind() {
    	super.onBind();
    	
    	fetchTodos();
    }
    
	@Override
	public void save(Todo todo) {
//		SC.say("save "+todo);
		TodoAction saveAction = new TodoAction(TodoActionCommands.SAVE_TODO , todo);
		this.dispatcher.execute(saveAction , new AsyncCallbackImpl<TodoResult>() {
			@Override
			public void onSuccess(TodoResult result) {
			  SC.say("Successfully saved ");
			  getView().homePanel().getTodoForm().clearValues();
			  fetchTodos();
			}
		});
		
	}

	@Override
	public void fetchTodos() {
TodoAction todosAction = new TodoAction(TodoActionCommands.FETCH_TODOS);
    	
    	this.dispatcher.execute(todosAction, new AsyncCallbackImpl<TodoResult>() {
    		@Override
    		public void onSuccess(TodoResult result) {
    		   GWT.log("todos "+result.getTodos());	
    		  getView().homePanel().getTodoGrid().setData(Todo.todoRecords(result.getTodos()));
    		}
		});
	}
}