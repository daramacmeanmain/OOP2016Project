package ie.gmit.sw.client;

import ie.gmit.sw.client.config.*;
import ie.gmit.sw.server.Server;

public class Runner{

	//@SuppressWarnings("static-access")
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		UserInterface ui = new UserInterface();
		Parsetor prs = new Parsetor();
		XMLParser xml = new XMLParser(prs);
		Server sv = new Server();
		xml.run();
		//Server.Listener ls = sv.new Listener();
		//Connection con = new Connection();
		//WebServer.HTTPRequest ht = ws.new HTTPRequest(null);
		

		System.out.println(ui);
		
		while(ui.select != 4){
			
			ui.prompt();
			
			if(ui.select == 1){
				//Server sv = new Server();
				Connection con = new Connection();
				System.out.println(prs);
			}
			
			else if(ui.select == 2){
				System.out.println("Files Available");
				Server.ListFiles lf = sv.new ListFiles();
				lf.run();
			}
			
			else if(ui.select == 3){
				
			}
		}
		

	}

}
