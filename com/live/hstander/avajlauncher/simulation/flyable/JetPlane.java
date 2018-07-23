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

	public void updateConditions() throws MyException
	{
		int lon = this.coordinates.getLongitude();
		int lat = this.coordinates.getLatitude();
		int height = this.coordinates.getHeight();
		String weather = this.weatherTower.getWeather(this.coordinates);
		String call = "JetPlane#" + this.name + "(" + this.id + ")";
		if (weather.equals("RAIN"))
		{
			MyWriter.myWriter.write(call + ": Splash! Splash!");
			if (height <= 0)
			{
				height = 0;
				MyWriter.myWriter.write(call + ": Landing We Shall");
				this.weatherTower.unregister(this);
			}
			else
				this.coordinates = new Coordinates(lon, lat + 5, height);
		}
		else if (weather.equals("FOG"))
		{
			MyWriter.myWriter.write(call + ": Is this the FORCE ? .... No wait its The FOG!");
			if (height <= 0)
			{
				height = 0;
				MyWriter.myWriter.write(call + ": Landing We Shall");
				this.weatherTower.unregister(this);
			}
			else
				this.coordinates = new Coordinates(lon, lat + 1, height);
		}
		else if (weather.equals("SUN"))
		{
			MyWriter.myWriter.write(call + ": The SUN ... OH the SUN");
			if ((height += 2) >= 100)
			{
				height = 100;
				this.coordinates = new Coordinates(lon, lat + 10, height);
			}
			else if (height <= 0)
			{
				height = 0;
				MyWriter.myWriter.write(call + ": Landing We Shall");
				this.weatherTower.unregister(this);
			}
			else
				this.coordinates = new Coordinates(lon, lat + 10, height);
		}
		else if (weather.equals("SNOW"))
		{
			MyWriter.myWriter.write(call + ": Freeeeeeeezzzzzzziiiinggg iiiiiiiiiiittttt iiiiiisssssss");
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
		this.weatherTower = weatherTower;
	}
}