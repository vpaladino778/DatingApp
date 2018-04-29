package Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


import beans.ProfileBean;
/**
 * 
 * @author Vincent Paladino
 * The purpose of this class is to retrieve the entries from the
 * Profile table and place them into a list of JavaBeans. 
 */
public class ProfileDAO {
	
	private SQLAccessor accessor;
	
	public ProfileDAO() {
		accessor = new SQLAccessor();
	}
	
	/**
	 * 
	 * @return List of ProfileBean objects that contain information from Profile table
	 * @throws SQLException
	 */
	public List<ProfileBean> list() throws SQLException{
		List<ProfileBean> profiles = new ArrayList<ProfileBean>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
		try (
				Connection connection = DriverManager.getConnection
				("jdbc:mysql://mysql-305project.cwetgjbvvo5t.us-west-2.rds.amazonaws.com:3306/DatingDB","root","password");
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM Profile");
				ResultSet resultSet = statement.executeQuery();
		){
            while (resultSet.next()) {
                ProfileBean profile = new ProfileBean();
                profile.setProfileid(resultSet.getString("ProfileID"));
                profile.setOwnerSSN(resultSet.getString("OwnerSSN"));
                profile.setAge(resultSet.getInt("Age"));
                profile.setDatingAgeRangeStart(resultSet.getInt("DatingAgeRangeStart"));
                profile.setDatingAgeRangeEnd(resultSet.getInt("DatingAgeRangeEnd"));
                profile.setDatingGeoRange(resultSet.getInt("DatingGeoRange"));
                profile.setM_f(resultSet.getString("M_F"));
                profile.setHobbies(resultSet.getString("Hobbies"));
                profile.setHeight(resultSet.getInt("Height"));
                profile.setWeight(resultSet.getInt("Weight"));
                profile.setHairColor(resultSet.getString("ProfileID"));
                profiles.add(profile);
            }
        }
		return profiles;
	}

}
