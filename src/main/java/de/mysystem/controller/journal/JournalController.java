package de.mysystem.controller.journal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class JournalController  {

	@Autowired
	JournalService js;

	@RequestMapping(value="/listJournal")
	public String listTasks(Model model) {

		model.addAttribute("entries", js.getJournalEntryList());
		
		return "/journal/listJournal";
	}

    
	@RequestMapping(value="/addLesson")
	public String addLesson(Model model) {
		System.out.println("lesson added");

		Lesson lesson= js.addLesson();
		
		return "redirect:/editLesson/" + lesson.getId();
	}
	@RequestMapping(value="/deleteLesson/{id}")
	public String deleteLesson(@PathVariable(value="id") int id, Model model) {

		js.deleteLesson(id);
		
		model.addAttribute("entries", js.getJournalEntryList());
		
		return "journal/listJournal";
	}

	@RequestMapping(value="/editLesson/{id}")
	public String editLesson(@PathVariable(value="id") int id, Model model) {
		System.out.println("lesson edit called");

		Lesson lesson = (Lesson)js.getLesson(id);
		
		model.addAttribute("lesson", lesson);
	
		
		return "/journal/editLesson";
	}

	@RequestMapping(value="/updateLesson", method = RequestMethod.POST)
	public String updateLesson(@ModelAttribute Lesson lesson) {

		js.updateLesson(lesson);
		
		return "redirect:/listJournal";
	}
	
	
	
	
	@RequestMapping(value="/addTheWork")
	public String addTheWork(Model model) {

		TheWork theWork= js.addTheWork();
		
		return "redirect:/editTheWork/" + theWork.getId();
	}
	@RequestMapping(value="/deleteTheWork/{id}")
	public String deleteTheWork(@PathVariable(value="id") int id, Model model) {

		js.deleteTheWork(id);
		
		model.addAttribute("entries", js.getJournalEntryList());
		
		return "journal/listJournal";
	}

	@RequestMapping(value="/editTheWork/{id}")
	public String editTheWork(@PathVariable(value="id") int id, Model model) {
		

		TheWork theWork = (TheWork)js.getTheWork(id);
		
		model.addAttribute("theWork", theWork);
	
		
		return "/journal/editTheWork";
	}

	@RequestMapping(value="/updateTheWork", method = RequestMethod.POST)
	public String updateTheWork(@ModelAttribute TheWork theWork) {

		js.updateTheWork(theWork);
				
		return "redirect:/listJournal";
	}

	
	
	
	@RequestMapping(value="/addSdb")
	public String addSdb(Model model) {
		
		SDB sdb= js.addSdb();
		
		return "redirect:/editSdb/" + sdb.getId();
	}
	@RequestMapping(value="/deleteSdb/{id}")
	public String deleteSdb(@PathVariable(value="id") int id, Model model) {

		js.deleteSdb(id);
		
		model.addAttribute("entries", js.getJournalEntryList());
		
		return "journal/listJournal";
	}

	@RequestMapping(value="/editSdb/{id}")
	public String editSdb(@PathVariable int id, Model model) {
		
		SDB sdb = (SDB)js.getSdb(id);
		
		model.addAttribute("sdb", sdb);
	
		
		return "/journal/editSdb";
	}

	@RequestMapping(value="/updateSdb", method = RequestMethod.POST)
	public String updateSDB(@ModelAttribute SDB sdb) {
		
		js.updateSdb(sdb);
				
		return "redirect:/listJournal";
	}
	
	
	
	@RequestMapping(value="/addGratitude")
	public String addGratitude(Model model) {

		Gratitude gratitude = js.addGratitude();
		
		return "redirect:/editGratitude/" + gratitude.getId();
	}
	@RequestMapping(value="/deleteGratitude/{id}")
	public String deleteGratitude(@PathVariable int id, Model model) {

		js.deleteGratitude(id);
		
		model.addAttribute("entries", js.getJournalEntryList());
		
		return "journal/listJournal";
	}

	@RequestMapping(value="/editGratitude/{id}")
	public String editGratitude(@PathVariable int id, Model model) {
		
		Gratitude gratitude = (Gratitude)js.getGratitude(id);
		
		model.addAttribute("gratitude", gratitude);
	
		
		return "/journal/editGratitude";
	}

	@RequestMapping(value="/updateGratitude", method = RequestMethod.POST)
	public String updateGratitude(@ModelAttribute Gratitude gratitude) {
		
		js.updateGratitude(gratitude);
		
		
		return "redirect:/listJournal";
	}

	
}
