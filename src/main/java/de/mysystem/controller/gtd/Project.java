package de.mysystem.controller.gtd;

public class Project implements ToDo {
	int id;
	String description;
	Project parent;
	AreaOfLife areaOfLife;
	boolean current;
	
	public Project() {};
	
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
	public Project getParent() {
		return parent;
	}
	public void setParent(Project parent) {
		this.parent = parent;
	}
	public AreaOfLife getAreaOfLife() {
		return areaOfLife;
	}

	public void setAreaOfLife(AreaOfLife areaOfLife) {
		this.areaOfLife = areaOfLife;
	}

	public boolean isCurrent() {
		return current;
	}

	public void setCurrent(boolean current) {
		this.current = current;
	}

	@Override
	public String getType() {
		return "Project";
	}
	
}
