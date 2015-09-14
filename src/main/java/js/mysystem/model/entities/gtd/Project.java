package js.mysystem.model.entities.gtd;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Project {

	@Id @GeneratedValue
	int id;
	String caption;
	Project parentProject;
	Task parentTask;
	Issue parentIssue;
	Question parentQuestion;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public Project getParentProject() {
		return parentProject;
	}
	public void setParentProject(Project parentProject) {
		this.parentProject = parentProject;
	}
	public Task getParentTask() {
		return parentTask;
	}
	public void setParentTask(Task parentTask) {
		this.parentTask = parentTask;
	}
	public Issue getParentIssue() {
		return parentIssue;
	}
	public void setParentIssue(Issue parentIssue) {
		this.parentIssue = parentIssue;
	}
	public Question getParentQuestion() {
		return parentQuestion;
	}
	public void setParentQuestion(Question parentQuestion) {
		this.parentQuestion = parentQuestion;
	}
	
	
	
	
}
