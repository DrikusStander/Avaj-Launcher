package com.live.hstander.avajlauncher.simulation.flyable;

public class Coordinates
{
	private int longitude;
	private int latitude;
	private int height;

	Coordinates(int longitude, int latitude,int height)
	{
		if (latitude <= 0 || longitude <= 0 || height <= 0)
		{
			/*
				Throw Exception
			*/
			System.out.println("Invalid argument negative number");
			System.exit(-1);
		}
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