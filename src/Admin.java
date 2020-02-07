import java.sql.SQLException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Admin extends Employee implements Validation {

	private String confirmationPassword;
	private String defaultPassword ;
	private String defaultAdminPassword;
	static private int totalNumber;
	private int numberOfEmployee;
	
	Admin() throws SQLException
	{
		super();
		totalNumber = 0;
		defaultPassword = "password123";
		defaultAdminPassword = "admin2020";
	}
	
	private void deleteQuery(int id) {
		query = "delete from employee where EmployeeID = " + id + ";"; 
		try
		{
			statement = connection.createStatement();
			statement.executeUpdate(query);
			System.out.print("Record Deleted!");
		}
		catch(SQLException e ) {
			e.printStackTrace();
		}
	}
		
	private void insertQuery(int id , String firstName , String lastName , long mobileNumber , int age , char gender , String designation , String emailId , String username , String password)    
	{
		query = "INSERT INTO EMPLOYEE VALUES(" + id + ",'" + firstName + "','" + lastName + "'," + mobileNumber + "," + age + ",'" + gender + "','" + designation + "','" +emailId + "','" +username + "','" + password + "');";
		updateQuery();
	}
	
	private void selectAdminQuery()
	{
		try {
			System.out.print("\n");
			System.out.println("Employee ID: " + result.getString("EmployeeId") + "\nEmployee FirstName: " + result.getString("EmployeeFirstName") );
			System.out.println("Employee LastName: " + result.getString("EmployeeLastName") + "\nMobileNumber: " + result.getString("MobileNumber") );
			System.out.println("Age: " + result.getString("Age") + "\nGender:" + result.getString("Gender") + "\nDesignation: " + result.getString("Designation") );
			System.out.println("Email ID: " + result.getString("mailID"));
			System.out.println("Username: " + result.getString("Username") + "\nPassword: " + result.getString("password"));
			System.out.print("\n");
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	private void selectDetails(int id)
	{
		query = "SELECT * FROM employee Where employeeid = " + id + ";";
		try {
			statement = connection.createStatement();
			result = statement.executeQuery(query);
			if(result.next() == false)
			{
				System.out.println("No records found!");
			}
			else {
				System.out.println("record found!");
					selectAdminQuery();
			}
					}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void updateQuery()
	{
		try
		{
			statement = connection.createStatement();
			statement.executeUpdate(query);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	private void updateQuery(int id , String username , String mailId)
	{
		query = "UPDATE EMPLOYEE SET mailID = '"+ mailId + "', username = '" + username + "' WHERE employeeId =" + id + ");";
		updateQuery();
	}
	
	private void updateQuery(int id , long mobileNumber)
	{
		query = "UPDATE EMPLOYEE SET mobilenumber = "+ mobileNumber +" WHERE employeeId =" + id ;
		updateQuery();
	}

	private void updateQuery(int id , int age)
	{
		query = "UPDATE EMPLOYEE SET age = "+ age +" WHERE employeeId =" + id + ";";
		updateQuery();
	}
	
	private void updateQuery(int id , char gender)
	{
		query = "UPDATE EMPLOYEE SET gender = '"+ gender +"' WHERE employeeId =" + id + ";";
		updateQuery();
	}


	private void updateQuery(int id , String designation)
	{
		query = "UPDATE EMPLOYEE SET Designation = '"+ designation +"' WHERE employeeId =" + id + ";";
		updateQuery();	
		}
	
	private void updateQuery(String username , String password)
	{
		query = "UPDATE EMPLOYEE SET password = '"+ password +"' WHERE username =" + username + ";";
		updateQuery();
	}

	
	public boolean validateId() {
		boolean error = false;
		while(!error)	{
			try{
				employeeId = scanner.nextInt();
				if(employeeId == '\0')
				{
					System.out.println("Enter the employee id:");
				}
				if(employeeId == 0)
				{
					return error;
				}
				error = true;
				}
		catch(Exception e)
		{
			System.out.println("Error");
			System.out.println("Type only numbers");
			String flush = scanner.next();
		}
	}
		return error;
	}

	public boolean validateFirstName()
	{
			 boolean error = false ;
			 employeeFirstName = scanner.next();
			 if(employeeFirstName.equals("r") || employeeFirstName.equals("R"))
			 {
				 error = true;
				 return error;
			 }
			 			
			 char[] firstName = new char[employeeFirstName.length()];
			 for(int index = 0 ;index < employeeFirstName.length(); index++)
			 {
				 firstName[index] = employeeFirstName.charAt(index);
			 }

			 for(int index = 0 ;index < employeeFirstName.length(); index++)
			 {
				 if(!((firstName[index] >=65 && firstName[index] <= 90) || (firstName[index] >=97 && firstName[index] <= 122)))
				 {
					 error = true;
				 	break;
				 }
			 }
			 if(error == true)
			 {
				System.out.println("Error!");
				System.out.println("Name should contain only alphabets");
				validateFirstName();
			 }
			 return error;
	}
	
	public boolean validateLastName()
	{		 
		 boolean error = false ;

			 employeeLastName = scanner.next();
			 
			 if(employeeLastName.equals("r") || employeeLastName.equals("R"))
			 {
				 error = true;
				 return error;
			 }
			 
			 char[] lastName = new char[employeeLastName.length()];
			 
			 for(int index = 0 ;index < employeeLastName.length(); index++)
			 {
				 lastName[index] = employeeLastName.charAt(index);				 
			 }
			 
			 for(int index = 0 ;index < employeeLastName.length(); index++)
			 {
				 if(!((lastName[index] >=65 && lastName[index] <= 90) || (lastName[index] >=97 && lastName[index] <= 122)))
				 {
					error = true;
				 	break;
				 }
			 }
			 if(error == true)
			 {
				System.out.println("Error!");
				System.out.println("Name should contain only alphabets");
				validateLastName();
			 }
			 return error;
				 	  
	}
	
	public boolean validateGender()
	{
		boolean error = false;
	while(!error)
	{
		try {
				int option ;
				option = scanner.nextInt();
				if(option == 0)
					return error;
				switch(option) {
				case 1:
					gender = 'M';
					break;
				
				case 2:
					gender = 'F';
					break;
				
				default:
					System.out.println("Invalid option!");
					validateGender();
					break;
				}
				error = true;
		}
		catch(Exception e) {
			System.out.println("Error!");
			System.out.println("Invalid Input!");
			String flush = scanner.next();
			}		
	}
		return error;
	}
	
	public boolean validateDesignation()
	{
		boolean error = false;
		while(!error)
		{
			try {
		int option = 0;
		option = scanner.nextInt();
		if(option == 0)
		{
			return error;
		}

		switch(option)
		{
			case 1:
				employeeDesignation = "Retail";
				break;
				
			case 2:
				employeeDesignation = "Testing";
				break;
				
			case 3:
				employeeDesignation = "Developer";
				break;
			
			case 4:
				employeeDesignation = "Intern";
				break;
				
			case 5:
				employeeDesignation = "Admin";
				break;
			
			default:
				System.out.println("Invalid option!");
				validateDesignation();
				break;
			}
			error = true;
	}
	catch(Exception e) {
		System.out.println("Error!");
		System.out.println("Invalid Input!");
		String flush = scanner.next();
		}		
	}	
		return error;
}

	public boolean validateAge() {
		boolean error = false;
		while(!error)	{
			try{
				age = scanner.nextInt();
				if(age == 0)
				{
					return error;
				}

				if(!(age >= 18 && age <= 60))
					{
						System.out.println("Enter valid age!");
						validateAge();	
				    }
				error = true;
				}
		catch(Exception e){
			System.out.println("Error");
			System.out.println("Type only numbers");
			String flush = scanner.next();
			}	
		}
			return error;
	}
	
	public boolean validateMobileNumber() {
		boolean error = false;
		while(!error) {
			try {
		mobileNumber = scanner.nextLong();

		int length = String.valueOf(mobileNumber).length();
		String number = Long.toString(mobileNumber);
		if(number == "0")
		{
			return error;
		}
		if(length != 10)
		{
			System.out.println("Enter a valid number!");
			validateMobileNumber();
		}
		error = true;
			}
		catch(Exception e)
		{
			System.out.println("Error");
			System.out.println("Type only numbers");
			String flush = scanner.next();
		}
			}
		return error;
	}
	
	private void validateUsername()
	{

		 if(employeeLastName.length() < 5 && employeeFirstName.length() < 5)
		 {
			 username = employeeLastName  + employeeFirstName + Integer.toString(employeeId);
			 System.out.println("Employee Username: " + username); 
		 }
		 
		 else if(employeeLastName.length() < 5)
		{
			 username = employeeFirstName + Integer.toString(employeeId);
			 System.out.println("Employee Username: " + username);
		}
		 
		else {
			username = employeeLastName + Integer.toString(employeeId);
			System.out.println("Employee Username: " + username);
		}
	}
	
	private void searchEmployeeDetails()
	{
		int searchId = 0;
		System.out.println("Enter the Employee ID to be searched:");
		searchId = scanner.nextInt();
		selectDetails(searchId);
	}

	private void deleteEmployeeDetails()
	{
		try {
			query = "SELECT * FROM employee;";
			statement = connection.createStatement();
			result  = statement.executeQuery(query);
			if(result.next() == false)
				System.out.println("No records saved!");
			else {
				int searchId = 0;
				System.out.println("Enter the Employee ID to be deleted:");
				searchId = scanner.nextInt();
				query = "SELECT EmployeeId FROM employee WHERE employeeId = " + searchId;
		        result = statement.executeQuery(query);	
		        if(result.next() == false) {
		        	System.out.println("No records are found for the entered EmployeeId");
		        	return;
		        }
		        else
		        	deleteQuery(searchId);
	    	  } 
	      }
		catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

	private void getEmployeeDetails()
	{
		 System.out.print("Enter the employee ID             :"); 
		 validateId();
		 
		 System.out.print("Enter the employee First name     :");
		 validateFirstName();
		 
		 System.out.print("Enter the employee Last name      :");
		 validateLastName();
		 
		 System.out.print("Enter the employee Mobile Number  :");
		 validateMobileNumber();
		 
		 System.out.print("Enter the employee Age            :");
		 validateAge();
		 
		 System.out.print("\n1.Male \n2.Female");
		 System.out.print("\nenter the option                   :");
		 validateGender();
		 
		 System.out.println("\nSelect the Designation : \n1.Retail \n2.Testing \n3.Developer \n4.Intern \n5.Admin");
		 validateDesignation();
		  
		 validateUsername();
		 
		 mailId = employeeLastName + "." + employeeFirstName + "@attention.in" ;
		 System.out.println("Employee MailID: " + mailId);
		 if(employeeDesignation == "admin") {
			 System.out.println("Employee Default Password: " + defaultAdminPassword);
			 password = defaultPassword ;
		 }
		 else {
		 System.out.println("Employee Default Password: " + "password123");
		 password = defaultPassword;
		 }
		 
		 insertQuery(employeeId , employeeFirstName , employeeLastName , mobileNumber , age , gender, employeeDesignation , mailId , username , password);
		 System.out.println("Successfully Inserted!");
		 

	}
	
	public void changePassword()
	{
		String fpassword; 
		System.out.println("Enter the ");
	}
	
	private void displayDetails()
	{
		try {
			query = "SELECT * FROM employee;";
			statement = connection.createStatement();
			result  = statement.executeQuery(query);
			if(result == null)
				System.out.println("No records to display!");
			else {
				while(result.next())
					selectAdminQuery();
	    	     } 
	      }
		catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	private void updateEmployeeDetails()
	{
		try {
			query = "SELECT * FROM employee;";
			statement = connection.createStatement();
			result  = statement.executeQuery(query);
			if(result == null) {
				System.out.println("No records saved!");
				return ;
			}
			else {
				System.out.print("Enter the employee id to be updated:");
		        int id = scanner.nextInt();
		        
		        query = "SELECT EmployeeId FROM employee WHERE employeeId = " + id;
		        result = statement.executeQuery(query);	
		        if(result == null) {
		        	System.out.println("No records are found for the entered EmployeeId");
		        	return;
		        }
		        else {
			    System.out.print("Enter the employee First name");
			    System.out.print(" (OR Enter R to restore the previous data)     :");
				if(validateFirstName() == false) {
					query = "UPDATE EMPLOYEE SET EmployeeFirstName = '"+ employeeFirstName + "' WHERE employeeId =" + id + "";
					updateQuery();	
				}
				
				System.out.print("Enter the employee Last name");
			    System.out.print(" (OR Enter R to restore the previous data)     :");
				if(validateLastName() == false)
				{
					query = "UPDATE EMPLOYEE SET EmployeeLastName = '"+ employeeLastName + "' WHERE employeeId =" + id + "";
					updateQuery();
				}
				
				/*validateUsername();
				mailId = employeeLastName + "." + employeeFirstName + "@attention.in" ;
				updateQuery(id , username , mailId);*/
				
				System.out.print("Enter the Mobile Number");
			    System.out.print(" (OR Enter 0 to restore the previous data)     :");
			    if(validateMobileNumber() == true)
			    {
					updateQuery(id,mobileNumber);
				}
			    
			    System.out.print("Enter the employee Age");
			    System.out.print(" (OR Enter 0 to restore the previous data)     :");
			    if(validateAge() == true)
			    {
					updateQuery(id,age);
				}
			    
			    
			    System.out.print("\n1.Male \n2.Female");
				System.out.print("\nenter the option (Or Enter 0 to restore the previous value):");
			    if(validateGender() == true)
			    {
					updateQuery(id,mobileNumber);
				}
			    
			    System.out.println("\n1.Retail \n2.Testing \n3.Developer \n4.Intern \n5.Admin");
			    System.out.print("Select the Designation (Or Enter 0 to restore the previous value:)");
			    if(validateDesignation() == true)
			    {
					updateQuery(id,employeeDesignation);
				}
			     
	    	     } 
			}
	      }
		catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	        
		
	}
	
	private void manageAdmin()
	{
		 int option ;
		 try {
		 System.out.println("\n1.Add \n2.Display \n3.Search \n4.Edit \n5.Delete \n6.Logout \nPress any number to exit");
		 option = scanner.nextInt();
		 if (option == 1)
		 {
			 System.out.println("How many employee details do you want to enter?:");
			 numberOfEmployee = scanner.nextInt();
			 for(int index = 0; index < numberOfEmployee; index++)
				 getEmployeeDetails();
			 System.out.println("\n");
			 totalNumber += numberOfEmployee;
			 manageAdmin();
		 }
		 else if(option == 2)
		 { 		 
			 displayDetails();	
			 manageAdmin();
		 }
		 else if(option == 3)
		 {
		        searchEmployeeDetails();
		        manageAdmin();
		 }
		 else if(option == 4)
		 {
		        updateEmployeeDetails();
		        manageAdmin();
		     
		 }
		 else if(option == 5)
		 {
		        deleteEmployeeDetails();
		        manageAdmin();
		 }
		 else if(option == 6)
		 {
			enableMenu();
		 }
		 else
		 {
			System.out.println("you exited the program!");
			System.exit(0);
		}
	}
		 catch(Exception e) {
			 System.out.println("Invalid Input!");
			 String flush = scanner.next();
		 }
	 }
	public void enableMenu() {
		boolean error = false;
		while(!error)
		{
			try {
			System.out.print("\n1.login \n2.exit");
			int choice = scanner.nextInt();
			if(choice == 1)
			{
				login();
			}
			else if (choice == 2)
			{
				System.out.println("You have exited the program");
				System.exit(0);
			}
			else
				enableMenu();
			error = true;
	}
		catch(Exception e) {
			System.out.println("Invalid Input!");
			String flush = scanner.next();
		}
	}
	}
 
final protected void manageEmployee(int id)
{
	 int option = 0 ;
	 System.out.println("\n1.View Profile \n2.Search your co-workers \n3.Logout \nPress any number to exit");
	 option = scanner.nextInt();
	 if (option == 1)
	 {
		 selectDetails(id);
		 System.out.println("\n\n");
		 manageEmployee(id);
	 }
	 else if(option == 2)
	 {
		 String name = scanner.next();
		 selectDetails(name);
		 manageEmployee(id);
	 }
	 else if(option == 3)
	 {
		 enableMenu();
	 }	
	 else {
		 manageEmployee(id);
	 }
}
	
	private void login()
	{
		try {
				System.out.println("    Welcome");
				System.out.print("Username :");
				username = scanner.next();
				System.out.print("Password :");
				password = scanner.next();
				query = "SELECT password , designation , employeefirstname ,employeeId FROM employee WHERE username = '" + username + "';";
				statement = connection.createStatement();
				result  = statement.executeQuery(query);
				if(result == null)
				{
					System.out.println("No records in database");
					System.exit(0);
				}
						while(result.next()) {
							confirmationPassword = result.getString("password");
							employeeDesignation = result.getString("Designation");
							employeeFirstName = result.getString("employeeFirstName");
							employeeId = result.getInt("employeeId");
								}
						
								if(password.equals("Admin@123") && username.equals("Admin@123"))
								{
									System.out.println("Login successful!");
									System.out.println("You logged in as Default User.\nAdd your detail to the database");
									manageAdmin();	
								}
								else if(password.equals(confirmationPassword))
								{
									System.out.println("Login successful!");
							        if(employeeDesignation.equals("Admin")) {
							        	System.out.println("Welcome " + employeeFirstName);
							        	manageAdmin();	
							        }
							         else
							         {
							        	 System.out.print("\nWelcome " + employeeFirstName);
							        	 manageEmployee(employeeId);
							         }
								}
				
							    else{
							    		System.out.println("Login Unsuccessful!");
								        System.out.println("Retry Again");
								        login();
								        }
					}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
			     	    
	 }
	
}
