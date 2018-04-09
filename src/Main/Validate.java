package Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Validate {
    public static boolean checkUser(String email,String pass) 
    {
    	System.out.println(email);
    	if(email.equals("Correct")) {
    		return true;
    	} else {
    		return false;
    	}
     //boolean st =false;
     //try{
	 //loading drivers for mysql
       // Class.forName("com.mysql.jdbc.Driver");

	 //creating connection with the database 
        /*Connection con=DriverManager.getConnection
                       ("jdbc:mysql:/ /localhost:3306/test","root","password");
        PreparedStatement ps =con.prepareStatement
                            ("select * from register where email=? and pass=?");
        ps.setString(1, email);
        ps.setString(2, pass);
        ResultSet rs =ps.executeQuery();
        st = rs.next();*/
       
     //}catch(Exception e)
     //{
       //  e.printStackTrace();
     //}
 }  
}
