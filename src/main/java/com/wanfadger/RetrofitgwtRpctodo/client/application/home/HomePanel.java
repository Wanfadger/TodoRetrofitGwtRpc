package com.wanfadger.RetrofitgwtRpctodo.client.application.home;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.wanfadger.RetrofitgwtRpctodo.shared.models.Todo;

public class HomePanel extends VLayout {
	
	private DynamicForm todoForm;
	private IButton saveButton;
	private ListGrid todoGrid;

	public HomePanel() {
	  this.setWidth100();
	  this.setHeight100();
	  this.setBorder("1px solid red");
	  this.setLayoutAlign(Alignment.CENTER);
	  this.setMembersMargin(10);

	  
	  Label label = new Label("Todo Management");
	  label.setAutoHeight();
	  label.setAutoWidth();
	  label.setWrap(false);
	  label.setLayoutAlign(VerticalAlignment.CENTER);
	  
	  this.addMember(label);
	  
	   todoForm = new DynamicForm();
	  todoForm.setLayoutAlign(VerticalAlignment.CENTER);
	  todoForm.setAutoWidth();
	  
	 
	  TextItem todoItem = new TextItem("name");
	  todoItem.setHint("create todo");
	  todoItem.setShowHint(true);
	  todoItem.setShowTitle(false);
	  todoItem.setShowHintInField(true);
	  
	  todoForm.setFields(todoItem);
	  this.addMember(todoForm);
	  
	  saveButton = new IButton("Save");
	  saveButton.setWidth(50);
	  saveButton.setHeight(25);
	  saveButton.setPadding(5);
	  saveButton.setLayoutAlign(VerticalAlignment.CENTER);
	  saveButton.setBorder("1px solid red");
	  this.addMember(saveButton);  
	  
	  
	   todoGrid = new ListGrid()  {
		  @Override  
	            protected Canvas createRecordComponent(final ListGridRecord record, Integer columNumber) {  
		  
          String fieldName = this.getFieldName(columNumber);  

          if (fieldName.equals("action")) {  
              HLayout actionLayout = new HLayout(3);  
              actionLayout.setHeight(22);  
              actionLayout.setWidth100();  
              actionLayout.setAlign(Alignment.CENTER);
              
              ImgButton editImg = new ImgButton();  
              editImg.setShowDown(false);  
              editImg.setShowRollOver(false);  
              editImg.setLayoutAlign(Alignment.CENTER);  
              editImg.setSrc("images/delete_icon.png");  
              editImg.setPrompt("Edit Comments");  
              editImg.setHeight(16);  
              editImg.setWidth(16);  
              
              editImg.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					// TODO Auto-generated method stub
                    SC.say("Edit Comment Icon Clicked for : " + record.getAttribute("name"));	
				}
			});
              
              ImgButton upImg = new ImgButton();  
              upImg.setShowDown(false);  
              upImg.setShowRollOver(false);  
              upImg.setAlign(Alignment.CENTER);  
              upImg.setPrompt("View Chart");  
              upImg.setHeight(16);  
              upImg.setWidth(16);  
              upImg.addClickHandler(new ClickHandler() {  
                  public void onClick(ClickEvent event) {  
                      SC.say("Ch Icon Clicked for  : " + record.getAttribute("name"));  
                  }  
              });  

              actionLayout.addMember(editImg);  
              actionLayout.addMember(upImg);  
              return actionLayout;  
          }   
           else {  
              return null;  
          }  

      }  
  };  


  todoGrid.setVirtualScrolling(false);          
  todoGrid.setShowRecordComponents(true);          
  todoGrid.setShowRecordComponentsByCell(true); 
	  
	  todoGrid.setWidth("50%");
	  todoGrid.setLayoutAlign(VerticalAlignment.CENTER);
	  todoGrid.setBorder("1px solid blue");
	  
	  ListGridField nameField = new ListGridField("name" , "Name");
	  ListGridField createdField = new ListGridField("created", "Created");
	  ListGridField statusField = new ListGridField("status" , "Status");
	  ListGridField actionField = new ListGridField("action" , "Action");
	  
	  todoGrid.setFields(nameField , createdField , statusField , actionField);
	  todoGrid.setData(Todo.todoRecords());
	  
	  this.addMember(todoGrid);
	 
	  
	}

	public DynamicForm getTodoForm() {
		return todoForm;
	}

	public IButton getSaveButton() {
		return saveButton;
	}

	public ListGrid getTodoGrid() {
		return todoGrid;
	}
	
	
	
	
}
