package com.live.hstander.avajlauncher.simulation;

import java.io.*;

public class MyWriter
{
	private static PrintWriter writer;
	public static MyWriter myWriter;

	private MyWriter()
	{
		try
		{
			File file = new File("simulation.txt");
			if (file.exists() == false)
				file.createNewFile();
			writer = new PrintWriter(file) ;
		}
		catch(IOException e)
		{
			
		}
	}

	public static MyWriter getWriter()
	{
		if (myWriter == null)
			myWriter = new MyWriter();
		return(myWriter);
	}

	public void write(String str)
	{
		writer.println(str);
	}

	public void close()
	{
		writer.close();
	}
}