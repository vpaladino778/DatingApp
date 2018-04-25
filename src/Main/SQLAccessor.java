package Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
public class SQLAccessor {

	Connection con;
	public SQLAccessor(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection
					("jdbc:mysql://mysql-305project.cwetgjbvvo5t.us-west-2.rds.amazonaws.com:3306/DatingDB","root","password");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	// Manager Level Transactions
	
	//add info for employee
	public void newEmployee(String SSN, String role, int hourlyRate, String pass, 
			String fname, String lname, String email, String street, String city, 
			String state, String zip, String phone) throws SQLException {
		PreparedStatement ps = con.prepareStatement("INSERT INTO employee (SSN,Role,StartDate,HourlyRate) VALUES(?,?,?,?)");
		ps.setString(0, SSN);
		ps.setString(1, role);
		Date date = new Date();
		Object param = new java.sql.Timestamp(date.getTime());
		ps.setObject(2, param);
		ps.setInt(3, hourlyRate);
		ps.executeUpdate();
		PreparedStatement ps2 = con.prepareStatement("INSERT INTO Person(SSN, Password, FirstName, LastName, Email, Street, City, State, ZipCode, Phone) VALUES (?,?,?,?,?, ?, ?,?, ?,?)");
		ps2.setString(0, SSN);
		ps2.setString(1, pass);
		ps2.setString(2, fname);
		ps2.setString(3, lname);
		ps2.setString(4, email);
		ps2.setString(5, street);
		ps2.setString(6, city);
		ps2.setString(7, state);
		ps2.setString(8, zip);
		ps2.setString(9, phone);
		ps2.executeUpdate();
	}
	
	// Update employee info
	public void updateEmployee(String col, String val, String SSN) throws SQLException {
		PreparedStatement ps = con.prepareStatement("UPDATE Employee SET ? = ? WHERE SSN=?");
		ps.setString(0, col);
		ps.setString(1, val);
		ps.setString(2, SSN);
		ps.executeUpdate();
		PreparedStatement ps2 = con.prepareStatement("UPDATE Person SET ? = ? WHERE SSN = ?");
		ps2.setString(0, col);
		ps2.setString(1, val);
		ps2.setString(2, SSN);
		ps2.executeUpdate();
	}
	
	public void deleteEmployee(String SSN) throws SQLException {
		PreparedStatement ps = con.prepareStatement("DELETE FROM Person WHERE SSN = ?");
		ps.setString(0, SSN);
		ps.executeUpdate();
		PreparedStatement ps2 = con.prepareStatement("DELETE FROM Employee WHERE SSN = ?");
		ps2.setString(0, SSN);
		ps2.executeUpdate();
	}
	
	public ResultSet monthlySalesReport(String year, String month) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Date WHERE Year(Date_Time)=? AND Month(Date_Time)=?");
		ps.setString(0, year);
		ps.setString(1, month);
		ResultSet rs = ps.executeQuery();
		return rs;
	}
	
