package com.live.hstander.avajlauncher.simulation.flyable;

import com.live.hstander.avajlauncher.weather.*;

public class Aircraft
{
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	private static long idCounter;

	protected Aircraft(String name, Coordinates coordinates)
	{
		this.name = name;
		this.coordinates = coordinates;
		this.id = nextId();
	}

	private long nextId()
	{
		this.idCounter++;
		return(this.idCounter);
	}

	public long getId()
	{
		return(this.id);
	}
}