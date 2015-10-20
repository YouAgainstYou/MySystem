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

public class DateController implements ApplicationContextAware {

    private static ApplicationContext context;
    
    
    public static ApplicationContext getApplicationContext() {
        return context;
    }

    @Override
    public void setApplicationContext(ApplicationContext ac)
            throws BeansException {
        context = ac;
    }


    
	@RequestMapping(value="/addDate")
	public String addDate(Model model) {
		
		DateService ds = context.getBean("dateService", DateService.class);

		Date date= ds.addDate();
		
		return "redirect:/editDate/" + date.getId();
	}
	@RequestMapping(value="/deleteDate/{id}")
	public String deleteDate(@PathVariable(value="id") int id, Model model) {
		DateService ds = context.getBean("dateService", DateService.class);
		ds.deleteDate(id);
		
		model.addAttribute("entries", ds.getDateList());
		
		return "gtd/listDates";
	}
	@RequestMapping(value="/editDate/{id}")
	public String editDate(@PathVariable(value="id") int id, Model model) {
		
		DateService ds = context.getBean("dateService", DateService.class);
		Date date = (Date)ds.getDate(id);
		
		model.addAttribute("date", date);
	
		
		return "/gtd/editDate";
	}
	@RequestMapping(value="/updateDate", method = RequestMethod.POST)
	public String updateDate(@ModelAttribute Date date) {

		DateService ds = context.getBean("dateService", DateService.class);
		
		ds.updateDate(date);
		
		return "redirect:/listDates";
	}

	
	
}
