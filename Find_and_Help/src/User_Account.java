import java.util.*;
public class User_Account {
	public User_Account(String Username) {
		Scanner input = new Scanner(System.in);
		Scanner input1 = new Scanner(System.in);
		Posts ob = new Posts();
		Posts_Database pd = new Posts_Database();
		String post="",date="";
		int choice=0;
		while(true) {
			System.out.println("\n======== View Posts ========");
			pd.get_posts();
			System.out.println(pd.posts);
			System.out.println("============================\n");
			System.out.println("1-Write Post");
			System.out.println("2-Search Post");
			System.out.println("3-Exit");
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
				//search code
			}else if(choice==3) {
				break;
			}else {
				System.out.println("Please choose correct number again.");
			}
		}
	}
}
