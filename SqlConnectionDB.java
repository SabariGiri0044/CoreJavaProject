package olbs;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlConnectionDB {
	static final String db_driver = "com.mysql.cj.jdbc.Driver";
	final static String db_url= "jdbc:mysql://localhost:3306/OnlineBookStoreDB";
	final static String db_username = "root";
	final static String db_password = "root";
	
	public static Connection getConnection() {
		Connection connect = null;
		try {
			//register the jdbc Driver
			Class.forName(db_driver);
			connect = DriverManager.getConnection(db_url, db_username, db_password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return connect;
	}
}
© 2022 GitHub, Inc.
Terms
Privacy
Security
Status
Docs
Co
