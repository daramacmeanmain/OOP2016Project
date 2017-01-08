package ie.gmit.sw.logger;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import ie.gmit.sw.client.config.Parsetor;

public class Logger {
	
	//Constructor
	public Logger(){
		new Thread(new Runnable(){
			public void run() { 
				try{
					
					//Add date format
					DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					Date date = new Date();
					
					//Log connection to log.txt
				    PrintWriter writer = new PrintWriter("C:/Users/Dara/workspace/OOP2016Project/myFiles/log.txt");
				    writer.println("[INFO] Connection made by " + Parsetor.host + " at " + sdf.format(date));
				    writer.close();
				} catch (IOException e) {
					
				}
			}
		}, "Log-").start();
		
	}

}
