import java.sql.DriverManager;
import java.util.*;
public class User_Account {
	public User_Account(String Username) {
		Scanner input = new Scanner(System.in);
		Scanner input1 = new Scanner(System.in);
		Posts ob = new Posts();
		Posts ob2 = new Posts();
		Posts_Database pd = new Posts_Database();
		Posts_Database pd2 = new Posts_Database();
		String post="",date="",search="";
		int choice=0,searchchoice=0;
		while(true) {
			System.out.println("\n======== View Posts ========");
			pd.get_posts();
			System.out.println(pd.posts);
			pd.posts="";
			System.out.println("============================\n");
			System.out.println("1-Write Post");
			System.out.println("2-Search Post");
			System.out.println("3-Sign Out");
			choice=input1.nextInt();
			if(choice==1) {
				System.out.println("======== Write Posts ========");
				System.out.println("Please Enter your post Description : ");
				post=input.nextLine();
				System.out.println("Please Enter your post Date: ");
				date=input.nextLine();
				ob.set_post(post);
				ob.set_postDate(date);
				ob.set_userName(Username);
				pd.save_post(ob.get_post(), ob.get_userName(), ob.get_postDate());
			}else if(choice==2) {
				System.out.println("======== Search ========");
				System.out.println("Enter a Way to Search: ");
				System.out.println("1-Username");
				System.out.println("2-Post ID");
				System.out.println("3-Date");
				searchchoice=input1.nextInt();
				if(searchchoice==1)
				{
					System.out.print("Enter Username please: ");
					search=input.nextLine();
					ob2.set_userName(search);
					pd.x="Not all";
					pd.y="1";
					pd.search=search;
					pd.get_posts();
					System.out.println(pd.posts);
					pd.posts="";
				}
				else if(searchchoice==2)
				{
					System.out.print("Enter Post ID please: ");
					search=input.nextLine();
					ob2.set_post(search);
					pd.x="Not all";
					pd.y="2";
					pd.search=search;
					pd.get_posts();
					System.out.println(pd.posts);
					pd.posts="";
				}
				else if(searchchoice==3)
				{
					System.out.print("Enter Date of Post please: ");
					search=input.nextLine();
					ob2.set_postDate(search);
					pd.x="Not all";
					pd.y="3";
					pd.search=search;
					pd.get_posts();
					System.out.println(pd.posts);
					pd.posts="";
				}
				else {
					System.out.println("Please choose correct number again.");
				}
			}else if(choice==3) {
				break;
			}else {
				System.out.println("Please choose correct number again.");
			}
		}
	}
}
