package de.mysystem.controller.regularthings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DateController  {

	@Autowired
	DateService ds;
    
	@RequestMapping(value="/addDate")
	public String addDate(Model model) {

		Date date= ds.addDate();
		
		return "redirect:/editDate/" + date.getId();
	}
	@RequestMapping(value="/deleteDate/{id}")
	public String deleteDate(@PathVariable(value="id") int id, Model model) {

		ds.deleteDate(id);
		
		model.addAttribute("entries", ds.getDateList());
		
		return "regularthings/listDates";
	}
	@RequestMapping(value="/editDate/{id}")
	public String editDate(@PathVariable(value="id") int id, Model model) {
		
		Date date = (Date)ds.getDate(id);
		
		model.addAttribute("date", date);
	
		
		return "/regularthings/editDate";
	}
	@RequestMapping(value="/updateDate", method = RequestMethod.POST)
	public String updateDate(@ModelAttribute Date date) {

		ds.updateDate(date);
		
		return "redirect:/listDates";
	}

	
	
}
