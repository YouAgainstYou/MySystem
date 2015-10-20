package de.mysystem.controller.gtd;

public class Question implements ToDo {
	int id;
	String question;
	String answer;
	GtdStatus status;
	ToDo parent;

	public Question() {};
	
	public Question(int id, String question, String answer) {
		this.id = id;
		this.question = question;
		this.answer = answer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return question;
	}
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getType() {
		return "Question";
	}

}
