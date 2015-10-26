package de.mysystem.controller.gtd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import de.mysystem.controller.history.HistoryService;


@Controller
@SessionAttributes({"areasOfLife", "projectStati", "issueStati"})
public class GtdController {

    @Autowired
    private GtdService gs;
    
    @Autowired
    private ProjectService ps;
    
    @Autowired
    private HistoryService hs;
    
    
	@RequestMapping(value="/listTasks")
	public String listTasks(Model model) {
		
		model.addAttribute("tasks", gs.getTaskList());
		
		return "gtd/listTasks";
	}
	
	@RequestMapping(value="/addTask")
	public String addTask(Model model) {

		Task task = gs.addTask();
		
		hs.addEntry("task added");
		
		return "redirect:/editTask/" + task.getId();
	}

	@RequestMapping(value="/deleteTask/{id}")
	public String deleteTask(@PathVariable(value="id") int id, Model model) {

		gs.deleteTask(id);
		
		model.addAttribute("tasks", gs.getTaskList());
		
		return "gtd/listTasks";
	}
	
	@RequestMapping(value="/editTask/{id}")
	public String editTask(@PathVariable int id, Model model) {

		Task taskToEdit = (Task)gs.getTask(id);
		
		model.addAttribute("task", taskToEdit);
		
		model.addAttribute("taskStati", GtdStatusFactory.getTaskStati());
	
		return "/gtd/editTask";
	}

	@RequestMapping(value="/updateTask", method = RequestMethod.POST)
	public String updateTask(@ModelAttribute("task") Task task) {

		gs.updateTask(task);
		
		return "redirect:/listTasks";
	}

	

	@RequestMapping(value="/addIssue")
	public String addIssue(Model model) {

		Issue issue = gs.addIssue();
		
		return "redirect:/editIssue/" + issue.getId();
	}
	@RequestMapping(value="/deleteIssue/{id}")
	public String deleteIssue(@PathVariable int id, Model model) {

		gs.deleteIssue(id);
		
		model.addAttribute("tasks", gs.getTaskList());
		
		return "gtd/listTasks";
	}

	@RequestMapping(value="/editIssue/{id}")
	public String editIssue(@PathVariable(value="id") int id, Model model) {
		
		Issue issueToEdit = (Issue)gs.getIssue(id);
		
		model.addAttribute("issue", issueToEdit);
	
		model.addAttribute("issueStati", GtdStatusFactory.getIssueStati());

		
		return "/gtd/editIssue";
	}

	@RequestMapping(value="/updateIssue", method = RequestMethod.POST)
	public String updateIssue(@ModelAttribute Issue issue) {
		
		gs.updateIssue(issue);
		
		return "redirect:/listTasks";
	}

	
	@RequestMapping(value="/addQuestion")
	public String addQuestion(Model model) {
		
		Question question = gs.addQuestion();
		
		return "redirect:/editQuestion/" + question.getId();
	}
	@RequestMapping(value="/deleteQuestion/{id}")
	public String deleteQuestion(@PathVariable int id, Model model) {

		gs.deleteQuestion(id);
		
		model.addAttribute("tasks", gs.getTaskList());
		
		return "gtd/listTasks";
	}

	@RequestMapping(value="/editQuestion/{id}")
	public String editQuestion(@PathVariable int id, Model model) {
		
		Question questionToEdit = (Question)gs.getQuestion(id);
		
		model.addAttribute("question", questionToEdit);
		model.addAttribute("taskQuestion", GtdStatusFactory.getQuestionStati());

		return "/gtd/editQuestion";
	}

	@RequestMapping(value="/updateQuestion", method = RequestMethod.POST)
	public String updateQuestion(@ModelAttribute Question question) {

		gs.updateQuestion(question);
		
		return "redirect:/listTasks";
	}
	
	
	
	@RequestMapping(value="/addProject")
	public String addProject(Model model) {

		Project Project = gs.addProject();
		
		hs.addEntry("Project added");
		
		return "redirect:/editProject/" + Project.getId();
	}

	@RequestMapping(value="/deleteProject/{id}")
	public String deleteProject(@PathVariable int id, Model model) {

		gs.deleteProject(id);
		
		model.addAttribute("projects", gs.getTaskList());
		
		return "gtd/listProjects";
	}
	
	@RequestMapping(value="/editProject/{id}")
	public String editProject(@PathVariable int id, Model model) {

		Project projectToEdit = (Project)ps.getProject(id);
		
		model.addAttribute("Project", projectToEdit);
		

		return "/gtd/editProject";
	}

	@RequestMapping(value="/updateProject", method = RequestMethod.POST)
	public String updateProject(@ModelAttribute("project") Project project) {

		gs.updateProject(project);
		
		return "redirect:/listProjects";
	}
	
	
	@ModelAttribute(value="areasOfLife")
	public List<AreaOfLife> getAreasOfLife() {
		return AreaOfLifeFactory.getAreasOfLife();
	}
	
	@ModelAttribute(value="projectStati")
	public List<GtdStatus> getProjectStati() {
		return GtdStatusFactory.getProjectStati();
	}
	
	@ModelAttribute(value="issueStati")
	public List<GtdStatus> getIssueStati() {
		return GtdStatusFactory.getIssueStati();
	}
	
	
	
}
