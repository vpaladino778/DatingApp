package Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NewRegister {

	public static boolean register(String SSN, String email, String pass1, String pass2) {
		boolean st = false;
		if(pass1.compareTo(pass2)!=0) {
			return st;
		}
		try {
			Connection con=DriverManager.getConnection
					("jdbc:mysql:/ /mysql-305project.cwetgjbvvo5t.us-west-2.rds.amazonaws.com:3306","root","password");
			PreparedStatement ps = con.prepareStatement("SELECT SSN FROM User");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getString("SSN").compareTo(SSN)==0) {
					return false;
				}
			}
			PreparedStatement ps2 = con.prepareStatement("INSERT INTO Person(SSN, Password, Email) VALUES (?,?,?)");
			ps2.setString(1, SSN);
			ps2.setString(2, pass1);
			ps2.setString(3, email);
			ps.executeQuery();

			PreparedStatement ps3 = con.prepareStatement("INSERT INTO User(SSN) VALUES (?)");
			ps3.setString(1, SSN);
			ps.executeQuery();

			PreparedStatement ps4 = con.prepareStatement("INSERT INTO Profile(SSN) VALUES (?)");
			ps4.setString(1, SSN);
			ps.executeQuery();
			st = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return st;
	}
}
