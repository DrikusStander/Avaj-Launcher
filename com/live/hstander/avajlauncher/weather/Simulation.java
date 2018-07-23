
package com.live.hstander.avajlauncher.weather;

import java.io.*;
import com.live.hstander.avajlauncher.simulation.flyable.*;

import java.util.*;
import com.live.hstander.avajlauncher.simulation.*;


public class Simulation
{
	public static void main(String[] arg)
	{
		MyWriter log = MyWriter.getWriter();
		if (arg.length <= 0)
		{
			System.out.println("Invalid use: [java ~Simulatin <scenario>]");
			System.exit(-1);
		}
		try
		{
			BufferedReader reader = null;
			File file = new File(arg[0]);
			reader = new BufferedReader(new FileReader(file));
			AircraftFactory factory = new AircraftFactory();
			WeatherTower tower = new WeatherTower();
			String line;
			String[] words;
			int count = 0;

			line = reader.readLine();
			if (line.isEmpty() == true)
				System.exit(-1);
			try
			{
				count = Integer.parseInt(line.trim());
				if (count < 0)
				{
					System.out.println("File structure: Invalid argument negative number");
					System.exit(-1);
				}
			}
			catch(NumberFormatException e)
			{
				System.out.println("File Structure:  " + e);
				System.exit(-1);
			}
			while ((line = reader.readLine()) != null)
			{
				words = line.split(" +|\t+");
				if (words.length != 5)
				{
					System.out.println("File Structure: invalid Number of Arguments: " + line);
					System.exit(-1);
				}
				int lon = 0;
				int lat = 0;
				int height = 0;
				try
				{
					lon = Integer.parseInt(words[2]);
					lat = Integer.parseInt(words[3]);
					height = Integer.parseInt(words[4]);
				}
				catch(NumberFormatException e)
				{
					System.out.println("File Structure:  " + e);
					System.exit(-1);
				}
				tower.registering(factory.newAircraft(words[0], words[1], lon, lat, height ) ) ;
			}
			while (count > 0)
			{
				tower.changeWeather();
				count--;
			}
			log.close();
			reader.close();
			System.exit(0);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		catch(MyException e)
		{
			System.out.println(e);
			System.exit(-1);
		}
	}
}