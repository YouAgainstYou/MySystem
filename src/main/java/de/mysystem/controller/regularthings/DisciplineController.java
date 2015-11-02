package de.mysystem.controller.regularthings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class DisciplineController {

	@Autowired
	DisciplineService ds;
    
	
	@RequestMapping(value="/listDisciplines")
	public String listDisciplines(Model model) {
		System.out.println("listDisciplines called.");
		model.addAttribute("disciplines", ds.getDisciplineList());
		
		return "/regularthings/listDisciplines";
	}


    
	@RequestMapping(value="/addDiscipline")
	public String addDiscipline(Model model) {

		Discipline discipline= ds.addDiscipline();
		
		return "redirect:/editDiscipline/" + discipline.getId();
	}
	@RequestMapping(value="/deleteDiscipline/{id}")
	public String deleteDiscipline(@PathVariable int id, Model model) {

		ds.deleteDiscipline(id);
		
		model.addAttribute("entries", ds.getDisciplineList());
		
		return "regularthings/listDisciplines";
	}

	@RequestMapping(value="/editDiscipline/{id}")
	public String editDiscipline(@PathVariable int id, Model model) {
		

		Discipline discipline = (Discipline)ds.getDiscipline(id);
		
		model.addAttribute("discipline", discipline);
	
		
		return "/regularthings/editDiscipline";
	}

	@RequestMapping(value="/updateDiscipline", method = RequestMethod.POST)
	public String updisciplineDiscipline(@ModelAttribute Discipline discipline) {

		ds.updateDiscipline(discipline);
		
		
		return "redirect:/listDisciplines";
	}

	
	
}
