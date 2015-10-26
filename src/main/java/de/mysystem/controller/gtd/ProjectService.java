package de.mysystem.controller.gtd;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import de.mysystem.helpers.Idgenerator;

@Service
@Scope("session")
public class ProjectService  {
	
	Map<Integer, Project> projects = new HashMap<Integer, Project>();
	
	
	
	@PostConstruct
	public void init() {
		projects.put(0, new Project(0, "10000"));
		projects.put(1, new Project(1, "118"));
		projects.put(2, new Project(2, "PMP"));
		projects.put(3, new Project(3, "MY SYSTEM 1.0"));
		projects.put(4, new Project(4, "100"));
	}

	
	
	
	public Project addProject() {
		Project issue = new Project(getNextId(), "new Project");
		
		projects.put(issue.getId(), issue);
		
		return issue;
	}

	public void deleteProject(int id) {
		projects.remove(id);
	}

	public Project getProject(int id) {
		return (Project)projects.get(id);
	}

	public void updateProject(Project project) {
		projects.put(project.getId(), project);
	}

	
	
	private int getNextId() {
		return Idgenerator.getNextId(projects.keySet());
	}
}
