package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	public static final String URL ="jdbc:mysql://localhost:33060/viajeserrekamari";
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String USER = "mañana";
	public static final String PASSWORD = "M@ñana!D4M3";	
	
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL,USER,PASSWORD);
		
		
	}
}
