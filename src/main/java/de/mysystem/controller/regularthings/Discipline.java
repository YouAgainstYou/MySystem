package de.mysystem.controller.regularthings;

public class Discipline {

	int id;
	String description;
	
	
	public Discipline() {};
	
	public Discipline(int id, String description) {
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
	
	
	
	
}
