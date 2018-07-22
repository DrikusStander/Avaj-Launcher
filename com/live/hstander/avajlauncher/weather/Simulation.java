
package com.live.hstander.avajlauncher.weather;

import java.io.*;
import com.live.hstander.avajlauncher.simulation.flyable.*;
// import com.live.hstander.avajlauncher.weather.*;

import java.util.*;
import com.live.hstander.avajlauncher.simulation.*;


public class Simulation
{
	public static void main(String[] arg)
	{
		MyWriter log = MyWriter.getWriter();
		// log.write("it works");
		if (arg.length <= 0)
		{
			/*
				Throw exception here
			*/
			System.exit(-1);
		}
		try
		{
			BufferedReader reader = null;
			File file = new File(arg[0]);
			reader = new BufferedReader(new FileReader(file));
			AircraftFactory factory = new AircraftFactory();
			// List<Flyable> aircrafts = new ArrayList<Flyable>();
			WeatherTower tower = new WeatherTower();
			

			String line;
			String[] words;
			int i = 0;
			int count = 0;
			line = reader.readLine();
			
			if (line.isEmpty() == true)
			{
				/*
					throw an exception
				*/
				System.exit(-1);
			}
			try
			{
				count = Integer.parseInt(line.trim());
				if (count < 0)
				{
				/*
					check value of count if it is < 0 throw exception
				*/
					System.out.println("Invalid argument negative number");
					System.exit(-1);
				}
			}
			catch(NumberFormatException e)
			{
				System.out.println("exception Thrown:  " + e);
				System.exit(-1);
			}
			while ((line = reader.readLine()) != null)
			{
				words = line.split(" +|\t+");
				if (words.length != 5)
				{
					System.out.println("invalid Number of Arguments: " + line);
					System.exit(-1);
				}

				tower.registering(factory.newAircraft(words[0], words[1], Integer.parseInt(words[2]), Integer.parseInt(words[3]), Integer.parseInt(words[4]) ) ) ;
				
				// aircrafts.add(factory.newAircraft(words[0], words[1], Integer.parseInt(words[2]), Integer.parseInt(words[3]), Integer.parseInt(words[4]) ) ) ;
				// for (Flyable aircraft : aircrafts)
				// {
				// 	aircraft.registerTower(tower);
				// 	tower.register(aircraft);
				// }

			}

			while (count > 0)
			{
				// for (Flyable aircraft : aircrafts)
				// {
				// 	System.out.println("**** before weather update ****");
				// 	aircraft.updateConditions();
				// }
				tower.changeWeather();
				count--;
			}
			log.close();
			reader.close();
			System.exit(0);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}