import java.sql.*;

public class Posts_Database {
	 private Connection connect;
     private PreparedStatement command;
     private  ResultSet rs;
     public String posts="",x="all",search="",y="";
		public boolean get_posts()
		{	
			if(x=="all")
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
			else if (x=="Not all") {
				try {
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
					connect=DriverManager.getConnection("jdbc:ucanaccess://accounts_database.accdb");
					String statement1 ="select * from posts_database  where username = '"+search+"' ";
					String statement2 ="select * from posts_database  where post_id = '"+search+"' ";
					String statement3 ="select * from posts_database  where post_date = '"+search+"' ";
					if(y=="1")
					{
						command=connect.prepareStatement(statement1);
					}
					else if (y=="2")
					{
						command=connect.prepareStatement(statement2);
					}
					else if (y=="3")
					{
						command=connect.prepareStatement(statement3);
					}
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
				catch(Exception e) {System.out.println("---22-------file not found------22----");}
			}
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
