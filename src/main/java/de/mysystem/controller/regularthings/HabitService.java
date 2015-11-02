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
		return Idgenerator.getNextId(habits.keySet());
	}


}
