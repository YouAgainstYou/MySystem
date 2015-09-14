package js.mysystem.model.entities.habits;

import javax.persistence.Entity;

@Entity
public class Habit {
	
	int id;
	String cue;
	String routine;
	String reward;
	String visualisation;
	
}
