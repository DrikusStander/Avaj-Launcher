package com.live.hstander.avajlauncher.simulation.flyable;

import com.live.hstander.avajlauncher.simulation.*;

public class Coordinates
{
	private int longitude;
	private int latitude;
	private int height;

	Coordinates(int longitude, int latitude,int height) throws MyException
	{
		if (latitude < 0 || longitude < 0 || height < 0)
		{
			MyException except = new MyException("File Format: Negative value");
			throw except;
		}
		if (height >= 100 )
			height = 100;
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
	}

	public int getLongitude()
	{
		return(this.longitude);
	}

	public int getLatitude()
	{
		return(this.latitude);
	}

	public int getHeight()
	{
		return(this.height);
	}
}