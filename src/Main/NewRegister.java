package Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class NewRegister {

	public static boolean register(String SSN, String email, String pass1, String pass2) {
		boolean st = false;
		if(pass1.compareTo(pass2)!=0) {
			return false;
		}
		try {
			SQLAccessor sqlA = new SQLAccessor();
			sqlA.addCustomer(SSN, email, pass1);
			st = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return st;
	}
}
