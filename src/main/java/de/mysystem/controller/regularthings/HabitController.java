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

public class HabitController implements ApplicationContextAware {

    private static ApplicationContext context;
    
    
    public static ApplicationContext getApplicationContext() {
        return context;
    }

    @Override
    public void setApplicationContext(ApplicationContext ac)
            throws BeansException {
        context = ac;
    }


    
	@RequestMapping(value="/addHabit")
	public String addHabit(Model model) {
		
		HabitService ds = context.getBean("habitService", HabitService.class);

		Habit habit= ds.addHabit();
		
		return "redirect:/editDiscipline/" + habit.getId();
	}
	@RequestMapping(value="/deleteHabit/{id}")
	public String deleteHabit(@PathVariable(value="id") int id, Model model) {
		HabitService ds = context.getBean("habitService", HabitService.class);
		ds.deleteHabit(id);
		
		model.addAttribute("entries", ds.getHabitList());
		
		return "regularthings/listHabits";
	}

	@RequestMapping(value="/editHabit/{id}")
	public String editHabit(@PathVariable(value="id") int id, Model model) {
		
		HabitService ds = context.getBean("habitService", HabitService.class);
		Habit habit = (Habit)ds.getHabit(id);
		
		model.addAttribute("habit", habit);
	
		
		return "/regularthings/editHabit";
	}

	@RequestMapping(value="/updateHabit", method = RequestMethod.POST)
	public String updateHabit(@ModelAttribute Habit habit) {

		HabitService ds = context.getBean("habitService", HabitService.class);
		
		ds.updateHabit(habit);
		
		
		return "redirect:/listHabits";
	}

	
	
}
