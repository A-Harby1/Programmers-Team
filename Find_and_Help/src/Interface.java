import java.util.*;
public class Interface {
		private int choice_num=0;
		private Scanner input=new Scanner(System.in);
		boolean status=false;
		user ob=new user();
		accounts_database ob2=new accounts_database();
		public Interface()
		{
				while(true)
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
						sign_in();
					}
					else if(choice_num==3)
						break;
					else 
						System.out.println("-------Your choice is invalid ,please try again------");
				}
		}
		public void sign_up()
		{
			System.out.println("------------Sign Up Operation---------------");
			ob2.get_account();
			ob.set_name();
			ob.set_userName();
			ob.set_password();
			ob.set_gender();
			ob.set_phoneNum();
			if(ob2.username.contains(ob.get_userName()))
				status=true;
			else 
				status=false;
			while(status)
			{
				System.out.println("-------Username is taken before,please retry again----");
				ob.set_userName();
				if(ob2.username.contains(ob.get_userName()))
					status=true;
				else 
					status=false;
			}
			ob2.username.clear();
			ob2.password.clear();
			ob2.save_account(ob.get_name(), ob.get_userName(),ob.get_password(), ob.get_gender(),ob.get_phoneNum());
			
		}
		public void sign_in()
		{
			ob2.get_account();
			ob.set_userName();
			ob.set_password();
			if(ob2.username.contains(ob.get_userName()))
			{
				if(ob.get_password().equals(ob2.password.get( ob2.username.indexOf(ob.get_userName()) )))
					status=false;
				else 
					status=true;
			}
			else 
				status=true;
			while(status)
			{
				System.out.println("-------Username Or Password is invalid,please try again-------");
				ob.set_userName();
				ob.set_password();
				if(ob2.username.contains(ob.get_userName()))
				{
					if(ob.get_password().equals(ob2.password.get( ob2.username.indexOf(ob.get_userName()) )))
							status=false;
					else 
						status=true;
				}
				else 
					status=true;
				}
			
				System.out.println("--------successfully signed in----------------");
				ob2.username.clear();
				ob2.password.clear();
			}
}	
	
