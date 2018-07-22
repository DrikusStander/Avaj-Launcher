
package com.live.hstander.avajlauncher.simulation;

import java.io.*;

public class Simulation
{
	public static void main(String[] arg)
	{
		try
		{
			System.out.println("main");
			BufferedReader reader = null;
			File file = new File(arg[0]);
			reader = new BufferedReader(new FileReader(file));

			String line;
			String[] words;
			int i = 0;
			line = reader.readLine();
			int count = Integer.parseInt(line.trim());
			// int count = Integer.parseInt("123aa");
			System.out.println(count);
			while ((line = reader.readLine()) != null)
			{
				System.out.println(line);
				words = line.split(" ");
				for (String word : words)
				{
					System.out.println(word);
				}
			}
			reader.close();
			System.exit(0);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}