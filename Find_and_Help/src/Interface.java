import java.util.*;
public class Interface {
		private int choice_num=0;
		private Scanner input=new Scanner(System.in);
		boolean status;
		user ob=new user();
		accounts_database ob2=new accounts_database();
		public Interface()
		{
		System.out.println("1-To Sign up");
		System.out.println("2-To sign in");
		System.out.println("3-To exit from system");
		System.out.print("Enter your choice : ");
		choice_num=input.nextInt();
		
		if (choice_num==1)
		{
				sign_up();
		}
		else if(choice_num==2)
		{
		
		}
		else 
			System.out.println("-------Your choice is invalid ,please try again------");
	}
		public void sign_up()
		{
			System.out.println("------------Sign Up Operation---------------");
			ob.set_name();
			ob.set_userName();
			ob.set_password();
			ob.set_gender();
			ob.set_phoneNum();
			status=ob2.get_account(ob.get_userName());
			while(status)
			{
				System.out.println("-------Username is taken before,please retry again----");
				ob.set_userName();
				status=ob2.get_account(ob.get_userName());
			}
			ob2.save_account(ob.get_name(), ob.get_userName(),ob.get_password(), ob.get_gender(),ob.get_phoneNum());
			User_Account ua = new User_Account(ob.get_userName());
		}
		public void sign_in()
		{
			User_Account ua = new User_Account(ob.get_userName());
		}
		
}	
