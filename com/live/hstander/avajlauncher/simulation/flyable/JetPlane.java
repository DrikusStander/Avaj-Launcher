package com.live.hstander.avajlauncher.simulation.flyable;

import com.live.hstander.avajlauncher.weather.*;
import com.live.hstander.avajlauncher.simulation.*;

public class JetPlane extends Aircraft implements Flyable
{
	WeatherTower weatherTower;

	JetPlane(String name, Coordinates coordinates)
	{
		super(name, coordinates);
	}

	public void updateConditions()
	{
		int lon = this.coordinates.getLongitude();
		int lat = this.coordinates.getLatitude();
		int height = this.coordinates.getHeight();
		String weather = this.weatherTower.getWeather(this.coordinates);
		String call = "JetPlane#" + this.name + "(" + this.id + ")";
		if (weather.equals("RAIN"))
		{
			MyWriter.myWriter.write(call + ": OH NO! its Raining .... We are going to get wet!");
			// if ((height -= 5) <= 0)
			// {
			// 	height = 0;
			// 	MyWriter.myWriter.write(call + ": And we are Landing");
			// 	this.weatherTower.unregister(this);
			// }
			// else
				this.coordinates = new Coordinates(lon, lat + 5, height);
		}
		else if (weather.equals("FOG"))
		{
			MyWriter.myWriter.write(call + ": Hmm i cant see anything ... better be safe and decrease height");
			// if ((height -= 3) <= 0)
			// {
			// 	height = 0;
			// 	MyWriter.myWriter.write(call + ": And we are Landing");
			// 	this.weatherTower.unregister(this);
			// }
			// else
				this.coordinates = new Coordinates(lon, lat + 1, height);
		}
		else if (weather.equals("SUN"))
		{
			MyWriter.myWriter.write(call + ": What a view!");
			if ((height += 2) >= 100)
			{
				height = 100;
			}
			this.coordinates = new Coordinates(lon, lat + 10, height);
		}
		else if (weather.equals("SNOW"))
		{
			MyWriter.myWriter.write(call + ": This might have been a bad descicion");
			if ((height -= 7) <= 0)
			{
				height = 0;
				MyWriter.myWriter.write(call + ": And we are Landing");
				this.weatherTower.unregister(this);
			}
			else
				this.coordinates = new Coordinates(lon, lat, height);
		}
	}

	public void registerTower(WeatherTower weatherTower)
	{
		weatherTower.test();
		this.weatherTower = weatherTower;
	}
}