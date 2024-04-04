package User;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public abstract class NewUser {
	protected abstract String getName();
	protected abstract String getUserName();
	protected abstract String getPassword();
	
	//save Username to display FullName in Home Page
		public static void saveDisplay(String newName){
			try {
				PrintWriter fileWriter = new PrintWriter(new BufferedWriter(new FileWriter("D:/SignInfo.txt")));
				fileWriter.write(newName + "\n");
				fileWriter.flush();
				fileWriter.close();
				System.out.println("Info Saved!");
			}
			catch(IOException e)
			{
				System.out.println("An error occurred.");
			      e.printStackTrace();
			}
		}
		public static String readDisplay() throws IOException {
		File file=new File("D:/SignInfo.txt");    //creates a new file instance  
		Scanner myReader = new Scanner(file);
		String data = myReader.nextLine();
		System.out.println(data);
		myReader.close();
		return data;
    }
}
