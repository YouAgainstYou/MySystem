package de.mysystem.controller.regularthings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.mysystem.controller.journal.JournalEntry;
import de.mysystem.controller.journal.JournalService;
import de.mysystem.controller.journal.Lesson;

public class HabitController  {

	HabitService hs;
    
	@RequestMapping(value="/addHabit")
	public String addHabit(Model model) {

		Habit habit= hs.addHabit();
		
		return "redirect:/editDiscipline/" + habit.getId();
	}
	@RequestMapping(value="/deleteHabit/{id}")
	public String deleteHabit(@PathVariable int id, Model model) {

		hs.deleteHabit(id);
		
		model.addAttribute("entries", hs.getHabitList());
		
		return "regularthings/listHabits";
	}

	@RequestMapping(value="/editHabit/{id}")
	public String editHabit(@PathVariable int id, Model model) {

		Habit habit = (Habit)hs.getHabit(id);
		
		model.addAttribute("habit", habit);
	
		
		return "/regularthings/editHabit";
	}

	@RequestMapping(value="/updateHabit", method = RequestMethod.POST)
	public String updateHabit(@ModelAttribute Habit habit) {
		
		hs.updateHabit(habit);
		
		return "redirect:/listHabits";
	}

	
	
}
