package com.wanfadger.RetrofitgwtRpctodo.server.guice;

import com.gwtplatform.dispatch.rpc.server.guice.HandlerModule;
import com.wanfadger.RetrofitgwtRpctodo.server.actionhandlers.TodoActionHandler;
import com.wanfadger.RetrofitgwtRpctodo.shared.actionresult.TodoAction;
import com.wanfadger.RetrofitgwtRpctodo.shared.actionresult.TodoResult;

public class ServerModule extends HandlerModule {
    @Override
    protected void configureHandlers() {
    	bindHandler(TodoAction.class , TodoActionHandler.class);
    }
}