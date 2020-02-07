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
	MysqlConnection() throws SQLException
	{
		try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase" + "?autoReconnect=true&useSSL=false","root","Aspire@123");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			if(connection == null)
			{
				connection.close();
			}
			System.out.println("Connected to Database ");
		}
	}
		
	
}
