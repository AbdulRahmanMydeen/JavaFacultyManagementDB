import java.sql.SQLException;

public class Employee extends MysqlConnection {

	public int employeeId ;
	public long mobileNumber;
	public String employeeFirstName , employeeLastName , employeeDesignation;
	public char gender;
	public int age;
	public String mailId ;
	public String username , password;
	 Employee() throws SQLException {
		 super();
	}
	 
	
		private void selectEmployeeQuery()
		{
			try {
				System.out.println("\nEmployee FirstName  : " + result.getString("EmployeeFirstName"));
				System.out.println("Employee LastName   : " + result.getString("EmployeeLastName"));
				System.out.println("Designation         : " + result.getString("Designation"));
				System.out.println("Email ID            : " + result.getString("mailId"));
				System.out.println("\n");
			} 
			catch (SQLException e) {
				
				e.printStackTrace();
			}
		}

	public void selectDetails(String name)
	{
		query = "SELECT EmployeeFirstName , EmployeeLastName , Designation , MailID FROM employee WHERE employeefirstName = '" + name + "' OR employeeLastName = '" + name + "' ;";
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
