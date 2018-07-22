package com.live.hstander.avajlauncher.simulation.flyable;

import com.live.hstander.avajlauncher.weather.*;
// import java.util.*;

public class AircraftFactory
{
	public Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
	{
		if (type.equals("Baloon"))
		{
			return(new Baloon(name, new Coordinates(longitude, latitude, height)));
		}
		else if (type.equals("Helicopter"))
		{
			return(new Helicopter(name, new Coordinates(longitude, latitude, height)));
		}
		else if (type.equals("JetPlane"))
		{
			return(new JetPlane(name, new Coordinates(longitude, latitude, height)));
		}
		else
		{
			/* 
				throw an Exception 
			*/
			System.out.println("Invalid Flyable type: " + type);
			System.exit(-1);
		}
		return(null);
	}
}