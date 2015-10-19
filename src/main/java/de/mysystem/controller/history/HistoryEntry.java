package de.mysystem.controller.history;

public class HistoryEntry {

	int id;
	String text;
	
	
	
	public HistoryEntry(int id, String text) {
		this.id = id;
		this.text = text;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
	
}
