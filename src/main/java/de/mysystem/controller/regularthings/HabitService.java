package de.mysystem.controller.regularthings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HabitService {
	Map<Integer, Habit> habits = new HashMap<Integer, Habit>();

	
	public List<Habit> getHabitList() {
		List<Habit> habitList = new ArrayList<>();
		habitList.addAll(habits.values());
		
		return habitList;
	}
	public Habit addHabit() {
		Habit entry= new Habit(getNextId(), "new Habit");
		
		habits.put(entry.getId(), entry);
		
		return entry;
	}
	public void deleteHabit(int id) {
		habits.remove(id);
	}
	public Habit getHabit(int id) {
		return (Habit)habits.get(id);
	}
	public void updateHabit(Habit habit) {
		habits.put(habit.getId(), habit);
	}


	
	
	private int getNextId() {
		int id = Collections.max(habits.keySet());
		
		return id + 1;
	}


}
