package beans;

public class LikesBean {
	private String Liker;
	private String Likee;
	private String DateTime;
	
	public LikesBean() {
		Liker = "";
		Likee = "";
		DateTime = "";
	}

	public String getLiker() {
		return Liker;
	}

	public void setLiker(String liker) {
		Liker = liker;
	}

	public String getLikee() {
		return Likee;
	}

	public void setLikee(String likee) {
		Likee = likee;
	}

	public String getDateTime() {
		return DateTime;
	}

	public void setDateTime(String dateTime) {
		DateTime = dateTime;
	}
	
}
