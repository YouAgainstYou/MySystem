package js.mysystem.model.entities.gtd;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Question implements ToDo {

	@Id @GeneratedValue
	int id;
	String caption;
	String description;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public Project getParentProject() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Task getParentTask() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Issue getParentIssue() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Question getParentQuestion() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
