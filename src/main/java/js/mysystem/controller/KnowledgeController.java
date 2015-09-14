package js.mysystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class KnowledgeController {

	@RequestMapping(value="/listDecks")
	public String listDecks() {
		
		return "listDecks";
	}
	@RequestMapping(value="/editDecks")
	public String editDecks() {
		
		return "editDecks";
	}

	
	@RequestMapping(value="/listCards")
	public String listCards() {
		
		return "listCards";
	}
	@RequestMapping(value="/editCard")
	public String editCard() {
		
		return "editCard";
	}

	
}
