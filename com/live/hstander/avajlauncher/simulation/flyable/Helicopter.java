package com.live.hstander.avajlauncher.simulation.flyable;

import com.live.hstander.avajlauncher.weather.*;

public class Helicopter extends Aircraft implements Flyable
{
	WeatherTower weatherTower;

	Helicopter(String name, Coordinates coordinates)
	{
		super(name, coordinates);
	}

	public void updateConditions()
	{
		this.weatherTower.getWeather(this.coordinates);
	}

	public void registerTower(WeatherTower WeatherTower)
	{
		this.weatherTower = weatherTower;
	}
}