package de.mysystem.controller.regularthings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DateService {
	Map<Integer, Date> dates = new HashMap<Integer, Date>();
	Map<Integer, Habit> habits = new HashMap<Integer, Habit>();
	Map<Integer, Discipline> disciplines = new HashMap<Integer, Discipline>();
	

	
	public List<Date> getDateList() {
		List<Date> dateList = new ArrayList<>();
		dateList.addAll(dates.values());
		
		return dateList;
	}
	public Date addDate() {
		Date entry= new Date(getNextId(), new java.util.Date(), "00:00", "new Date");
		
		dates.put(entry.getId(), entry);
		
		return entry;
	}
	public void deleteDate(int id) {
		dates.remove(id);
	}
	public Date getDate(int id) {
		return (Date)dates.get(id);
	}
	public void updateDate(Date date) {
		dates.put(date.getId(), date);
	}


	
	
	private int getNextId() {
		int id = Collections.max(dates.keySet());
		
		return id + 1;
	}


}
