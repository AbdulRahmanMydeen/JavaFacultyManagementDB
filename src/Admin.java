import java.sql.SQLException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Admin extends Faculty implements Validation {

	private String confirmationPassword;
	private String defaultPassword ;
	private String defaultAdminPassword;
	static private int totalNumber;
	private int numberOfEmployee;
	
	Admin() throws SQLException, InterruptedException
	{
		super();
		totalNumber = 0;
		defaultPassword = "password123";
		defaultAdminPassword = "admin2020";
	}
	
	private void deleteQuery(int id) {
		query = "delete from FacultyDetails where IdNumber = " + id + ";"; 
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
		
	private void insertQuery(int id , String firstName , String lastName , long mobileNumber , int age , char gender , String qualification , String emailId , String username , String password)    
	{
		query = "INSERT INTO FACULTYDETAILS VALUES(" + id + ",'" + firstName + "','" + lastName + "'," + mobileNumber + "," + age + ",'" + gender + "','" + qualification + "','" +emailId + "','" +username + "','" + password + "');";
		updateQuery();
	}
	
	private void selectAdminQuery()
	{
		try {
			System.out.print("\n");
			System.out.println("Faculty ID: " + result.getString("IdNumber") + "\nFirstName: " + result.getString("FacultyFirstName") );
			System.out.println("LastName: " + result.getString("LastName") + "\nMobileNumber: " + result.getString("MobileNumber") );
			System.out.println("Age: " + result.getString("Age") + "\nGender:" + result.getString("Gender") + "\nqualification: " + result.getString("qualification") );
			System.out.println("Email ID: " + result.getString("EmailId"));
			System.out.println("Username: " + result.getString("Username") + "\nPassword: " + result.getString("password"));
			System.out.print("\n");
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	private void selectDetails(int id)
	{
		query = "SELECT * FROM FacultyDetails Where IdNumber = " + id + ";";
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
		query = "UPDATE FACULTYDETAILS SET emailId = '"+ mailId + "', username = '" + username + "' WHERE IdNumber =" + id + ");";
		updateQuery();
	}
	
	private void updateQuery(int id , long mobileNumber)
	{
		query = "UPDATE FACULTYDETAILS SET mobilenumber = "+ mobileNumber +" WHERE IdNumber =" + id ;
		updateQuery();
	}

	private void updateQuery(int id , int age)
	{
		query = "UPDATE FACULTYDETAILS SET age = "+ age +" WHERE IdNumber =" + id + ";";
		updateQuery();
	}
	
	private void updateQuery(int id , char gender)
	{
		query = "UPDATE FACULTYDETAILS SET gender = '"+ gender +"' WHERE IdNumber =" + id + ";";
		updateQuery();
	}


	private void updateQuery(int id , String qualification)
	{
		query = "UPDATE FACULTYDETAILS SET qualification = '"+ qualification +"' WHERE IdNumber =" + id + ";";
		updateQuery();	
		}
	
	private void updateQuery(String username , String password)
	{
		query = "UPDATE FACULTYDETAILS SET password = '"+ password +"' WHERE username =" + username + ";";
		updateQuery();
	}

	
	public boolean validateId() {
		boolean error = false;
		while(!error)	{
			try{
				facultyId = scanner.nextInt();
				if(facultyId == '\0')
				{
					System.out.println("Enter the employee id:");
				}
				if(facultyId == 0)
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
			 facultyFirstName = scanner.next();
			 if(facultyFirstName.equals("r") || facultyFirstName.equals("R"))
			 {
				 error = true;
				 return error;
			 }
			 			
			 char[] firstName = new char[facultyFirstName.length()];
			 for(int index = 0 ;index < facultyFirstName.length(); index++)
			 {
				 firstName[index] = facultyFirstName.charAt(index);
			 }

			 for(int index = 0 ;index < facultyFirstName.length(); index++)
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

			 facultyLastName = scanner.next();
			 
			 if(facultyLastName.equals("r") || facultyLastName.equals("R"))
			 {
				 error = true;
				 return error;
			 }
			 
			 char[] lastName = new char[facultyLastName.length()];
			 
			 for(int index = 0 ;index < facultyLastName.length(); index++)
			 {
				 lastName[index] = facultyLastName.charAt(index);				 
			 }
			 
			 for(int index = 0 ;index < facultyLastName.length(); index++)
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
	
	private void qualification()
	{
		System.out.println("1.Chemical Engineering\n" + 
				"\n" + 
				"2.Process Control and Instrumentation Engineering\n" + 
				"\n" + 
				"3.Computer Science and Engineering\n" + 
				"\n" + 
				"4.Software Engineering\n" + 
				"\n" + 
				"5.Electrical Engineering\n" + 
				"\n" + 
				"6.Power Systems Engineering\n" + 
				"\n" + 
				"7.Mechanical Engineering\n" + 
				"\n" + 
				"8.Thermal Engineering\n" + 
				"\n" + 
				"9.Electronics and Communication Engineering\n" + 
				"\n" + 
				"10.VLSI System Design");
		int option = scanner.nextInt();
		switch(option)
		{
		case 1:
			qualification = qualification + " in " + "Chemical Engineering";
			break;
		
		case 2:
			qualification = qualification + " in " + "Process Control and Instrumentation Engineering";
			break;
			
		case 3:
			qualification = qualification + " in " + "Computer Science and Engineering";
			break;
		
		case 4:
			qualification = qualification + " in " + "Software Engineering";
			break;
			
		case 5:
			qualification = qualification + " in " + "Electrical Engineering";
			break;
		
		case 6:
			qualification = qualification + " in " + "Power Systems Engineering";
			break;
			
		case 7:
			qualification = qualification + " in " + "Mechanical Engineering";
			break;
		
		case 8:
			qualification = qualification + " in " + "Thermal Engineering";
			break;	

		case 9:
			qualification = qualification + " in " + "Electronics and Communication Engineering";
			break;
		
		case 10:
			qualification = qualification + " in " + "VLSI System Design";
			break;	

		}
	}
	
	public boolean validateQualification()
	{
		boolean error = false;
		String eQualification ;
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
				qualification = "M.E";
				qualification();
				break;
				
			case 2:
				qualification = "M.Tech";
				qualification();
				break;
				
			case 3:
				qualification = "Ph.D";
				System.out.println("Please Type your qualification in specfic");
				eQualification = scanner.nextLine();
				qualification = qualification + " in " + eQualification; 
				break;

			default:
				System.out.println("Invalid option!");
				validateQualification();
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

		 if(facultyLastName.length() < 5 && facultyFirstName.length() < 5)
		 {
			 username = facultyLastName  + facultyFirstName + Integer.toString(facultyId);
			 System.out.println("Username: " + username); 
		 }
		 
		 else if(facultyLastName.length() < 5)
		{
			 username = facultyFirstName + Integer.toString(facultyId);
			 System.out.println("Username: " + username);
		}
		 
		else {
			username = facultyLastName + Integer.toString(facultyId);
			System.out.println("Username: " + username);
		}
	}
	
	private void searchFacultyDetails()
	{
		int searchId = 0;
		System.out.println("Enter the ID number to be searched:");
		searchId = scanner.nextInt();
		selectDetails(searchId);
	}

	private void deleteFacultyDetails()
	{
		try {
			query = "SELECT * FROM FACULTYDETAILS;";
			statement = connection.createStatement();
			result  = statement.executeQuery(query);
			if(result.next() == false)
				System.out.println("No records saved!");
			else {
				int searchId = 0;
				System.out.println("Enter the Employee ID to be deleted:");
				searchId = scanner.nextInt();
				query = "SELECT IdNumber FROM FACULTYDETAILS WHERE IdNumber = " + searchId;
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

	private void getFacultyDetails()
	{
		 System.out.print("Enter the ID             :"); 
		 validateId();
		 
		 System.out.print("Enter the First name     :");
		 validateFirstName();
		 
		 System.out.print("Enter the Last name      :");
		 validateLastName();
		 
		 System.out.print("Enter the Mobile Number  :");
		 validateMobileNumber();
		 
		 System.out.print("Enter the Age            :");
		 validateAge();
		 
		 System.out.print("\n1.Male \n2.Female");
		 System.out.print("\nenter the option                   :");
		 validateGender();
		 
		 System.out.println("\nSelect the qualification : \n1.M.E \n2.M.Tech \n3.Ph.D");
		 validateQualification();
		  
		 validateUsername();
		 
		 mailId = facultyLastName + "." + facultyFirstName + "@attention.in" ;
		 System.out.println("MailID: " + mailId);
		 if(qualification == "admin") {
			 System.out.println("Default Password: " + defaultAdminPassword);
			 password = defaultPassword ;
		 }
		 else {
		 System.out.println("Default Password: " + "password123");
		 password = defaultPassword;
		 }
		 
		 insertQuery(facultyId , facultyFirstName , facultyLastName , mobileNumber , age , gender, qualification , mailId , username , password);
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
			query = "SELECT * FROM FACULTYDETAILS;";
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
	
	private void updateFacultyDetails()
	{
		try {
			query = "SELECT * FROM FACULTYDETAILS;";
			statement = connection.createStatement();
			result  = statement.executeQuery(query);
			if(result == null) {
				System.out.println("No records saved!");
				return ;
			}
			else {
				System.out.print("Enter the employee id to be updated:");
		        int id = scanner.nextInt();
		        
		        query = "SELECT IdNumber FROM FACULTYDETAILS WHERE IdNumber = " + id;
		        result = statement.executeQuery(query);	
		        if(result == null) {
		        	System.out.println("No records are found for the entered EmployeeId");
		        	return;
		        }
		        else {
			    System.out.print("Enter the First name");
			    System.out.print(" (OR Enter R to restore the previous data)     :");
				if(validateFirstName() == false) {
					query = "UPDATE FACULTYDETAILS SET FirstName = '"+ facultyFirstName + "' WHERE IdNumber =" + id + "";
					updateQuery();	
				}
				
				System.out.print("Enter the Last name");
			    System.out.print(" (OR Enter R to restore the previous data)     :");
				if(validateLastName() == false)
				{
					query = "UPDATE FACULTYDETAILS SET LastName = '"+ facultyLastName + "' WHERE IdNumber =" + id + "";
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
			    
			    System.out.print("Enter the Age");
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
			    
			    System.out.println("\n1.M.E \n2.M.Tech \n3.Ph.D");
			    System.out.print("Select the qualification (Or Enter 0 to restore the previous value:)");
			    if(validateQualification() == true)
			    {
					updateQuery(id,qualification);
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
			 System.out.println("How many faculty details do you want to enter?:");
			 numberOfEmployee = scanner.nextInt();
			 for(int index = 0; index < numberOfEmployee; index++)
				 getFacultyDetails();
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
		        searchFacultyDetails();
		        manageAdmin();
		 }
		 else if(option == 4)
		 {
		        updateFacultyDetails();
		        manageAdmin();
		     
		 }
		 else if(option == 5)
		 {
		        deleteFacultyDetails();
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
 
final protected void manageFaculty(int id)
{
	 int option = 0 ;
	 System.out.println("\n1.View Profile \n2.Search your co-workers \n3.Logout \nPress any number to exit");
	 option = scanner.nextInt();
	 if (option == 1)
	 {
		 selectDetails(id);
		 System.out.println("\n\n");
		 manageFaculty(id);
	 }
	 else if(option == 2)
	 {
		 String name = scanner.next();
		 selectDetails(name);
		 manageFaculty(id);
	 }
	 else if(option == 3)
	 {
		 enableMenu();
	 }	
	 else {
		 manageFaculty(id);
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
				query = "SELECT password , qualification ,FacultyFirstName, IdNumber FROM FacultyDetails WHERE username = '" + username + "';";
				statement = connection.createStatement();
				result  = statement.executeQuery(query);
				if(result == null)
				{
					System.out.println("No records in database");
					System.exit(0);
				}
						while(result.next()) {
							confirmationPassword = result.getString("password");
							qualification = result.getString("qualification");
							facultyFirstName = result.getString("FacultyFirstName");
							facultyId = result.getInt("IdNumber");
								}
						
								if(password.equals("Admin@123") && username.equals("Admin@123"))
								{
									System.out.println("Login successful!");
									System.out.println("You logged in as Admin User.");
									manageAdmin();
								}
								else if(password.equals(confirmationPassword))
								{
									System.out.println("Login successful!");
							        if(qualification.equals("Admin")) {
							        	System.out.println("Welcome " + facultyFirstName);
							        	manageAdmin();	
							        }
							         else
							         {
							        	 System.out.print("\nWelcome " + facultyFirstName);
							        	 manageFaculty(facultyId);
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
