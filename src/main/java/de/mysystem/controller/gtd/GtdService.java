package de.mysystem.controller.gtd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("session")
public class GtdService  {
	
	Map<Integer, ToDo> todos = new HashMap<Integer, ToDo>();
	
	
	
	@PostConstruct
	public void init() {
		todos.put(1, new Task(1, "do this"));
		todos.put(2, new Task(2, "do that"));
		todos.put(3, new Question(3, "What's this?", ""));
		System.out.println("yes, it was called");
	}

	
	
	
	public List<ToDo> getTaskList() {
		List<ToDo> tasksList = new ArrayList<>();
		tasksList.addAll(todos.values());
		
		return tasksList;
	}

	
	public Task addTask() {
		Task task = new Task(getNextId(), "new Task");
		
		todos.put(task.getId(), task);
		
		return task;
	}
	public void deleteTask(int id) {
		todos.remove(id);
	}

	public Task getTask(int id) {
		return (Task)todos.get(id);
	}

	public void updateTask(Task task) {
		todos.put(task.getId(), task);
	}

	
	
	public Issue addIssue() {
		Issue issue = new Issue(getNextId(), "new Issue");
		
		todos.put(issue.getId(), issue);
		
		return issue;
	}

	public void deleteIssue(int id) {
		todos.remove(id);
	}

	public Issue getIssue(int id) {
		return (Issue)todos.get(id);
	}

	public void updateIssue(Issue issue) {
		todos.put(issue.getId(), issue);
	}


	
	
	public Question addQuestion() {
		Question question = new Question(getNextId(), "new Question", "");
		
		todos.put(question.getId(), question);
		
		return question;
	}

	public void deleteQuestion(int id) {
		todos.remove(id);
	}

	public Question getQuestion(int id) {
		return (Question)todos.get(id);
	}

	public void updateQuestion(Question question) {
		todos.put(question.getId(), question);
	}
	
	
	public Project addProject() {
		Project issue = new Project(getNextId(), "new Project");
		
		todos.put(issue.getId(), issue);
		
		return issue;
	}

	public void deleteProject(int id) {
		todos.remove(id);
	}

	public Project getProject(int id) {
		return (Project)todos.get(id);
	}

	public void updateProject(Project issue) {
		todos.put(issue.getId(), issue);
	}

	
	
	private int getNextId() {
		int id = Collections.max(todos.keySet());
		
		return id + 1;
	}
}
