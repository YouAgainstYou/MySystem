package de.mysystem.controller.gtd;

public class Issue implements ToDo {
	int id;
	String description;
	GtdStatus status;
	ToDo parent;

	public Issue(int id, String descrption) {
		super();
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
	public String getType() {
		return "Issue";
	}
	
}
