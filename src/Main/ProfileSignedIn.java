package Main;

public class ProfileSignedIn {

	String SSN;
	String email;
	String profileID;
	public ProfileSignedIn(String sSN, String email, String profileID) {
		super();
		SSN = sSN;
		this.email = email;
		this.profileID = profileID;
	}
	public String getSSN() {
		return SSN;
	}
	public void setSSN(String sSN) {
		SSN = sSN;
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
	}
}
