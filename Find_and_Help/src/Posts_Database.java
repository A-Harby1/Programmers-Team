import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Posts_Database {
	 private Connection connect;
     private PreparedStatement command;
     private  ResultSet rs;
     public String posts="";
		public boolean get_posts()
		{
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				connect=DriverManager.getConnection("jdbc:ucanaccess://accounts_database.accdb");
				command=connect.prepareStatement("select * from posts_database");
				rs=command.executeQuery();
				while(rs.next())
				{
					posts += "Post with ID : " + rs.getString("post_id") + "\n" + "Post Description :  " +
		        	rs.getString("description") + "\n" + "Post with Username : " + rs.getString("username") + "\n" + 
		        	"Post with Date : " + rs.getString("post_date") + "\n" +
		        	"\n========================================\n\n" ;
				}
				return true;
				}
			catch(Exception e) {System.out.println("----------file not found----------");}
			return false;
		}
		public void save_post(String post,String Username,String date)
		{
			try {
				
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				connect=DriverManager.getConnection("jdbc:ucanaccess://accounts_database.accdb");
				command=connect.prepareStatement("insert into posts_database (description,username,post_date) values ('"+post+"','"+Username+"','"+date+"')");
				command.execute();
				System.out.println("----------Post Saved successfully---------");
			}
			catch(Exception e) {
				System.out.println("----------file not found----------");
			}
			
		}
		public void delete_post()
		{}
		public void update_post()
		{}
}
