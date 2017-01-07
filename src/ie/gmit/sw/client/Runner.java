package ie.gmit.sw.client;

import ie.gmit.sw.server.Server;

public class Runner{

	//@SuppressWarnings("static-access")
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		UserInterface ui = new UserInterface();
		//Server.Listener ls = sv.new Listener();
		//Connection con = new Connection();
		//WebServer.HTTPRequest ht = ws.new HTTPRequest(null);
		

		System.out.println(ui);
		
		while(ui.select != 4){
			ui.prompt();
			
			if(ui.select == 1){
				Server sv = new Server();
				Connection con = new Connection();
				//sv.run();
				//con.run();
				//ht.run();
			}
			
			else{
				
			}
		}
		

	}

}
