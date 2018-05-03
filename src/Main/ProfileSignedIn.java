package Main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.ProfileBean;

public class ProfileSignedIn {

	private ProfileBean profileBean;
	private SQLAccessor accessor;
	private String SSN;
	private String email;
	private String profileID;
	

	public ProfileSignedIn(String sSN, String email, String profileID) {
		super();
		SSN = sSN;
		this.email = email;
		this.profileID = profileID;
		profileBean = new ProfileBean();
		try {
			updateProfileWithID(profileID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String sSN) {
		SSN = sSN;
		try {
			updateProfileWithSSN(sSN);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfileID() {
		return profileID;
	}

	public void setProfileID(String profileID) {
		this.profileID = profileID;
		try {
			updateProfileWithID(profileID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Pulls information from the Database to update the profile information
	 * @param profileID of the current user to be updated
	 * @throws SQLException 
	 */
	public void updateProfileWithID(String profileID) throws SQLException {
		if(profileID!= null) {
			accessor = new SQLAccessor();
			ResultSet resultSet = accessor.getProfileInfo(profileID);
			resultSet.next();
			ProfileBean.insertInBean(profileBean, resultSet);
		}else {
			profileBean = new ProfileBean();
		}
	}
	
	public void updateProfileWithSSN(String SSN) throws SQLException{
		if(SSN!=null) {
		accessor = new SQLAccessor();
		PreparedStatement ps = accessor.getConnection().prepareStatement("SELECT * FROM Profile WHERE Profile.OwnerSSN = ?");
		ps.setString(1, SSN);
		ResultSet resultSet = ps.executeQuery();
		resultSet.next();
		ProfileBean.insertInBean(profileBean, resultSet);
		}else {
			profileBean = new ProfileBean();
		}
	}
	public ProfileBean getProfile() {
		return profileBean;
	}
}
