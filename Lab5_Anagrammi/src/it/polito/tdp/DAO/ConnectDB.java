package it.polito.tdp.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

	private static final String jdbcURL = "jdbc:mysql://localhost/dizionario?user=root&password=root";
	private static Connection conn = null;
	
	public static Connection getConnection() {
		try {
			if (conn == null || conn.isClosed()) {
				conn = DriverManager.getConnection(jdbcURL);
			}
		} catch (SQLException e) {
			System.out.println("Non e' possible aprire la connessione con il DB");
		}
		return conn;
	}


}
