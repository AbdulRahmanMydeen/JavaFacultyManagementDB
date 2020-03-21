import java.sql.SQLException;

public class User {
	public static void main(String[] args) throws InterruptedException
	{
		try {
				Admin admin = new Admin();
				admin.enableMenu();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
