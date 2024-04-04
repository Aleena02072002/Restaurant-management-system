package Menu;
import java.util.Scanner;

public class Menu {
	private String itemType;
    private String itemName;
    private int itemPrice;
    
    static Scanner sc=new Scanner(System.in, "UTF-8");
    
    Menu(String itemType, String itemName, int itemPrice)
    {
    	this.itemType = itemType;
    	this.itemName = itemName;
    	this.itemPrice = itemPrice;
    }
    
    Menu()
    {
    	this.itemType = setitemType();
    	this.itemName = setitemName();
    	this.itemPrice = setitemPrice();
    }
    
    int getitemPrice()
    {
    	return this.itemPrice;
    }
    
    String getitemType()
    {
    	return this.itemType;
    }
    
    String getitemName()
    {
    	return this.itemName;
    }

	static int setitemPrice()
    {	 
    	int temp;
    	System.out.println("Input price: ");
    	try {
    	temp=sc.nextInt();
    	} catch(Exception e)
    	{
    		System.out.println("Input was not an integer number, defaulting to 1!");
    		temp = 1;
    	}
    	return temp;
    }
	static String setitemType()
    {
    	String temp1;
    	
    	System.out.print("Enter the item type: ");
    	temp1=sc.next();
    	
    	return temp1;
    }
	static String setitemName()
    {
    	String temp1;
    	
    	System.out.print("Enter the item name: ");
    	temp1=sc.next();
    	
    	return temp1;
    }
	void seeDetail()
	{
		System.out.println("Item info: "+this.itemType);
		System.out.println("Item name: "+this.itemName);
		System.out.println("item price: "+this.itemPrice);
	}
	
    //Test code
    public static void main(String args[])
    {	
    	int temp = setitemPrice();
    	String itemType = setitemType();
    	String itemName = setitemName();
    	Menu m1 = new Menu(itemType, itemName, temp);
    	
    	m1.seeDetail();
    	sc.close();
    }
}
