package com.wanfadger.RetrofitgwtRpctodo.shared.actioncallbacks;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public abstract class AsyncCallbackImpl<T> implements AsyncCallback<T> {

	@Override
	public void onFailure(Throwable caught) {
		GWT.log("Communication to the server has failed. "+caught.getMessage());
	}
	
}
