package de.mysystem.controller.gtd;

import java.util.ArrayList;
import java.util.List;

public class AreaOfLifeFactory {
	public static final List<AreaOfLife> getAreasOfLife() {
		List<AreaOfLife> result = new ArrayList<>();
		result.add(AreaOfLife.JOB);
		result.add(AreaOfLife.RELATIONSHIPS);
		result.add(AreaOfLife.WEALTH);
		result.add(AreaOfLife.HEALTH);
		result.add(AreaOfLife.SPIRITIALITY);
		
		return result;
	}

}
