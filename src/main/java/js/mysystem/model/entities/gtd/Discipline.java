package js.mysystem.model.entities.gtd;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Discipline implements ToDo {

	@Id @GeneratedValue
	int id;
	String caption;
	
	
	@Override
	public int getId() {
		return id;
	}
	@Override
	public String getCaption() {
		return caption;
	}
	@Override
	public Project getParentProject() {
		return null;
	}
	@Override
	public Task getParentTask() {
		return null;
	}
	@Override
	public Issue getParentIssue() {
		return null;
	}
	@Override
	public Question getParentQuestion() {
		return null;
	}
	
	
		
}
