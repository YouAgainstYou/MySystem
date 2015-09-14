package js.mysystem.model.entities.gtd;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class Task {
	
	@Id @GeneratedValue
	int id;
	String caption;
	Project parentProject;
	Task parentTask;
	Issue parentIssue;
	Question parentQuestion;

	
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	
}
