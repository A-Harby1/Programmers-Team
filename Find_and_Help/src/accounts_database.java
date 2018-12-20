import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class accounts_database {
	 private Connection connect;
     private PreparedStatement command;
     private  ResultSet rs;
     
		public boolean get_account(String userName)
		{
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				connect=DriverManager.getConnection("jdbc:ucanaccess://accounts_database.accdb"); 
				command=connect.prepareStatement("select username from userdata where username='"+userName+"'");
				rs=command.executeQuery();
				while(rs.next())
				{
					return true;
				}
				}
			catch(Exception e) {System.out.println("----------file not found----------");}
			return false;
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
