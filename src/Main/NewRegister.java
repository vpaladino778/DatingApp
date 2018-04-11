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
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection
					("jdbc:mysql://mysql-305project.cwetgjbvvo5t.us-west-2.rds.amazonaws.com:3306/DatingDB","root","password");
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
			ps2.executeUpdate();

			PreparedStatement ps3 = con.prepareStatement("INSERT INTO User(SSN) VALUES (?)");
			ps3.setString(1, SSN);
			ps3.executeUpdate();

			PreparedStatement ps4 = con.prepareStatement("INSERT INTO Profile(OwnerSSN, CreationDate, LastModDate) VALUES (?,?,?)");
			Date date = new Date();
			Object param = new java.sql.Timestamp(date.getTime());
			ps4.setString(1, SSN);
			ps4.setObject(2,param);
			ps4.setObject(3, param);
			ps4.executeUpdate();
			st = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return st;
	}
}
