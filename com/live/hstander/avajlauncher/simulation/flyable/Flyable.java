package com.live.hstander.avajlauncher.simulation.flyable;

import com.live.hstander.avajlauncher.weather.*;

public interface Flyable
{
	public void updateConditions();
	public void registerTower(WeatherTower WeatherTower);
}