package dbmsdatabase;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DatabaseConn {
	
	static String url = "jdbc:mysql://localhost:3306/";
	static String dbName = "animalshelter"; 
	static String driver = "com.mysql.jdbc.Driver"; 
	static String userName = "root";
	static String password = ""; 
	
	static Connection conn;
	static Statement st;
	
	public static void main(String args[]) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
			ConnectToDatabase();
			ResultSet r=SelectStatement("SELECT * from animals");
			InsertStatement("INSERT into animals VALUES(\"suraj\",\"delhi\")");
				
			
			
	/*			
			st.executeUpdate("INSERT into animals VALUES(\"suraj\",\"delhi\")");
			System.out.println("Inserted successfully");
*/
		
	}
	
	public static void ConnectToDatabase() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Class.forName(driver).newInstance();
		System.out.println("class for name working.");
		conn = (Connection) DriverManager.getConnection(url+dbName,userName,password);
		System.out.println("Connection established");
		st = (Statement) conn.createStatement();
	}

	public static ResultSet SelectStatement(String query) throws SQLException
	{
		
		System.out.println("Created stament");
		ResultSet res = st.executeQuery(query);
		return res;
/*		while (res.next()) 
		{ 
			String name = res.getString("name");
			String loc = res.getString("location"); 
			System.out.println(name+"|"+loc); 
		}
*/
	}
	
	public static void InsertStatement(String query) throws SQLException
	{
		st.executeUpdate(query);
		System.out.println("Inserted successfully");
	}
	
}
