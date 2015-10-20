package de.mysystem.helpers;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class Idgenerator {

	public final static int getNextId(Set<Integer> keySet) {
		
		if(keySet.size() == 0) {
			return 0;
		} else {
			Integer id = Collections.max(keySet);
			
			return id + 1;
		}
	}
	
}
