package User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Employee extends NewUser{
	private String name;
	private String username;
	private String password;
	
	static Scanner sc = new Scanner(System.in);
	
	Employee(String name, String username, String password){
		this.name = name;
		this.username = username;
		this.password = password;
	}
	Employee(){}
	@Override
	protected String getName() {
		return this.name;
	}
	@Override
	protected String getUserName() {
		return this.username;
	}
	@Override
	protected String getPassword() {
		return this.password;
	}
	
	static String setName()
    {
    	String name1;
    	
    	System.out.print("Enter name: ");
    	name1=sc.next();
    	
    	return name1;
    }
	
	static String setUsername()
	{
		String username1;
		
		System.out.print("Enter username: ");
		username1=sc.next();
		
		return username1;
	}
	
	static String setPassword()
	{
		String password1;
		
		System.out.print("Enter password: ");
		password1=sc.next();
		
		return password1;
	}
	
	void seeDetail()
	{
		System.out.println("Name: "+this.name);
		System.out.println("Username: "+this.username);
		System.out.println("Password: "+this.password);
	}
	
	//write to File
	static void saveEmployeeInfo(String newName, String newUsername, String newPassword){
		try {
			PrintWriter fileWriter = new PrintWriter(new BufferedWriter(new FileWriter("Employees.txt", true)));
			fileWriter.append(newName + "\n");
			fileWriter.append(newUsername + "\n");
			fileWriter.append(newPassword + "\n");
			fileWriter.flush();
			fileWriter.close();
			System.out.println("Employee SIGN UP SUCCESSFULLY to the system!");
		}
		catch(IOException e)
		{
			System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
	public static String [][] readEmployeeFiles() throws IOException {
		File file=new File("Employees.txt");    //creates a new file instance  
		FileReader fr=new FileReader(file);   //reads the file  
		BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
		StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters  
		String line;
		
		while((line=br.readLine())!=null)  
		{  
		sb.append(line);      //appends line to string buffer  
		sb.append("\n");     //line feed   
		}  
		fr.close();    //closes the stream and release the resources  
		System.out.println("Employee Info: ");  
		String []tokens = sb.toString().split("\n");
		String [][] ob = new String[tokens.length/3][3];
	    for(int i = 0; i < tokens.length; i++)
	    {
	       System.out.println(tokens[i]);
	    }
	    
	    for(int i=0; i<tokens.length/3;i++)
	    {
	    	   for(int j=0;j<3;j++)
	    		   ob[i][j] = (tokens[(i*3) + j]);
	    }
		return ob;
    }
	static boolean compareUsers(String [][] users, String newUsername, String newUserPassword) {
		boolean result = false;
		for(int i = 0; i<users.length; i++) {
			if(users[i][1].equals(newUsername) && users[i][2].equals(newUserPassword)) {
				result = true;
				System.out.println("Access Granted!");
				break;
			}else {
				result = false;
				System.out.println("Access Denied!");
			}
		}
		return result;
	}
	static String setSignInName(String [][] users, String newUsername, String newUserPassword) {
		String newUser = null;
		for(int i = 0; i<users.length; i++) {
			if(users[i][1].equals(newUsername) && users[i][2].equals(newUserPassword)) {
				newUser = users[i][0];
				System.out.println("Username Correct!");
				break;
			}else {
				newUser = null;
				System.out.println("Username Incorrect!");
			}
		}
		return newUser;
	}
	@SuppressWarnings("unused")
	public static void main(String args[]) throws IOException {
		String[][] employee = Employee.readEmployeeFiles();
		compareUsers(employee, "leduy123", "123456");	
		String s = setSignInName(employee, "leduy123", "123456");
		System.out.println("Hello " + s);
		//testing purpose
		String display = null;
		saveDisplay("vinhkhang");
		display = readDisplay();
		sc.close();
	}
}

