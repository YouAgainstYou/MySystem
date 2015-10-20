package de.mysystem.controller.journal;

import java.util.Date;

public class Gratitude implements JournalEntry {
	int id;
	String description;
	Date inserted;
	String grateful;
	String proud;
	String laughed;

	public Gratitude() {};
	
	public Gratitude(int id, String description) {
		this.id = id;
		this.description = description;
		this.inserted = new Date();
		
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
	public Date getInserted() {
		return inserted;
	}
	public void setInserted(Date inserted) {
		this.inserted = inserted;
	}
	public String getGrateful() {
		return grateful;
	}
	public void setGrateful(String grateful) {
		this.grateful = grateful;
	}
	public String getProud() {
		return proud;
	}
	public void setProud(String proud) {
		this.proud = proud;
	}
	public String getLaughed() {
		return laughed;
	}
	public void setLaughed(String laughed) {
		this.laughed = laughed;
	}
	@Override
	public String getType() {
		return "Gratitude"; 
	}
	
	
	
	
	
}
