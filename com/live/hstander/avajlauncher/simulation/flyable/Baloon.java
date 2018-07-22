package com.live.hstander.avajlauncher.simulation.flyable;

import com.live.hstander.avajlauncher.weather.*;

public class Baloon extends Aircraft implements Flyable
{
	WeatherTower weatherTower;

	Baloon(String name, Coordinates coordinates)
	{
		super(name, coordinates);
		System.out.println("New Baloon YAY!!!");
	}

	public void updateConditions()
	{
		int lon = this.coordinates.getLongitude();
		int lat = this.coordinates.getLatitude();
		int height = this.coordinates.getHeight();
		String weather = this.weatherTower.getWeather(this.coordinates);
		System.out.println(this.name + " at " + height + " says");
		if (weather.equals("RAIN"))
		{
			System.out.println("OH NO! its Raining .... We are going to get wet!");
			if ((height -= 5) <= 0)
			{
				height = 0;
				/* 
					Land Balloon
					unregister from tower
				*/
				this.weatherTower.unregister(this);
				System.out.println("And we are Landing");
			}
			else
				this.coordinates = new Coordinates(lon, lat, height);
		}
		else if (weather.equals("FOG"))
		{
			System.out.println("Hmm i cant see anything ... better be safe and decrease height");
			if ((height -= 3) <= 0)
			{
				height = 0;
				/* 
					Land Balloon
					unregister from tower
				*/
				this.weatherTower.unregister(this);
				System.out.println("And we are Landing");
			}
			else
				this.coordinates = new Coordinates(lon, lat, height);
		}
		else if (weather.equals("SUN"))
		{
			System.out.println("What a view!");
			if ((height += 4) >= 100)
			{
				height = 100;
			}
			this.coordinates = new Coordinates(lon, lat, height);
		}
		else if (weather.equals("SNOW"))
		{
			System.out.println("This might have been a bad descicion");
			if ((height -= 15) <= 0)
			{
				height = 0;
				/* 
					Land Balloon
					unregister from tower
				*/
				this.weatherTower.unregister(this);
				System.out.println("And we are Landing");
			}
			else
				this.coordinates = new Coordinates(lon, lat, height);
		}
		// System.out.println("Baloon Weather update YAY!!!");
	}

	public void registerTower(WeatherTower weatherTower)
	{
		this.weatherTower = weatherTower;
	}
}