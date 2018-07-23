package com.live.hstander.avajlauncher.simulation.flyable;

import com.live.hstander.avajlauncher.weather.*;
import com.live.hstander.avajlauncher.simulation.*;

public class Helicopter extends Aircraft implements Flyable
{
	WeatherTower weatherTower;

	Helicopter(String name, Coordinates coordinates)
	{
		super(name, coordinates);
	}

	public void updateConditions() throws MyException
	{
		int lon = this.coordinates.getLongitude();
		int lat = this.coordinates.getLatitude();
		int height = this.coordinates.getHeight();
		String weather = this.weatherTower.getWeather(this.coordinates);
		String call = "Helicopter#" + this.name + "(" + this.id + ")";
		if (weather.equals("RAIN"))
		{
			MyWriter.myWriter.write(call + ": A little Rain never killed anyone ... I think");
			if (height <= 0)
			{
				height = 0;
				MyWriter.myWriter.write(call + ": We Going to Land ... maybe");
				this.weatherTower.unregister(this);
			}
			else
				this.coordinates = new Coordinates(lon + 5, lat, height);
		}
		else if (weather.equals("FOG"))
		{
			MyWriter.myWriter.write(call + ": Now you See me ... Now you dont !!");
			if (height <= 0)
			{
				height = 0;
				MyWriter.myWriter.write(call + ": We Going to Land ... maybe");
				this.weatherTower.unregister(this);
			}
			else
				this.coordinates = new Coordinates(lon + 1, lat, height);
		}
		else if (weather.equals("SUN"))
		{
			MyWriter.myWriter.write(call + ": Better put my Sunglasses on");
			if ((height += 2) >= 100)
			{
				height = 100;
				this.coordinates = new Coordinates(lon + 10, lat, height);
			}
			else if (height <= 0)
			{
				height = 0;
				MyWriter.myWriter.write(call + ": We Going to Land ... maybe");
				this.weatherTower.unregister(this);
			}
			else
				this.coordinates = new Coordinates(lon + 10, lat, height);
		}
		else if (weather.equals("SNOW"))
		{
			MyWriter.myWriter.write(call + ": The Snow ... Oh the Snow ... How white");
			if ((height -= 12) <= 0)
			{
				height = 0;
				MyWriter.myWriter.write(call + ": We Going to Land ... maybe");
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