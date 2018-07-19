package com.live.hstander.avajlauncher.weather;

import com.live.hstander.avajlauncher.simulation.flyable.*;

public class WeatherProvider
{
	private WeatherProvider weatherProvider;
	private String weather;

	private WeatherProvider()
	{
		this.weatherProvider = new WeatherProvider();
	}

	public WeatherProvider getProvider()
	{
		return(this.weatherProvider);
	}

	public String getCurrenttWeather(Coordinates coordinates)
	{
		return(this.weather);
	}
}