package com.v6team.amw.springbatch.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {
	private static String driver = "net.sourceforge.jtds.jdbc.Driver";
	
	public static Connection getConnection() {
		return getConnectionByProperties();
	}

	private static Connection getConnectionByProperties() {
		String url = "jdbc:jtds:sqlserver://localhost:1433/TestDB;Instance=SQL2016;";
		String userId = "sa";
		String password = "ns123";

		try {
			Class.forName(driver).newInstance();
			return DriverManager.getConnection(url, userId, password);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}
}
