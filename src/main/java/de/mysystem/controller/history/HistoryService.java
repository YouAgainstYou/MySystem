package de.mysystem.controller.history;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service
@Scope("session")
public class HistoryService {
	
	Map<Integer, HistoryEntry> history = new HashMap<Integer, HistoryEntry>();

	public List<HistoryEntry> getHistory() {
		List<HistoryEntry> result = new ArrayList<>();
		result.addAll(history.values());
		
		return result;
	}
	
	public void addEntry(String text) {
		System.out.println(text);
		history.put(0, new HistoryEntry(0,  text));
	}
	
	
}
