package Main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeList {

	public static ArrayList<String> getCustReps() throws SQLException{
		ArrayList<String> custReps = new ArrayList<String>();
		SQLAccessor sqlA = new SQLAccessor();
		ResultSet rs = sqlA.getAllCustReps();
		System.out.println(rs);
		while(rs.next()) {
			String employee = rs.getString("LastName")+", "+rs.getString("FirstName");
			custReps.add(employee);
		}
		rs.close();
		for(int i = 0; i<custReps.size();i++) {
			System.out.println(custReps.get(i));
		}
		return custReps;
	}
}
