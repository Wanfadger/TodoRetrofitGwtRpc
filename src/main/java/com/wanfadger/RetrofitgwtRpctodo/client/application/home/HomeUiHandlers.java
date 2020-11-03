package com.wanfadger.RetrofitgwtRpctodo.client.application.home;

import java.util.List;

import com.gwtplatform.mvp.client.UiHandlers;
import com.wanfadger.RetrofitgwtRpctodo.shared.models.Todo;

public interface HomeUiHandlers extends UiHandlers {
    
	void save(Todo todo);
	
	void fetchTodos();
	

	
	
	
}
