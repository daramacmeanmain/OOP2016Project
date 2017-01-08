package ie.gmit.sw.client;

import java.io.*;
import java.net.*;

public class Connection {
	public Connection(){
		new Thread(new Runnable(){
			public void run() { 
				try {
					Socket s = new Socket("localhost", 7777);
					
					System.out.println("Connected to server");
					
					s.close();
					
				} catch (Exception e) { 
					System.out.println("Error: " + e.getMessage());
				}
			}
			
		}, "Client-").start();
			
		}
	
	public class DownloadFiles implements Runnable{
		final String request = "GET /hello.txt HTTP/1.1\n\n";
		public void run(){
			
			try{
				Socket s = new Socket("localhost", 7777);
				
				ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
				out.writeObject(request); //Serialise
				out.flush(); 
				
				s.close(); 
			} catch (Exception e) { //Deal with the error here. A try/catch stops a programme crashing on error  
				System.out.println("Error: " + e.getMessage());
			}
			
			
			
		}
	}

}
