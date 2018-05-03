package beans;

public class SuggestedByBean {
	private String CustRep;
	private String Profile1;
	private String Profile2;
	private String DateTime;
	private String yourProfile;
	private String theirProfile;
	
	public SuggestedByBean() {
		CustRep = "";
		Profile1 = "";
		Profile2 = "";
		DateTime = "";
		yourProfile = "";
		theirProfile = "";
	}

	public String getCustRep() {
		return CustRep;
	}

	public void setCustRep(String custRep) {
		CustRep = custRep;
	}

	public String getProfile1() {
		return Profile1;
	}

	public void setProfile1(String profile1) {
		Profile1 = profile1;
	}

	public String getProfile2() {
		return Profile2;
	}

	public void setProfile2(String profile2) {
		Profile2 = profile2;
	}

	public String getDateTime() {
		return DateTime;
	}

	public void setDateTime(String dateTime) {
		DateTime = dateTime;
	}

	public String getYourProfile() {
		return yourProfile;
	}

	public void setYourProfile(String yourProfile) {
		this.yourProfile = yourProfile;
	}

	public String getTheirProfile() {
		return theirProfile;
	}

	public void setTheirProfile(String theirProfile) {
		this.theirProfile = theirProfile;
	}
	
}
