package ie.gmit.sw.server;

import java.io.*;
import java.net.*;

public class Server {
	
	private ServerSocket ss;
	private static final int SERVER_PORT = 7777;
	private volatile boolean keepRunning = true;
	
	public Server(){
		try{
			
			//Start the server
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
	
	//List the files available on the server
	public class ListFiles implements Runnable{
		public void run(){
			File f = new File("C:/Users/Dara/workspace/OOP2016Project/myFiles");
			File[] fNames;
			
			try{
				
				fNames = f.listFiles();
				
				for(File fName:fNames){
					System.out.println(fName);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public class Request implements Runnable{
		private Socket sock;
		
		public Request(Socket request) {
			this.sock = request;
		}
		
		public void run() {
			try{
				
				/*ObjectInputStream in = new ObjectInputStream(sock.getInputStream());
                Object command = in.readObject();
                System.out.println(command);
                
                ObjectOutputStream out = new ObjectOutputStream(sock.getOutputStream());
                out.writeObject("C:/Users/Dara/workspace/OOP2016Project/myFiles/hello.txt");
                out.flush();
                out.close();*/
				System.out.println();
                
			}catch (Exception e) {
            	System.out.println("Error processing request from " + sock.getRemoteSocketAddress());
            	e.printStackTrace();
            }
		}
		
	}
}
	
