package beans;

import java.io.Serializable;

public class DateBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String Profile1;
	private String Profile2;
	private String CustRep;
	private String Date_Time;
	private String Location;
	private int BookingFee;
	private String Comment;
	private int User1Rating;
	private int User2Rating;
	private String GeoLocation;
	private String otherUser;
	
	public DateBean() {
		//default values
		Profile1 = "";
		Profile2 = "";
		CustRep = "";
		Date_Time = "";
		Location = "";
		BookingFee = 0;
		Comment = "";
		User1Rating = 0;
		User2Rating = 0;
		GeoLocation = "";
		
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

	public String getCustRep() {
		return CustRep;
	}

	public void setCustRep(String custRep) {
		CustRep = custRep;
	}

	public String getDate_Time() {
		return Date_Time;
	}

	public void setDate_Time(String date_Time) {
		Date_Time = date_Time;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public int getBookingFee() {
		return BookingFee;
	}

	public void setBookingFee(int bookingFee) {
		BookingFee = bookingFee;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}

	public int getUser1Rating() {
		return User1Rating;
	}

	public void setUser1Rating(int user1Rating) {
		User1Rating = user1Rating;
	}

	public int getUser2Rating() {
		return User2Rating;
	}

	public void setUser2Rating(int user2Rating) {
		User2Rating = user2Rating;
	}

	public String getGeoLocation() {
		return GeoLocation;
	}

	public void setGeoLocation(String geoLocation) {
		GeoLocation = geoLocation;
	}
	
	public String getOtherUser() {
		return otherUser;
	}
	
	public void setOtherUser(String otherUser) {
		this.otherUser = otherUser;
	}
	
	

}
