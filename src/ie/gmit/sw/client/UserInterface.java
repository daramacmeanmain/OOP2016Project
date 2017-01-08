package ie.gmit.sw.client;

import java.util.Scanner;

public class UserInterface {
	
	Scanner console = new Scanner(System.in);
	
	public int select = 0;
	
	//UI Constructor
	public UserInterface(){
		super();
	}
	
	//Get and Set
	public int getSelect() {
		return select;
	}

	public void setSelect(int select) {
		this.select = select;
	}
	
	//Output method
	@Override
	public String toString() {
		return "1. Connect to Server\n2. Print File Listing\n3. Download File\n4. Quit\n\nType Option[1-4]";
	}
	
	//Input selection
	public int prompt(){
		select = console.nextInt();
		return select;
	}

}
