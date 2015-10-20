package de.mysystem.controller.journal;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.mysystem.controller.gtd.GtdService;
import de.mysystem.controller.gtd.GtdStatusFactory;

public class JournalController implements ApplicationContextAware {

    private static ApplicationContext context;
    
    
    public static ApplicationContext getApplicationContext() {
        return context;
    }

    @Override
    public void setApplicationContext(ApplicationContext ac)
            throws BeansException {
        context = ac;
    }


	@RequestMapping(value="/addLesson")
	public String addLesson(Model model) {
		
		JournalService js = context.getBean("journalService", JournalService.class);

		Lesson lesson= js.addLesson();
		
		return "redirect:/editLesson/" + lesson.getId();
	}
	@RequestMapping(value="/deleteLesson/{id}")
	public String deleteLesson(@PathVariable(value="id") int id, Model model) {
		JournalService js = context.getBean("journalService", JournalService.class);
		js.deleteLesson(id);
		
		model.addAttribute("entries", js.getJournalEntryList());
		
		return "gtd/listTasks";
	}

	@RequestMapping(value="/editLesson/{id}")
	public String editLesson(@PathVariable(value="id") int id, Model model) {
		
		JournalService js = context.getBean("journalService", JournalService.class);
		Lesson lesson = (Lesson)js.getLesson(id);
		
		model.addAttribute("lesson", lesson);
	
		
		return "/journal/editLesson";
	}

	@RequestMapping(value="/updateLesson", method = RequestMethod.POST)
	public String updateLesson(@ModelAttribute Lesson lesson) {

		JournalService js = context.getBean("journalService", JournalService.class);
		
		js.updateLesson(lesson);
		
		
		return "redirect:/listJournal";
	}
	
	
	
	
	@RequestMapping(value="/addTheWork")
	public String addTheWork(Model model) {
		
		JournalService js = context.getBean("journalService", JournalService.class);

		TheWork theWork= js.addTheWork();
		
		return "redirect:/editTheWork/" + theWork.getId();
	}
	@RequestMapping(value="/deleteTheWork/{id}")
	public String deleteTheWork(@PathVariable(value="id") int id, Model model) {
		JournalService js = context.getBean("journalService", JournalService.class);
		js.deleteTheWork(id);
		
		model.addAttribute("entries", js.getJournalEntryList());
		
		return "journal/listJournal";
	}

	@RequestMapping(value="/editTheWork/{id}")
	public String editTheWork(@PathVariable(value="id") int id, Model model) {
		
		JournalService js = context.getBean("journalService", JournalService.class);
		TheWork theWork = (TheWork)js.getTheWork(id);
		
		model.addAttribute("theWork", theWork);
	
		
		return "/journal/editTheWork";
	}

	@RequestMapping(value="/updateTheWork", method = RequestMethod.POST)
	public String updateTheWork(@ModelAttribute TheWork theWork) {

		JournalService js = context.getBean("journalService", JournalService.class);
		
		js.updateTheWork(theWork);
		
		
		return "redirect:/listJournal";
	}

	
	
	
	@RequestMapping(value="/addSdb")
	public String addSdb(Model model) {
		
		JournalService js = context.getBean("journalService", JournalService.class);

		SDB sdb= js.addSdb();
		
		return "redirect:/sdbTask/" + sdb.getId();
	}
	@RequestMapping(value="/deleteSdb/{id}")
	public String deleteSdb(@PathVariable(value="id") int id, Model model) {
		JournalService js = context.getBean("journalService", JournalService.class);
		js.deleteSdb(id);
		
		model.addAttribute("entries", js.getJournalEntryList());
		
		return "journal/listTasks";
	}

	@RequestMapping(value="/editSdb/{id}")
	public String editSdb(@PathVariable(value="id") int id, Model model) {
		
		JournalService js = context.getBean("journalService", JournalService.class);
		SDB sdb = (SDB)js.getSdb(id);
		
		model.addAttribute("sdb", sdb);
	
		
		return "/journal/editSDB";
	}

	@RequestMapping(value="/updateSdb", method = RequestMethod.POST)
	public String updateSDB(@ModelAttribute SDB sdb) {

		JournalService js = context.getBean("journalService", JournalService.class);
		
		js.updateSdb(sdb);
		
		
		return "redirect:/listJournal";
	}
	
	
	
	@RequestMapping(value="/addGratitude")
	public String addGratitude(Model model) {
		
		JournalService js = context.getBean("journalService", JournalService.class);

		Gratitude gratitude = js.addGratitude();
		
		return "redirect:/editGratitude/" + gratitude.getId();
	}
	@RequestMapping(value="/deleteGratitude/{id}")
	public String deleteGratitude(@PathVariable(value="id") int id, Model model) {
		JournalService js = context.getBean("journalService", JournalService.class);
		js.deleteGratitude(id);
		
		model.addAttribute("entries", js.getJournalEntryList());
		
		return "journal/listJournal";
	}

	@RequestMapping(value="/editGratitude/{id}")
	public String editGratitude(@PathVariable(value="id") int id, Model model) {
		
		JournalService js = context.getBean("journalService", JournalService.class);
		Gratitude gratitude = (Gratitude)js.getGratitude(id);
		
		model.addAttribute("gratitude", gratitude);
	
		
		return "/journal/editGratitude";
	}

	@RequestMapping(value="/updateGratitude", method = RequestMethod.POST)
	public String updateGratitude(@ModelAttribute Gratitude gratitude) {

		JournalService js = context.getBean("journalService", JournalService.class);
		
		js.updateGratitude(gratitude);
		
		
		return "redirect:/listJournal";
	}

	
}
