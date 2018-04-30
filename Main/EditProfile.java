package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class EditProfile {

	public static boolean editprofile(String SSN, int age, int dars, int dare, int dgr, String gender, String hobbies, int height, int weight, String hair) {
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
			SQLAccessor sqlA = new SQLAccessor();
			sqlA.updateCustomer(SSN, age, dars, dare, dgr, gender, hobbies, height, weight, hair);
			st = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return st;
	}
}