package js.mysystem.model.entities.gtd;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Issue {

	@Id @GeneratedValue
	int id;
	String caption;
	String description;
	
	
	
}
