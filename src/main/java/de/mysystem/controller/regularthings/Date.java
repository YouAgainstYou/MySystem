package de.mysystem.controller.regularthings;

import java.util.List;

import de.mysystem.controller.gtd.ToDo;

public class Date {
	int id;
	java.util.Date date;
	String time;
	String description;
	java.util.Date inserted;
	
	List<ToDo> todos;

	
	
	
	public Date(int id, java.util.Date date, String time, String description) {
		this.id = id;
		this.date = date;
		this.time = time;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ToDo> getTodos() {
		return todos;
	}

	public void setTodos(List<ToDo> todos) {
		this.todos = todos;
	}
	
	
	
	
}
