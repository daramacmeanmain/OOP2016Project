package ie.gmit.sw.client;

import java.util.Scanner;

public class UserInterface {
	
	Scanner console = new Scanner(System.in);
	
	public int select = 0;
	
	public UserInterface(){
		super();
	}

	public int getSelect() {
		return select;
	}

	public void setSelect(int select) {
		this.select = select;
	}

	@Override
	public String toString() {
		return "1. Connect to Server\n2. Print File Listing\n3. Download File\n4. Quit\n\nType Option[1-4]";
	}
	
	public int prompt(){
		select = console.nextInt();
		return select;
	}

}
