package Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class NewRegister {

	public static boolean register(String SSN, String profileID, String email, String pass1, String pass2, String fname, String lname, String street, String city, String state, String zip, String phone) {
		boolean st = false;
		if(pass1.compareTo(pass2)!=0) {
			return false;
		}
		try {
			SQLAccessor sqlA = new SQLAccessor();
			sqlA.addCustomer(SSN, email, profileID, pass1, fname, lname, street, city, state, zip, phone);
			System.out.println("Reached this point");
			UserDat.ps1.updateProfileWithID(profileID);
			st = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return st;
	}
}
