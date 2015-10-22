package de.mysystem.controller.gtd;

import java.util.ArrayList;
import java.util.List;

public class GtdStatusFactory {
	
	public static final List<GtdStatus> getTaskStati() {
		List<GtdStatus> result = new ArrayList<>();
		result.add(GtdStatus.OPEN);
		result.add(GtdStatus.READY);
		result.add(GtdStatus.STARTED);
		result.add(GtdStatus.DONE);
		
		return result;
	}
	public static final List<GtdStatus> getIssueStati() {
		List<GtdStatus> result = new ArrayList<>();
		result.add(GtdStatus.OPEN);
		result.add(GtdStatus.RESOLVED);
		
		return result;
	}
	public static final List<GtdStatus> getQuestionStati() {
		List<GtdStatus> result = new ArrayList<>();
		result.add(GtdStatus.UNANSWERED);
		result.add(GtdStatus.ANSWERED);
		
		return result;

	}

	public static final List<GtdStatus> getProjectStati() {
		List<GtdStatus> result = new ArrayList<>();
		result.add(GtdStatus.OPEN);
		result.add(GtdStatus.ACTIVE);
		result.add(GtdStatus.DONE);
		
		return result;
	}

}
