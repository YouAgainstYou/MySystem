package de.mysystem.controller.journal;

import java.util.Date;


public interface JournalEntry {

	public int getId();

	public String getDescription();
	
	public Date getInserted();
	
	public String getType();


}
