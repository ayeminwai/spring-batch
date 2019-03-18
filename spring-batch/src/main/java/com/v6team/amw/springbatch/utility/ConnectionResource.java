package com.v6team.amw.springbatch.utility;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class ConnectionResource {
	private static final String driverClassName = "net.sourceforge.jtds.jdbc.Driver";
	private static final String url = "jdbc:jtds:sqlserver://localhost:1433/TestDB;Instance=SQL2016;";
	private static final String dbUsername = "sa";
	private static final String dbPassword = "ns123";

	public static DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(dbUsername);
		dataSource.setPassword(dbPassword);
		return dataSource;
	}
}
