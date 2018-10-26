package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DBconn {
	private String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=true";
	private String user = "root";
	private String password = "201517";
	private String driver = "com.mysql.jdbc.Driver";

	public Connection getConn() {
		Connection conn = null;
		try {
			Class.forName(driver);
		} catch (Exception e) {
		}
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
		}
		return conn;
	}
}
