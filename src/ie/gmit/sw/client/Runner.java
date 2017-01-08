package ie.gmit.sw.client;

import ie.gmit.sw.client.config.*;
import ie.gmit.sw.logger.Logger;
import ie.gmit.sw.server.Server;

public class Runner{
	
	//Initialize the server
	static Server sv = new Server();
	
	public static void main(String[] args) throws Throwable {
		UserInterface ui = new UserInterface();//Initialize UI
		Parsetor prs = new Parsetor();
		XMLParser xml = new XMLParser(prs);
		xml.run();//Parse XML doc
		
		//Output UI
		System.out.println(ui);
		
		//Select options
		while(ui.select != 4){
			
			ui.prompt();
			
			//Connect to server - log connection
			if(ui.select == 1){
				Connection con = new Connection();
				Logger log = new Logger();
				System.out.println(prs);
			}
			
			//List files
			else if(ui.select == 2){
				System.out.println("Files Available");
				Server.ListFiles lf = sv.new ListFiles();
				lf.run();
				
			}
			
			//Download files
			else if(ui.select == 3){
				System.out.println("Unavailable");
			}
		}
		

	}

}
