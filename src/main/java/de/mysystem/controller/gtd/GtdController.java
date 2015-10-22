package de.mysystem.controller.gtd;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import de.mysystem.controller.history.HistoryService;


@Controller
public class GtdController implements ApplicationContextAware {

    private static ApplicationContext context;
    
    
    public static ApplicationContext getApplicationContext() {
        return context;
    }

    @Override
    public void setApplicationContext(ApplicationContext ac)
            throws BeansException {
        context = ac;
    }

	
	@RequestMapping(value="/listTasks")
	public String listTasks(Model model) {
		GtdService gs = context.getBean("gtdService", GtdService.class);
		model.addAttribute("tasks", gs.getTaskList());
		
		return "gtd/listTasks";
	}
	
	@RequestMapping(value="/addTask")
	public String addTask(Model model) {

		GtdService gs = context.getBean("gtdService", GtdService.class);
		Task task = gs.addTask();
		
		HistoryService hs = context.getBean("historyService", HistoryService.class);
		hs.addEntry("task added");
		
		return "redirect:/editTask/" + task.getId();
	}

	@RequestMapping(value="/deleteTask/{id}")
	public String deleteTask(@PathVariable(value="id") String id, Model model) {
		GtdService gs = context.getBean("gtdService", GtdService.class);
		gs.deleteTask(Integer.valueOf(id));
		
		model.addAttribute("tasks", gs.getTaskList());
		
		return "gtd/listTasks";
	}
	
	@RequestMapping(value="/editTask/{id}")
	public String editTask(@PathVariable(value="id") String id, Model model) {
		GtdService gs = context.getBean("gtdService", GtdService.class);
		Task taskToEdit = (Task)gs.getTask(Integer.valueOf(id));
		
		model.addAttribute("task", taskToEdit);
		
		model.addAttribute("taskStati", GtdStatusFactory.getTaskStati());
	
		return "/gtd/editTask";
	}

	@RequestMapping(value="/updateTask", method = RequestMethod.POST)
	public String updateTask(@ModelAttribute("task") Task task) {

		GtdService gs = context.getBean("gtdService", GtdService.class);
		
		gs.updateTask(task);
		
		
		return "redirect:/listTasks";
	}

	

	@RequestMapping(value="/addIssue")
	public String addIssue(Model model) {
		
		GtdService gs = context.getBean("gtdService", GtdService.class);

		Issue issue = gs.addIssue();
		
		return "redirect:/editIssue/" + issue.getId();
	}
	@RequestMapping(value="/deleteIssue/{id}")
	public String deleteIssue(@PathVariable(value="id") String id, Model model) {
		GtdService gs = context.getBean("gtdService", GtdService.class);
		gs.deleteIssue(Integer.valueOf(id));
		
		model.addAttribute("tasks", gs.getTaskList());
		
		return "gtd/listTasks";
	}

	@RequestMapping(value="/editIssue/{id}")
	public String editIssue(@PathVariable(value="id") int id, Model model) {
		
		GtdService gs = context.getBean("gtdService", GtdService.class);
		Issue issueToEdit = (Issue)gs.getIssue(id);
		
		model.addAttribute("issue", issueToEdit);
	
		model.addAttribute("issueStati", GtdStatusFactory.getIssueStati());

		
		return "/gtd/editIssue";
	}

	@RequestMapping(value="/updateIssue", method = RequestMethod.POST)
	public String updateIssue(@ModelAttribute Issue issue) {

		GtdService gs = context.getBean("gtdService", GtdService.class);
		
		gs.updateIssue(issue);
		
		
		return "redirect:/listTasks";
	}

	
	@RequestMapping(value="/addQuestion")
	public String addQuestion(Model model) {
		
		GtdService gs = context.getBean("gtdService", GtdService.class);
		
		Question question = gs.addQuestion();
		
		return "redirect:/editQuestion/" + question.getId();
	}
	@RequestMapping(value="/deleteQuestion/{id}")
	public String deleteQuestion(@PathVariable(value="id") String id, Model model) {
		GtdService gs = context.getBean("gtdService", GtdService.class);
		gs.deleteQuestion(Integer.valueOf(id));
		
		model.addAttribute("tasks", gs.getTaskList());
		
		return "gtd/listTasks";
	}

	@RequestMapping(value="/editQuestion/{id}")
	public String editQuestion(@PathVariable(value="id") String id, Model model) {
		
		GtdService gs = context.getBean("gtdService", GtdService.class);
		Question questionToEdit = (Question)gs.getQuestion(Integer.valueOf(id));
		
		model.addAttribute("question", questionToEdit);
		model.addAttribute("taskQuestion", GtdStatusFactory.getQuestionStati());

		return "/gtd/editQuestion";
	}

	@RequestMapping(value="/updateQuestion", method = RequestMethod.POST)
	public String updateQuestion(@ModelAttribute Question question) {

		GtdService gs = context.getBean("gtdService", GtdService.class);

		
		gs.updateQuestion(question);
		
		
		return "redirect:/listTasks";
	}
	
	
	
	@RequestMapping(value="/addProject")
	public String addProject(Model model) {

		GtdService gs = context.getBean("gtdService", GtdService.class);
		Project Project = gs.addProject();
		
		HistoryService hs = context.getBean("historyService", HistoryService.class);
		hs.addEntry("Project added");
		
		return "redirect:/editProject/" + Project.getId();
	}

	@RequestMapping(value="/deleteProject/{id}")
	public String deleteProject(@PathVariable(value="id") String id, Model model) {
		GtdService gs = context.getBean("gtdService", GtdService.class);
		gs.deleteProject(Integer.valueOf(id));
		
		model.addAttribute("Projects", gs.getTaskList());
		
		return "gtd/listProjects";
	}
	
	@RequestMapping(value="/editProject/{id}")
	public String editProject(@PathVariable(value="id") String id, Model model) {
		GtdService gs = context.getBean("gtdService", GtdService.class);
		Project projectToEdit = (Project)gs.getProject(Integer.valueOf(id));
		
		model.addAttribute("Project", projectToEdit);
		
		model.addAttribute("ProjectStati", GtdStatusFactory.getTaskStati());
	
		return "/gtd/editProject";
	}

	@RequestMapping(value="/updateProject", method = RequestMethod.POST)
	public String updateProject(@ModelAttribute("project") Project project) {

		GtdService gs = context.getBean("gtdService", GtdService.class);
		
		gs.updateProject(project);
		
		
		return "redirect:/listProjects";
	}
	
}
