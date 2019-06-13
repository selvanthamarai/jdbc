package library;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	Database(){
		
		connect();
	}
	
	public Connection con;
	
	public void connect() {
	
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
	   con=DriverManager.getConnection(
	    "jdbc:mysql://localhost:3307/lib","root","root");
	}catch (Exception e) {
		System.out.println(e);
	}
}
}


