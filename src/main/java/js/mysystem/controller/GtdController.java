package js.mysystem.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import js.mysystem.model.daos.gtd.TaskDao;
import js.mysystem.model.entities.gtd.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class GtdController {
	
	@Autowired
	TaskDao taskDao;
	
	
	@RequestMapping(value="/listTasks")
	public String listTasks(HttpSession session) {
		List<Task> list = taskDao.readTasks();
		
		session.setAttribute("tasks", list);
		
		
		return "listTasks";
	}
	@RequestMapping(value="/editTask")
	public String editTask(HttpSession session) {
	
		

		
		return "listTasks";
	}


}
