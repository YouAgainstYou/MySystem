package de.mysystem.controller.gtd;

public class Project implements ToDo {
	int id;
	String description;
	ToDo parent;
	
	
	public Project (int id, String description) {
		this.id = id;
		this.description = description;
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
	public void setDescription(String description) {
		this.description = description;
	}
	public ToDo getParent() {
		return parent;
	}
	public void setParent(ToDo parent) {
		this.parent = parent;
	}
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Project";
	}
	
}
