package de.mysystem.controller.journal;

import java.util.Date;

public class TheWork implements JournalEntry {

	int id;
	String description;
	Date inserted;
	String statement;
	String turnedAround;
	String discussion;
	
	
	
	public TheWork(int id, String description) {
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
	public String getStatement() {
		return statement;
	}
	public void setStatement(String statement) {
		this.statement = statement;
	}
	public String getTurnedAround() {
		return turnedAround;
	}
	public void setTurnedAround(String turnedAround) {
		this.turnedAround = turnedAround;
	}
	public String getDiscussion() {
		return discussion;
	}
	public void setDiscussion(String discussion) {
		this.discussion = discussion;
	}

	@Override
	public String getType() {
		return "Gratitude"; 
	}

}
