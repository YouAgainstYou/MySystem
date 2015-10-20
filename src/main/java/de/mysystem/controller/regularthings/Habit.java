package de.mysystem.controller.regularthings;

public class Habit {

	int id;
	String cue;
	String description;
	String badRoutine;
	String productiveRoutine;
	String badReward;
	String sideEffects;
	String productiveReward;
	java.util.Date inserted;
	
	
	
	
	public Habit(int id, String description) {
		this.id = id;
		this.description = description;
		this.inserted = new java.util.Date();
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCue() {
		return cue;
	}
	public void setCue(String cue) {
		this.cue = cue;
	}
	public String getBadRoutine() {
		return badRoutine;
	}
	public void setBadRoutine(String badRoutine) {
		this.badRoutine = badRoutine;
	}
	public String getProductiveRoutine() {
		return productiveRoutine;
	}
	public void setProductiveRoutine(String productiveRoutine) {
		this.productiveRoutine = productiveRoutine;
	}
	public String getBadReward() {
		return badReward;
	}
	public void setBadReward(String badReward) {
		this.badReward = badReward;
	}
	public String getSideEffects() {
		return sideEffects;
	}
	public void setSideEffects(String sideEffects) {
		this.sideEffects = sideEffects;
	}
	public String getProductiveReward() {
		return productiveReward;
	}
	public void setProductiveReward(String productiveReward) {
		this.productiveReward = productiveReward;
	}
	
	
}
