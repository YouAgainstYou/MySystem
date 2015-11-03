package de.mysystem.controller.regularthings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import de.mysystem.helpers.Idgenerator;


@Service
@Scope("session")
public class DateService {
	Map<Integer, FixedDate> dates = new HashMap<Integer, FixedDate>();

	
	public List<FixedDate> getDateList() {
		List<FixedDate> dateList = new ArrayList<>();
		dateList.addAll(dates.values());
		
		return dateList;
	}
	public FixedDate addDate() {
		FixedDate entry= new FixedDate(getNextId(), new java.util.Date(), "00:00", "new Date");
		
		dates.put(entry.getId(), entry);
		
		return entry;
	}
	public void deleteDate(int id) {
		dates.remove(id);
	}
	public FixedDate getDate(int id) {
		return (FixedDate)dates.get(id);
	}
	public void updateDate(FixedDate date) {
		dates.put(date.getId(), date);
	}
	
	private int getNextId() {
		return Idgenerator.getNextId(dates.keySet());
	}


}
