package com.live.hstander.avajlauncher.weather;

import com.live.hstander.avajlauncher.simulation.flyable.*;
import com.live.hstander.avajlauncher.simulation.*;

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
	
	void changeWeather() throws MyException
	{
		this.conditionsChanged();
	}

	public void registering(Flyable flyable)
	{
		this.register(flyable);
		flyable.registerTower(this);
	}

}