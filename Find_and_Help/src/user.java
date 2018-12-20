import java.util.*;
public class user {
	private String name="";
	private String userName="";
	private String password="";
	private String gender="";
	private int phoneNum=0;
	private Scanner input=new Scanner(System.in); 
	private Scanner input2=new Scanner(System.in); 
	public void set_name()
	{
		System.out.println("Enter name: ");
		name=input.nextLine();	
		
	}
	public void set_userName()
	{
		System.out.print("Enter username: ");
		userName=input.nextLine();
	}
	public void set_password()
	{
		System.out.print("Enter password: ");
		password=input.nextLine();
	
	}
	public void set_gender()
	{
		System.out.print("Enter Gender: ");
		gender=input.nextLine();
	}
	public void set_phoneNum()
	{
		System.out.print("Enter phone number: ");
		phoneNum=input2.nextInt();
	}
	public String get_name()
	{
		return name;
	}
	public String get_userName()
	{
		return userName;
	}
	public String get_password()
	{
		return password;
	}
	public String get_gender()
	{
		return gender;
	}
	public int get_phoneNum()
	{
		return phoneNum;
	}

}
