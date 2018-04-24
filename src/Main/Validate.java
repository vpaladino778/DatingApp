package Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Validate {
	public static boolean checkUser(String email,String pass) 
	{
		boolean st = false;
		
		try{
			//loading drivers for mysql
			Class.forName("com.mysql.jdbc.Driver");

					//creating connection with the database 
					Connection con=DriverManager.getConnection
							("jdbc:mysql://mysql-305project.cwetgjbvvo5t.us-west-2.rds.amazonaws.com:3306/DatingDB","root","password");
					PreparedStatement ps =con.prepareStatement
							("select * from Person where Email=? and Password=?");
					ps.setString(1, email);
					ps.setString(2, pass);
					ResultSet rs =ps.executeQuery();
					st = rs.next();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return st;

	}

	public static String findSSN(String email, String pass) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection
					("jdbc:mysql://mysql-305project.cwetgjbvvo5t.us-west-2.rds.amazonaws.com:3306/DatingDB","root","password");
			PreparedStatement ps =con.prepareStatement
					("select SSN from Person where Email=? and Password=?");
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs =ps.executeQuery();
			String SSN = rs.getString(0);
			return SSN;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}  
}
