package beans;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfileBean implements Serializable{
	private String profileid;
	private String ownerSSN;
	private int age;
	private int DatingAgeRangeStart;
	private int DatingAgeRangeEnd;
	private int DatingGeoRange;
	private String M_f;
	private String Hobbies;
	private int Height; //In cm
	private int Weight;
	private String haircolor;
	
	public ProfileBean() {
		//Default values
		profileid = "";
		ownerSSN = "";
		age=0;
		DatingAgeRangeStart = 0;
		DatingAgeRangeEnd = 0;
		DatingGeoRange = 0;
		M_f = "";
		Hobbies = "";
		Height=0;
		haircolor = "";
		Weight=0;
	}
	
	public String getProfileid() {
		return profileid;
	}
	public void setProfileid(String prof) {
		profileid = prof;
	}
	public String getOwnerSSN() {
		return ownerSSN;
	}
	public void setOwnerSSN(String ownerSSN) {
		this.ownerSSN = ownerSSN;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getDatingAgeRangeStart() {
		return DatingAgeRangeStart;
	}
	public void setDatingAgeRangeStart(int datingAgeRangeStart) {
		DatingAgeRangeStart = datingAgeRangeStart;
	}
	public int getDatingAgeRangeEnd() {
		return DatingAgeRangeEnd;
	}
	public void setDatingAgeRangeEnd(int datingAgeRangeEnd) {
		DatingAgeRangeEnd = datingAgeRangeEnd;
	}
	public int getDatingGeoRange() {
		return DatingGeoRange;
	}
	public void setDatingGeoRange(int datingGeoRange) {
		DatingGeoRange = datingGeoRange;
	}
	public String getM_f() {
		return M_f;
	}
	public void setM_f(String m_F) {
		M_f = m_F;
	}
	public String getHobbies() {
		return Hobbies;
	}
	public void setHobbies(String hobbies) {
		Hobbies = hobbies;
	}
	public int getHeight() {
		return Height;
	}
	public void setHeight(int height) {
		Height = height;
	}
	public int getWeight() {
		return Weight;
	}
	public void setWeight(int weight) {
		Weight = weight;
	}
	public String getHaircolor() {
		return haircolor;
	}
	public void setHairColor(String haircolor) {
		this.haircolor = haircolor;
	}

	/**
	 * Take a database ResultSet and place all the information into the profilebean
	 * @param bean
	 * @param set
	 */
	public static void insertInBean(ProfileBean profile, ResultSet resultSet) throws SQLException{
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
        profile.setHairColor(resultSet.getString("HairColor"));
	}
}
