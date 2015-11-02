package de.mysystem.controller.regularthings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HabitController  {

	@Autowired
	HabitService hs;
	
	
	@RequestMapping(value="/listHabits")
	public String listHabits(Model model) {
		System.out.println("listHabits called.");
		model.addAttribute("habits", hs.getHabitList());
		
		return "/regularthings/listHabits";
	}

    
	@RequestMapping(value="/addHabit")
	public String addHabit(Model model) {

		Habit habit= hs.addHabit();
		
		return "redirect:/editHabit/" + habit.getId();
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
