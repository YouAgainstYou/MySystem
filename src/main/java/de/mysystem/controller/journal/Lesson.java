package de.mysystem.controller.journal;

import java.util.Date;

public class Lesson implements JournalEntry {
	int id;
	String whatHappened;
	String lesson;
	Date inserted;
	

	public Lesson() {};
	
	public Lesson(int id, String description) {
		this.id = id;
		this.inserted = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return lesson;
	}


	public String getWhatHappened() {
		return whatHappened;
	}

	public void setWhatHappened(String whatHappened) {
		this.whatHappened = whatHappened;
	}

	public String getLesson() {
		return lesson;
	}

	public void setLesson(String lesson) {
		this.lesson = lesson;
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
