import java.sql.SQLException;

public class Faculty extends MysqlConnection {

	public int facultyId ;
	public long mobileNumber;
	public String facultyFirstName , facultyLastName , qualification , designation;
	public char gender;
	public int age;
	public String mailId ;
	public String username , password;
	 
	
	Faculty() throws SQLException, InterruptedException {
		 super();
	}
	 
	
		private void selectEmployeeQuery()
		{
			try {
				System.out.println("\nFirstName           : " + result.getString("FacultyFirstName"));
				System.out.println("LastName              : " + result.getString("LastName"));
				System.out.println("Qualification         : " + result.getString("qualification"));
				System.out.println("Email ID              : " + result.getString("mailId"));
				System.out.println("\n");
			} 
			catch (SQLException e) {
				
				e.printStackTrace();
			}
		}

	public void selectDetails(String name)
	{
		query = "SELECT facultyFirstName , facultyLastName , qualification , designation , MailID FROM FacultyDetails WHERE facultyFirstName = '" + name + "' OR LastName = '" + name + "' ;";
		try {
			statement = connection.createStatement();
			result = statement.executeQuery(query);
			if(result.next() == false)
			{
				System.out.println("No records found!");
			}
			else {	
				selectEmployeeQuery();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