	public ResultSet listAllUsers() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM User");
		ResultSet rs = ps.executeQuery();
		return rs;
	}
	
	public ResultSet datesByProfile(String profile) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Date WHERE Profile1=? OR Profile2=?");
		ps.setString(0, profile);
		ps.setString(1, profile);
		return ps.executeQuery();
	}
	
	public ResultSet datesByDate(String date) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Date WHERE Date_Time=?");
		ps.setString(0, date);
		return ps.executeQuery();
	}
	
	public ResultSet revenueByDate(String year, String month, String day) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT SUM(BookingFee) FROM date WHERE Year(Date_Time)=? AND Month(Date_Time)=? AND Day(Date_Time)=?");
		ps.setString(0, year);
		ps.setString(1, month);
		ps.setString(2, day);
		return ps.executeQuery();
	}
	
	public ResultSet revenueByProfile(String profile) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT SUM(BookingFee) FROM Date WHERE Profile1=? OR Profile2=?");
		ps.setString(0, profile);
		ps.setString(1, profile);
		return ps.executeQuery();
	}
	
	public ResultSet customerMostRevenue() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT Profile1, SUM(BookingFee) AS bf FROM (SELECT Profile1, "
				+ "BookingFee FROM Date UNION SELECT Profile2, BookingFee FROM Date) AS Fees GROUP BY Profile1 ORDER BY bf DESC LIMIT 0,1");
		ResultSet rs = ps.executeQuery();
		return rs;
	}
	
	public ResultSet customerMostActive() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM USER WHERE User.DateOfLastAct =" + 
				"(Select Max(DateOfLastAct) FROM User)");
		ResultSet rs = ps.executeQuery();
		return rs;
	}
	
	public ResultSet datedProfile(String profile) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Profile WHERE Profile.ProfileID IN(SELECT"+
				" Profile1 FROM Date WHERE Date.Profile2 = ?) UNION SELECT"+
				" * FROM Profile WHERE Profile.ProfileID = ALL(SELECT"+
				" Profile2 FROM Date WHERE Date.Profile1 = ?");
		ps.setString(0, profile);
		ps.setString(1, profile);
		return ps.executeQuery();
	}
	
	public ResultSet customerBestRated() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT FirstName, LastName FROM Person WHERE Person.SSN" + 
				" IN(SELECT SSN FROM User WHERE User.Rating >= ALL(SELECT" + 
				" Rating FROM User))");
		ResultSet rs = ps.executeQuery();
		return rs;
	}
	
	public ResultSet calendarDateBestRated() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT Date_Time, " + 
				"AVG((User1Rating+User1Rating)/2) AS avgrate " + 
				"FROM Date Group BY cast(Date_Time as Date) " + 
				"ORDER BY avgrate DESC LIMIT 0,1");
		ResultSet rs = ps.executeQuery();
		return rs;
	}
	
	//-----------------------------------------------------------------------------------------------------
	//Customer Representative Level Transactions
	
	public void recordDate(String p1, String p2, String cr, String location, int booking) throws SQLException {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Date(Profile1, Profile2, CustRep, Date_Time, Location, BookingFee) VALUES (?,?,?,?,?,?)");
		ps.setString(0, p1);
		ps.setString(1, p2);
		ps.setString(2, cr);
		Date date = new Date();
		Object param = new java.sql.Timestamp(date.getTime());
		ps.setObject(3, param);
		ps.setString(4, location);
		ps.setInt(5, booking);
		ps.executeUpdate();
	}
	
	public void addCustomer(String SSN, String email, String pass1) throws SQLException {
		PreparedStatement ps2 = con.prepareStatement("INSERT INTO Person(SSN, Password, Email) VALUES (?,?,?)");
		ps2.setString(1, SSN);
		ps2.setString(2, pass1);
		ps2.setString(3, email);
		ps2.executeUpdate();

		PreparedStatement ps3 = con.prepareStatement("INSERT INTO User(SSN) VALUES (?)");
		ps3.setString(1, SSN);
		ps3.executeUpdate();

		PreparedStatement ps4 = con.prepareStatement("INSERT INTO Profile(OwnerSSN, CreationDate, LastModDate) VALUES (?,?,?)");
		Date date = new Date();
		Object param = new java.sql.Timestamp(date.getTime());
		ps4.setString(1, SSN);
		ps4.setObject(2,param);
		ps4.setObject(3, param);
		ps4.executeUpdate();
	}
	
	public void updateCustomer(String SSN, String profileID, int age, int dars, int dare, int dgr, String gender, String hobbies, int height, int weight, String hair) throws SQLException {
		PreparedStatement ps4 = con.prepareStatement("UPDATE Profile SET ProfileID = ?, Age = ?, DatingAgeRangeStart = ?, DatingAgeRangeEnd = ?, DatingGeoRange = ?, M_F = ?, Hobbies = ?, Height = ?, Weight = ?, HairColor = ?, LastModDate = ? WHERE OwnerSSN = ?");
		Date date = new Date();
		Object param = new java.sql.Timestamp(date.getTime());
		ps4.setString(1, profileID);
		ps4.setString(6, gender);
		ps4.setString(9, hobbies);
		ps4.setString(10, hair);
		ps4.setInt(2, age);
		ps4.setInt(3, dars);
		ps4.setInt(4, dare);
		ps4.setInt(5, dgr);
		ps4.setInt(7, height);
		ps4.setInt(8, weight);
		ps4.setObject(11,param);
		ps4.setString(12, SSN);
		ps4.executeUpdate();
	}
	
	public void deleteCustomer(String SSN) throws SQLException {
		PreparedStatement ps = con.prepareStatement("DELETE FROM Person WHERE SSN=?");
		ps.setString(0, SSN);
		ps.executeUpdate();
	}
	
	public ResultSet getCustomerEmails() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT Email FROM Person WHERE Person.SSN IN (SELECT SSN FROM User)");
		ResultSet rs = ps.executeQuery();
		return rs;
	} 
	
	public ResultSet getCustomerAddresses() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT Street, City, State, ZipCode FROM Person WHERE Person.SSN IN (SELECT SSN FROM User)");
		ResultSet rs = ps.executeQuery();
		return rs;
	} 
	
	public ResultSet getCustomerPhones() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT Telephone FROM Person WHERE Person.SSN IN (SELECT SSN FROM User)");
		ResultSet rs = ps.executeQuery();
		return rs;
	} 
	
	public ResultSet getSuggestedProfiles(String p) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Profile WHERE Profile.ProfileID "
				+ "IN(SELECT Profile1 FROM SuggestedBy WHERE SuggestedBy.Profile2 = ?) UNION SELECT "
				+ "* FROM Profile WHERE Profile.ProfileID IN(SELECT Profile2 FROM SuggestedBy WHERE "
				+ "SuggestedBy.Profile1 = ?) UNION SELECT * FROM Profile WHERE Profile.ProfileID "
				+ "IN(SELECT ProfileC FROM Referral WHERE Referral.ProfileB = ?) UNION SELECT * "
				+ "FROM Profile WHERE Profile.ProfileID IN(SELECT ProfileB FROM Referral WHERE Referral.ProfileC = ?)");
		ps.setString(0, p);
		ps.setString(1, p);
		ps.setString(2, p);
		ps.setString(3, p);
		return ps.executeQuery();
	}
	
	//-----------------------------------------------------------------------------------------------
	// Customer level transactions
	
	public void rateDate(String profileRater, String profile1, String profile2, int rating) throws SQLException {
		PreparedStatement ps = con.prepareStatement("UPDATE DATE SET User1Rating=CASE WHEN Profile1=? "
				+ "THEN ? ELSE User1Rating END, User2Rating=CASE WHEN Profile2=? THEN ? "
				+ "ELSE User2Rating END WHERE Profile1=? AND Profile2=? AND Date_Time=?");
		ps.setString(0, profileRater);
		ps.setInt(1,rating);
		ps.setString(2, profileRater);
		ps.setInt(3, rating);
		ps.setString(4, profile1);
		ps.setString(5, profile2);
		Date date = new Date();
		Object param = new java.sql.Timestamp(date.getTime());
		ps.setObject(6, param);
		ps.executeUpdate();
	}
	
	public void makeDate(String profile1, String profile2, String date) throws SQLException {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Date (Profile1, Profile2, Date_Time) VALUES (?, ?, ?)");
		ps.setString(0, profile1);
		ps.setString(1, profile2);
		ps.setString(2, date);
		ps.executeUpdate();
	}
	
	public void makeGeoDate(String profile1, String profile2, String date, String location, String geoLocation) throws SQLException {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Date (Profile1, Profile2, Date_Time, Location, GeoLocation) VALUES (?, ?, ?, ?, ?)");
		ps.setString(0, profile1);
		ps.setString(1, profile2);
		ps.setString(2, date);
		ps.setString(3, location);
		ps.setString(4, geoLocation);
		ps.executeUpdate();
	}
	
	public void cancelDate(String profile1, String profile2, String date) throws SQLException {
		PreparedStatement ps = con.prepareStatement("DELETE FROM Date WHERE Profile1=? AND Profile2=? AND Date_Time=?");
		ps.setString(0, profile1);
		ps.setString(1, profile2);
		ps.setString(2, date);
		ps.executeUpdate();
	}
	
	public void commentOnDate(String comment, String profile1, String profile2, String date) throws SQLException {
		PreparedStatement ps = con.prepareStatement("UPDATE Date SET Comments=? WHERE Profile1=? AND Profile2=? AND Date_Time=?");
		ps.setString(0, comment);
		ps.setString(1, profile1);
		ps.setString(2, profile2);
		ps.setString(3, date);
		ps.executeUpdate();
	}
	
	public void likeProfile(String liker, String likee) throws SQLException {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Likes (Liker, Likee, Date_Time) VALUES (?, ?, ?)");
		ps.setString(0, liker);
		ps.setString(1, likee);
		Date date = new Date();
		Object param = new java.sql.Timestamp(date.getTime());
		ps.setObject(2, param);
		ps.executeUpdate();
	}
	
	public void refferProfile(String profileA, String profileB, String profileC, String date) throws SQLException {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Referral (ProfileA, ProfileB, ProfileC, Date_Time) VALUES (?, ?, ?, ?)");
		ps.setString(0, profileA);
		ps.setString(1, profileB);
		ps.setString(2, profileC);
		ps.setString(3, date);
		ps.executeUpdate();
	}
	
	public ResultSet viewPendingDates(String profile1, String profile2) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Date WHERE Date_Time >= NOW() AND Profile1=? OR Profile2=?");
		ps.setString(0, profile1);
		ps.setString(1, profile2);
		return ps.executeQuery();
	}
	
	public ResultSet viewPastDates(String profile1, String profile2) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Date WHERE Date_Time < NOW() AND Profile1=? OR Profile2=?");
		ps.setString(0, profile1);
		ps.setString(1, profile2);
		return ps.executeQuery();
	}
	
	public ResultSet viewFavorites(String liker)throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT Likee FROM Likes WHERE Liker=? GROUP BY Likee ORDER BY COUNT(Likee) DESC LIMIT 10");
		ps.setString(0, liker);
		return ps.executeQuery();
	}
	
	public ResultSet searchByFeature(String feature, String input) throws SQLException {
		if(feature.compareTo("Age")!=0&&feature.compareTo("HairColor")!=0&&feature.compareTo("Height")!=0 &&feature.compareTo("Weight")!=0) {
			return null;
		}
		else {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Profile WHERE Profile."+feature+" = ?");
			ps.setString(0, input);
			return ps.executeQuery();
		}
	}
	
	public ResultSet searchProfilesByLocation(String city) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Profile WHERE Profile.OwnerSSN IN (SELECT SSN FROM Person WHERE Person.City = ?)");
		ps.setString(0, city);
		return ps.executeQuery();	
	}
	
	public ResultSet mostActiveProfile() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT ProfileID, OwnerSSN, LastModDate "
				+ "From Profile WHERE Profile.OwnerSSN In(SELECT "
				+ "OwnerSSN FROM Profile WHERE Profile.LastModDate "
				+ ">= ALL(SELECT LastModDate FROM Profile)");
		return ps.executeQuery();
	}
	
	public ResultSet getHighestRated() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Profile WHERE Profile.OwnerSSN IN(SELECT SSN FROM User WHERE User.Rating>=ALL(SELECT Rating FROM User)");
		return ps.executeQuery();
	}
	
	public ResultSet getPopularGeoLocations() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT GeoLocation FROM Date WHERE GeoLocation IS NOT NULL GROUP BY GeoLocation ORDER BY COUNT(*) DESC LIMIT 3");
		return ps.executeQuery();
	}
	
	public ResultSet personalizedSuggestions(String profile1) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Profile WHERE Profile.ProfileID "
				+ "IN(SELECT Profile1 FROM SuggestedBy WHERE SuggestedBy.Profile2 = ?) UNION SELECT * "
				+ "FROM Profile WHERE Profile.ProfileID IN(SELECT Profile2 FROM SuggestedBy WHERE "
				+ "SuggestedBy.Profile1 = ?) UNION SELECT * FROM Profile WHERE Profile.ProfileID "
				+ "IN(SELECT ProfileC FROM Referral WHERE Referral.ProfileB = ?) UNION SELECT * "
				+ "FROM Profile WHERE Profile.ProfileID IN(SELECT ProfileB FROM Referral WHERE "
				+ "Referral.ProfileC = ?");
		ps.setString(0, profile1);
		ps.setString(1, profile1);
		ps.setString(2, profile1);
		ps.setString(3, profile1);
		return ps.executeQuery();
	}
}
