package js.mysystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TrainingController {

	@RequestMapping(value="/correctAnswer") 
	public String correctAnswer() {
		
		
		return getTarget();
	}
	@RequestMapping(value="/wrongAnswer") 
	public String wrongAnswer() {
		
		
		return getTarget();
	}

	
	private String getTarget() {
		return "training";
	}
	
}
