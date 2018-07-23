package com.live.hstander.avajlauncher.simulation.flyable;

import com.live.hstander.avajlauncher.weather.*;
import com.live.hstander.avajlauncher.simulation.*;

public interface Flyable
{
	public void updateConditions() throws MyException;
	public void registerTower(WeatherTower WeatherTower);
}