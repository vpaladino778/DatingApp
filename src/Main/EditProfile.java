package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class EditProfile {

	public static boolean editprofile(String SSN, String profileID, int age, int dars, int dare, int dgr, String gender, String hobbies, int height, int weight, String hair) {
		boolean st = false;
		if(age<18) {
			return false;
		}
		if(dars<18) {
			return false;
		}
		if(dare>99) {
			return false;
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection
					("jdbc:mysql://mysql-305project.cwetgjbvvo5t.us-west-2.rds.amazonaws.com:3306/DatingDB","root","password");
			if(profileID!=null) {
				PreparedStatement ps = con.prepareStatement("SELECT ProfileID FROM Profile");
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					if(rs.getString("ProfileID").compareTo(profileID)==0) {
						return false;
					}
				}
			}
			PreparedStatement ps4 = con.prepareStatement("UPDATE Profile SET ProfileID = ?, Age = ?, DatingAgeRangeStart = ?, DatingAgeRangeEnd = ?, DatingGeoRange = ?, M_F = ?, Hobbies = ?, Height = ?, Weight = ?, HairColor = ?, LastModDate = ? WHERE OwnerSSN = ?");
			Date date = new Date();
			Object param = new java.sql.Timestamp(date.getTime());
			ps4.setString(1, profileID);
			ps4.setString(6, gender);
			ps4.setString(9, hobbies);
			ps4.setString(10, hair);
			ps4.setInt(2, age);
			ps4.setInt(3, dars);
			ps4.setInt(4, dare);
			ps4.setInt(5, dgr);
			ps4.setInt(7, height);
			ps4.setInt(8, weight);
			ps4.setObject(11,param);
			ps4.setString(12, SSN);
			ps4.executeUpdate();
			st = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return st;
	}
}