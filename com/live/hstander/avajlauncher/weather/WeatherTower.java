package com.live.hstander.avajlauncher.weather;

import com.live.hstander.avajlauncher.simulation.flyable.*;
// import com.live.hstander.avajlauncher.simulation.Tower;

public class WeatherTower extends Tower
{
	private WeatherProvider weatherProvider; 

	public WeatherTower()
	{
		this.weatherProvider = WeatherProvider.getProvider();
	}

	public String getWeather(Coordinates coordinates)
	{
		return(this.weatherProvider.getCurrenttWeather(coordinates));
	}
	
	void changeWeather()
	{
		this.conditionsChanged();
	}

	public void registering(Flyable flyable)
	{
		this.register(flyable);
		flyable.registerTower(this);
	}

	public void test()
	{
		System.out.println("test works");
	}
}