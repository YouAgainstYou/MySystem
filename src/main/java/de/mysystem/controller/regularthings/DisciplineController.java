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

public class DisciplineController implements ApplicationContextAware {

    private static ApplicationContext context;
    
    
    public static ApplicationContext getApplicationContext() {
        return context;
    }

    @Override
    public void setApplicationContext(ApplicationContext ac)
            throws BeansException {
        context = ac;
    }


    
	@RequestMapping(value="/addDiscipline")
	public String addDiscipline(Model model) {
		
		DisciplineService ds = context.getBean("disciplineService", DisciplineService.class);

		Discipline discipline= ds.addDiscipline();
		
		return "redirect:/editDiscipline/" + discipline.getId();
	}
	@RequestMapping(value="/deleteDiscipline/{id}")
	public String deleteDiscipline(@PathVariable(value="id") int id, Model model) {
		DisciplineService ds = context.getBean("disciplineService", DisciplineService.class);
		ds.deleteDiscipline(id);
		
		model.addAttribute("entries", ds.getDisciplineList());
		
		return "gtd/listDisciplines";
	}

	@RequestMapping(value="/editDiscipline/{id}")
	public String editDiscipline(@PathVariable(value="id") int id, Model model) {
		
		DisciplineService ds = context.getBean("disciplineService", DisciplineService.class);
		Discipline discipline = (Discipline)ds.getDiscipline(id);
		
		model.addAttribute("discipline", discipline);
	
		
		return "/gtd/editDiscipline";
	}

	@RequestMapping(value="/updisciplineDiscipline", method = RequestMethod.POST)
	public String updisciplineDiscipline(@ModelAttribute Discipline discipline) {

		DisciplineService ds = context.getBean("disciplineService", DisciplineService.class);
		
		ds.updateDiscipline(discipline);
		
		
		return "redirect:/listDisciplines";
	}

	
	
}
