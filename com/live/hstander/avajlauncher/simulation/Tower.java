package com.live.hstander.avajlauncher.simulation;

import com.live.hstander.avajlauncher.simulation.flyable.*;
import java.util.*;

public class Tower
{
	private List<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable)
	{
		this.observers.add(flyable);
	}

	public void unregister(Flyable flyable)
	{
		// long id = flyable.getId();
		// int i = 0;
		// for (Flyable obs : observers)
		// {
		// 	if (obs.getId() == id)
		// 	{
		// 		break;
		// 	}
		// 	i++;
		// }
		// observers.remove(i);
	}
	
	protected void conditionsChanged()
	{
		
	}

}