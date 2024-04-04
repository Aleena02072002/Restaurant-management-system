//this MenuList takes input from the TableModel which implements differently compared to normal
// input from JTextField

package Menu;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.table.DefaultTableModel;

public class MenuList {
	private Menu menulist[];
	private int length;
	
	static Scanner sc = new Scanner(System.in);
	
	MenuList()
	{
	}
	
	MenuList(Menu[] menulist, int length)
	{
		this.menulist=menulist;
		this.length=length;
	}
	
	Menu[] getMenuList(){
		return this.menulist;
	}
	
	int getMenuListLength()
	{
		return this.length;
	}
	
	void setMenuList()
	{
		System.out.println("Enter number of menu Item: ");
		int n;
		try
		{
		n = sc.nextInt();
		} catch(Exception e)
		{
			System.out.println("Input was not an integer number, defaulting to one item addition!");
			n=1;
		}
		Menu tempmenu[] = new Menu[n];
		for(int i=0; i<n; i++)
		{
		tempmenu[i] = new Menu();
		}
		this.length=n;
		this.menulist=tempmenu;
	}
	
	Object[][]	getRowmenu(){
		Object[][] data = new Object [this.length][3];
		for(int i=0; i<this.length; i++)
		{
			for(int j=0; j<3; j++)
			{
				switch(j)
				{
				case 0:
					data[i][j]=this.menulist[i].getitemType();
					break;
				case 1:
					data[i][j]=this.menulist[i].getitemName();
					break;
				case 2:
					data[i][j]=this.menulist[i].getitemPrice();
					break;
				}
			}
		}
		return data;
	}
	void showDetail()
	{
		System.out.println("Enter the position you wanna see: ");
		int pos = sc.nextInt();
		this.menulist[pos].seeDetail();
	}
	
	static void showArray(int array[])
	{
		for(int i=0; i<array.length; i++)
		{
			System.out.println(array[i]);
		}
	}
	
	static void showArray(String array[])
	{
		for(int i=0; i<array.length; i++)
		{
			System.out.println(" "+array[i]);
		}
	}
	
	void sortPrice()
	{
		SortAlgorithm sa;
		BubbleSort bs = new BubbleSort();
		InsertSort is = new InsertSort();
		
		int price[] = new int[this.menulist.length];
		
		for(int i=0; i<this.menulist.length; i++)
		{
			price[i] = this.menulist[i].getitemPrice();
		}
		
		String name[] = new String[this.menulist.length];
		
		for(int i=0; i<this.menulist.length; i++)
		{
			name[i] = this.menulist[i].getitemName();
		}
		
		System.out.println("1. Ascending sort\n2. Descending sort");
		int decide = sc.nextInt();
		
		if(decide==1)
		{
			sa = bs;
			sa.sort(price);
			System.out.println("Price: ");
			showArray(price);
			System.out.println("Name of food: ");
			showArray(name);
		}else if(decide==2)
		{
			sa = is;
			sa.sort(price);
			System.out.println("Price: ");
			showArray(price);
			System.out.println("Name of food: ");
			showArray(name);
		}
		
	}
	
	static void saveData(DefaultTableModel tableModel)
	{
		try {
			FileWriter myWriter = new FileWriter("Save.txt");
			FileWriter myWriter1 = new FileWriter("Data.txt");
		for(int i=0; i<tableModel.getRowCount(); i++)
		{
			for(int j=0; j<3; j++)
			{
				switch(j)
				{
				case 0:
					String s = (String) tableModel.getValueAt(i, 0);
					myWriter.write(s+"\t");
					myWriter1.write(s+"\n");
					break;
				case 1:
					String s1 = (String) tableModel.getValueAt(i, 1);
					myWriter.write(s1+"\t");
					myWriter1.write(s1+"\n");
					break;
				case 2:
					int n = (int) tableModel.getValueAt(i, 2);
					myWriter.write(n+"\n");
					myWriter1.write(n+"\n");
					break;
				}
			}
		}
		myWriter.close();
		myWriter1.close();
		System.out.println("Successfully wrote to the file.");
		}catch(IOException e)
		{
			System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
	
	Object [][] readUsingFiles() throws IOException {
		File file=new File("Data.txt");    //creates a new file instance  
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
		System.out.println("Contents of File: ");  
		String []tokens = sb.toString().split("\n");
		Object [][] ob = new Object[tokens.length/3][3];
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
	
	public static void main(String args[])
    {	
		MenuList m1 = new MenuList();
    	try {
			m1.readUsingFiles();
		} catch (IOException e) {
			System.out.println("Error");
		}
    	sc.close();
    }
}
