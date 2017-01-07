package ie.gmit.sw.server;

import java.io.*;
import java.net.*;

public class Server {
	
	private ServerSocket ss;
	private static final int SERVER_PORT = 7777;
	private volatile boolean keepRunning = true;
	
	public Server(){
		try{
			ss = new ServerSocket(SERVER_PORT);
			
			Thread server = new Thread(new Listener(), "Web Server Listener");
			server.setPriority(Thread.MAX_PRIORITY);
			server.start();
			
			System.out.println("Server started and listening on port " + SERVER_PORT);
			
		}catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
	
	public class Listener implements Runnable{
		public void run() {
			while (keepRunning){
				try {
					Socket s = ss.accept();
					new Thread(new Request(s), "T-").start();
				}catch (IOException e) {
					System.out.println("Error handling incoming request..." + e.getMessage());
				}
			}
		}
	}
	
	private class Request implements Runnable{
		private Socket sock;
		
		private Request(Socket request) {
			this.sock = request;
		}
		
		public void run() {
			try{
				System.out.println("Success");
			}catch (Exception e) {
            	System.out.println("Error processing request from " + sock.getRemoteSocketAddress());
            	e.printStackTrace();
            }
		}
		
	}
}
	
