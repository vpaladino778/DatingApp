package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProfileList {

		
		public static ArrayList<String> getProfileList(String email){
			ArrayList<String> profileList = new ArrayList<String>();
			//Query the email address to the SSN and get all of the 
			try{
				//loading drivers for mysql
				Class.forName("com.mysql.jdbc.Driver");

						//creating connection with the database 
						Connection con=DriverManager.getConnection
								("jdbc:mysql://mysql-305project.cwetgjbvvo5t.us-west-2.rds.amazonaws.com:3306/DatingDB","root","password");
						PreparedStatement ps =con.prepareStatement
								("SELECT ProfileID FROM Profile, Person WHERE Person.Email = ? AND Person.SSN = Profile.OwnerSSN");
						ps.setString(1, email);
						ResultSet rs = ps.executeQuery();
						while(rs.next()) {
							profileList.add(rs.getString(1));
						}
						rs.close();
						for(int i = 0;i < profileList.size();i++) {
							System.out.println(profileList.get(i));
						}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return profileList;
			
		}
}
