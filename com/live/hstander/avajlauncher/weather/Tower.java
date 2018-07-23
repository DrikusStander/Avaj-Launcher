package com.live.hstander.avajlauncher.weather;

import com.live.hstander.avajlauncher.simulation.flyable.*;
import com.live.hstander.avajlauncher.simulation.*;
import java.util.*;

public class Tower
{
	private List<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable)
	{
		this.observers.add(flyable);
		long id;
		String name;
		if (flyable instanceof Baloon)
		{
			id = ((Baloon)flyable).getId();
			name = ((Baloon)flyable).getName();
			MyWriter.myWriter.write("Tower says: Baloon#" + name + "(" + id + ") registered to weather tower");
		}
		else if (flyable instanceof JetPlane)
		{
			id = ((JetPlane)flyable).getId();
			name = ((JetPlane)flyable).getName();
			MyWriter.myWriter.write("Tower says: JetPlane#" + name + "(" + id + ") registered to weather tower");
		}
		else if (flyable instanceof Helicopter)
		{
			id = ((Helicopter)flyable).getId();
			name = ((Helicopter)flyable).getName();
			MyWriter.myWriter.write("Tower says: Helicopter#" + name + "(" + id + ") registered to weather tower");
		}
		
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
		{
			String name;
			if (flyable instanceof Baloon)
			{
				name = ((Baloon)flyable).getName();
				MyWriter.myWriter.write("Tower says: Baloon#" + name + "(" + id + ") unregistered from weather tower");
			}
			else if (flyable instanceof JetPlane)
			{
				name = ((JetPlane)flyable).getName();
				MyWriter.myWriter.write("Tower says: JetPlane#" + name + "(" + id + ") unregistered from weather tower");
			}
			else if (flyable instanceof Helicopter)
			{
				name = ((Helicopter)flyable).getName();
				MyWriter.myWriter.write("Tower says: Helicopter#" + name + "(" + id + ") unregistered from weather tower");
			}
			observers.remove(i);
		}
	}
	
	protected void conditionsChanged() throws MyException
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