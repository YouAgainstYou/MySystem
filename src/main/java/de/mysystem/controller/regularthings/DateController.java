package de.mysystem.controller.regularthings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.

@Controller
public class DateController {

	@Autowired
	DateService ds;

	@Autowired
	LocalSessionFactoryBean sf;
	
	
	@RequestMapping(value="/listDates")
	public String listDisciplines(Model model) {
		System.out.println("listDates called.");
		model.addAttribute("dates", ds.getDateList());
		
		return "/regularthings/listDates";
	}

	@RequestMapping(value="/addDate")
	public String addDate(Model model) {

		FixedDate date= ds.addDate();
		
		return "redirect:/editDate/" + date.getId();
	}
	
	@RequestMapping(value="/deleteDate/{id}")
	public String deleteDate(@PathVariable int id, Model model) {

		ds.deleteDate(id);
		
		model.addAttribute("dates", ds.getDateList());
		
		return "regularthings/listDates";
	}
	
	@RequestMapping(value="/editDate/{id}")
	public String editDate(@PathVariable int id, Model model) {
		
		FixedDate date = (FixedDate)ds.getDate(id);
		
		model.addAttribute("fixedDate", date);
	
		
		return "/regularthings/editDate";
	}
	
	@RequestMapping(value="/updateDate", method = RequestMethod.POST)
	public String updateDate(@ModelAttribute(value="date") FixedDate date) {
		System.out.println("updateDate called");
		ds.updateDate(date);
		
		return "redirect:/listDates";
	}

	
	
}
