package de.mysystem.controller.regularthings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import de.mysystem.helpers.Idgenerator;



@Service
@Scope("session")
public class DisciplineService {
	Map<Integer, Discipline> disciplines = new HashMap<Integer, Discipline>();
	

	
	public List<Discipline> getDisciplineList() {
		List<Discipline> disciplineList = new ArrayList<>();
		disciplineList.addAll(disciplines.values());
		
		return disciplineList;
	}
	public Discipline addDiscipline() {
		Discipline entry= new Discipline(getNextId(), "new Discipline");
		
		disciplines.put(entry.getId(), entry);
		
		return entry;
	}
	public void deleteDiscipline(int id) {
		disciplines.remove(id);
	}
	public Discipline getDiscipline(int id) {
		return (Discipline)disciplines.get(id);
	}
	public void updateDiscipline(Discipline discipline) {
		disciplines.put(discipline.getId(), discipline);
	}

	
	private int getNextId() {
		return Idgenerator.getNextId(disciplines.keySet());
	}


}
