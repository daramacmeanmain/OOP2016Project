package ie.gmit.sw.client;

public class Runner{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserInterface ui = new UserInterface();

		System.out.println(ui);
		
		while(ui.select != 4){
			ui.prompt();
		}
		

	}

}
