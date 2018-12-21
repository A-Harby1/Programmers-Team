
public class User_Account {
	public User_Account(String Username) {
		Posts ob = new Posts();
		User_Account_gui uag = new User_Account_gui(ob,Username);
	}
}
