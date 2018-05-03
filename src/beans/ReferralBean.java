package beans;

public class ReferralBean {
	private String ProfileA;
	private String ProfileB;
	private String ProfileC;
	private String DateTime;
	private String yourProfile;
	private String theirProfile;
	
	public ReferralBean() {
		ProfileA = "";
		ProfileB = "";
		ProfileC = "";
		DateTime = "";
		yourProfile = "";
		theirProfile = "";
	}

	public String getProfileA() {
		return ProfileA;
	}

	public void setProfileA(String profileA) {
		ProfileA = profileA;
	}

	public String getProfileB() {
		return ProfileB;
	}

	public void setProfileB(String profileB) {
		ProfileB = profileB;
	}

	public String getProfileC() {
		return ProfileC;
	}

	public void setProfileC(String profileC) {
		ProfileC = profileC;
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
