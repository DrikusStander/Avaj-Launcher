package com.live.hstander.avajlauncher.weather;

import java.util.Random;

import com.live.hstander.avajlauncher.simulation.flyable.*;

public class WeatherProvider
{
	private static WeatherProvider weatherProvider;
	private static String weather;

	private WeatherProvider()
	{
		weatherProvider = this;
	}

	public static WeatherProvider getProvider()
	{
		new WeatherProvider();
		return(weatherProvider);
	}

	public String getCurrenttWeather(Coordinates coordinates)
	{
		Random random = new Random();
		String[] weatherOptions = {"RAIN", "FOG", "SUN", "SNOW"};
		int lat = coordinates.getLatitude();
		int lon = coordinates.getLongitude();
		int height = coordinates.getHeight();
		int index = (lat + lon + height + (random.nextInt(50) * 3)) % 4;
		weather = weatherOptions[index];
		return(weather);
	}
}