import java.sql.SQLException;

public class User {
	public static void main(String[] args)
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
