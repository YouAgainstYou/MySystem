package de.mysystem.controller.journal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import de.mysystem.helpers.Idgenerator;

@Service
@Scope("session")
public class JournalService {
	Map<Integer, JournalEntry> entries = new HashMap<Integer, JournalEntry>();

	
	public List<JournalEntry> getJournalEntryList() {
		List<JournalEntry> journalEntryList = new ArrayList<>();
		journalEntryList.addAll(entries.values());
		
		return journalEntryList;
	}

	
	public Lesson addLesson() {
		Lesson entry= new Lesson(getNextId(), "new Lesson");
		
		entries.put(entry.getId(), entry);
		
		return entry;
	}
	public void deleteLesson(int id) {
		entries.remove(id);
	}
	public Lesson getLesson(int id) {
		return (Lesson)entries.get(id);
	}
	public void updateLesson(Lesson lesson) {
		entries.put(lesson.getId(), lesson);
	}

	

	public TheWork addTheWork() {
		TheWork entry= new TheWork(getNextId(), "new Task");
		
		entries.put(entry.getId(), entry);
		
		return entry;
	}
	public void deleteTheWork(int id) {
		entries.remove(id);
	}
	public TheWork getTheWork(int id) {
		return (TheWork)entries.get(id);
	}
	public void updateTheWork(TheWork theWork) {
		entries.put(theWork.getId(), theWork);
	}
	
	
	
	public Gratitude addGratitude() {
		Gratitude entry= new Gratitude(getNextId(), "new Gratitude");
		
		entries.put(entry.getId(), entry);
		
		return entry;
	}
	public void deleteGratitude(int id) {
		entries.remove(id);
	}
	public Gratitude getGratitude(int id) {
		return (Gratitude)entries.get(id);
	}
	public void updateGratitude(Gratitude gratitude) {
		entries.put(gratitude.getId(), gratitude);
	}

	
	public SDB addSdb() {
		SDB entry= new SDB(getNextId(), "new SDB");
		
		entries.put(entry.getId(), entry);
		
		return entry;
	}
	public void deleteSdb(int id) {
		entries.remove(id);
	}
	public SDB getSdb(int id) {
		return (SDB)entries.get(id);
	}
	public void updateSdb(SDB sdb) {
		entries.put(sdb.getId(), sdb);
	}

	
	
	private int getNextId() {
		return Idgenerator.getNextId(entries.keySet());	}

}
