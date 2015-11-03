package de.mysystem.controller.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import de.mysystem.controller.history.HistoryService;

@Controller
public class DashBoardController  {

	@Autowired
	HistoryService hs;

	@RequestMapping(value="/dashboard")
	public String showDashboard(Model model) {

		model.addAttribute("history", hs.getHistory());
		
		return "dashboard";
	}
	
}
