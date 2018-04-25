package Main;

public class ProfileSignedIn {

	String SSN;
	String email;
	public ProfileSignedIn(String sSN, String email) {
		super();
		SSN = sSN;
		this.email = email;
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
}
