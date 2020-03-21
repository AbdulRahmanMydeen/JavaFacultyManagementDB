import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MysqlConnection {
	public String query;
	public Scanner scanner = new Scanner(System.in);
	public Connection connection = null;
	public Statement statement = null;
	public ResultSet result;
	
	
	protected void delay(int delay) throws InterruptedException
	{
		for(int time = 0 ; time < delay ; time++)
			for(int count = 0; count < time ; count++)
			{}
	}
	MysqlConnection() throws SQLException, InterruptedException
	{
		try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/faculty" + "?autoReconnect=true&useSSL=false","root","Qazwsxedc123");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			
			if(connection == null)
			{
				delay(1000);
				connection.close();
			}
			System.out.println("Connected to Database ");
		}
	}
		
	
}
