package de.mysystem.controller.gtd;

import java.util.Date;

public class Task implements ToDo {
	
	int id;
	String description;
	GtdStatus status;
	Date inserted;
	Boolean doTomorrow;
	ToDo parent;
	boolean doToday;

	

	public Task() {};
	
	public Task(int id, String descrption) {
		this.id = id;
		this.description = descrption;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String descrption) {
		this.description = descrption;
	}
	public GtdStatus getStatus() {
		return status;
	}
	public void setStatus(GtdStatus status) {
		this.status = status;
	}
	public Date getInserted() {
		return inserted;
	}
	public void setInserted(Date inserted) {
		this.inserted = inserted;
	}
	public Boolean getDoTomorrow() {
		return doTomorrow;
	}
	public void setDoTomorrow(Boolean doTomorrow) {
		this.doTomorrow = doTomorrow;
	}
	public ToDo getParent() {
		return parent;
	}

	public void setParent(ToDo parent) {
		this.parent = parent;
	}

	public boolean isDoToday() {
		return doToday;
	}

	public void setDoToday(boolean doToday) {
		this.doToday = doToday;
	}

	
	public String getType() {
		return "Task";
	}

	
	
}
