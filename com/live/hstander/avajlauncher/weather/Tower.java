package com.live.hstander.avajlauncher.weather;

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
		long id = -1;
		if (flyable instanceof Aircraft)
			id = ( (Aircraft)flyable ).getId();
		int i = 0;
		for (Flyable obs : observers)
		{
			if (obs instanceof Aircraft)
			{
				if ( ( (Aircraft)obs ).getId() == id)
				{
					break;
				}
			}
			i++;
		}
		if (i > -1)
			observers.remove(i);
	}
	
	protected void conditionsChanged()
	{
		if (observers.isEmpty() == false)
		{ 
			for (int i = 0; i < observers.size(); i++)
			{
				observers.get(i).updateConditions();
			}
		}
	}

}