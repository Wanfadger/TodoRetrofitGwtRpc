package com.wanfadger.RetrofitgwtRpctodo.client.application.home;

import com.google.gwt.core.client.GWT;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.wanfadger.RetrofitgwtRpctodo.shared.models.Todo;

class HomePageView extends ViewWithUiHandlers<HomePagePresenter> implements HomePagePresenter.MyView {

	HomePanel homePanel;

    public HomePageView() {
    	 homePanel = new HomePanel();
	  initWidget(homePanel);
	  
	  homePanel.getSaveButton().addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
            String name = homePanel.getTodoForm().getValueAsString("name"); //.getValueAsString("name");
            
            if(name==null) {
            	SC.say("please add your todo");            	
            }else {
    			getUiHandlers().save(new Todo(name));	
            }
            
		}
	});
	  
    }

	public HomePanel getHomePanel() {
		return homePanel;
	}

	@Override
	public HomePanel homePanel() {
		return this.homePanel;
	}
    
    
    
}