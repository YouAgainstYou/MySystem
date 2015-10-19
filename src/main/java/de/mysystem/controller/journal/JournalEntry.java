package de.mysystem.controller.journal;

import java.util.List;

import de.mysystem.controller.gtd.ToDo;

public class JournalEntry {
	int id;
	String description;
	

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
