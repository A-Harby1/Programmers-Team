import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class accounts_database {
	 private Connection connect;
     private PreparedStatement command;
     private  ResultSet rs;
     ArrayList<String> name=new ArrayList<String>();
     ArrayList<String> username=new ArrayList<String>();
     ArrayList<String> password=new ArrayList<String>();
     ArrayList<String> gender=new ArrayList<String>();
     ArrayList<Integer> ohoneNum=new ArrayList<Integer>();
		public void get_account()
		{
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				connect=DriverManager.getConnection("jdbc:ucanaccess://accounts_database.accdb"); 
				command=connect.prepareStatement("select * from userdata");
				rs=command.executeQuery();
				while(rs.next())
				{
					username.add(rs.getString("username"));
					password.add(rs.getString("password"));
				}
				}
			catch(Exception e) {System.out.println("----------file not found----------");}
		}
		public void save_account(String name,String Username,String Pass,String gender,int num)
		{
			try {
				
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				connect=DriverManager.getConnection("jdbc:ucanaccess://accounts_database.accdb");
				command=connect.prepareStatement("insert into userdata values ('"+name+"','"+Username+"','"+Pass+"','"+gender+"','"+num+"')");
				command.execute();
				System.out.println("----------successfully registered---------");
			}
			catch(Exception e) {
				System.out.println("----------file not found----------");
			}
			
		}
		public void delete_account()
		{
			
		}
		public void update_account()
		{
			
		}
}
