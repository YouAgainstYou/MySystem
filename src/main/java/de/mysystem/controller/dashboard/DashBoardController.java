package de.mysystem.controller.dashboard;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import de.mysystem.controller.history.HistoryService;

@Controller
public class DashBoardController implements ApplicationContextAware {

    private static ApplicationContext context;
    
    
    public static ApplicationContext getApplicationContext() {
        return context;
    }

    @Override
    public void setApplicationContext(ApplicationContext ac)
            throws BeansException {
        context = ac;
    }
    

	@RequestMapping(value="/dashboard")
	public String showDashboard(Model model) {
		HistoryService hs = context.getBean("historyService", HistoryService.class);

		model.addAttribute("history", hs.getHistory());
		
		return "dashboard";
	}
	
}
