package de.mysystem.controller.journal;

import java.util.Date;

public class SDB implements JournalEntry {

	int id;
	String description;
	Date inserted;
	
	public SDB() {};
	
	public SDB(int id, String description) {
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
	
	@Override
	public String getType() {
		return "Gratitude"; 
	}

}
