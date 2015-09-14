package js.mysystem.model.entities.gtd;

public interface ToDo {

	public int getId();
	public String getCaption();
	public Project getParentProject();
	public Task getParentTask();
	public Issue getParentIssue();
	public Question getParentQuestion();
	
}
