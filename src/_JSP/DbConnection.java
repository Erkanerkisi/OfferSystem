package _JSP;

import java.sql.*;

import javax.servlet.ServletException;

public class DbConnection {
	
	
	


	// DBConnection Method to connect to  Database
	public static Connection getConnection()  {
		

		Connection cons = null;

		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cons = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "system");
		} catch (Exception e) {
			e.printStackTrace();
	
		
		}
		return cons;
		

	}
	

}
