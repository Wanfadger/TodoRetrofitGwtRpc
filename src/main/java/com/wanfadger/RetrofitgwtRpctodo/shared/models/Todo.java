package com.wanfadger.RetrofitgwtRpctodo.shared.models;

import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class Todo implements IsSerializable  {

	private String id;
	private String name;
	
	public Todo() {
		// TODO Auto-generated constructor stub
	}

	public Todo(String id , String name) {
	  this.id = id;
	  this.name = name;
	}
	
	public Todo(String name) {
		  this.name = name;	
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	
	public static ListGridRecord[] todoRecords() {
		ListGridRecord[] records = new ListGridRecord[] {};
		
		for(int i=0 ; i<5 ; i++) {
		
         ListGridRecord record = new ListGridRecord();
         record.setAttribute("name", "Cooking");
         record.setAttribute("id", "123453");
         record.setAttribute("created", "today");
         record.setAttribute("status", "completed");
		records[i] = record;
		}
		return records;
		
	}
	
	
	public static ListGridRecord[] todoRecords(List<Todo> todos) {
		ListGridRecord[] records = new ListGridRecord[] {};
		
		for(int i = 0 ; i < todos.size() ; i++) {
		   Todo todo = todos.get(i);
         ListGridRecord record = new ListGridRecord();
         record.setAttribute("name", todo.getName() );
         record.setAttribute("id", todo.getId());
         record.setAttribute("created", "today");
         record.setAttribute("status", "completed");
		records[i] = record;
		}
		return records;
		
	}
	
	

	@Override
	public String toString() {
		return "Todo [id=" + id + ", name=" + name + "]";
	}
	
	

	
}
