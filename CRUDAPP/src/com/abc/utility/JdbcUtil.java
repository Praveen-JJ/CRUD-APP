package com.abc.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	public static Connection getDBConnection() throws IOException, SQLException {

		Properties properties = new Properties();
		String filePath = "C:\\Users\\Pc\\eclipse-workspace\\advancedJava\\CRUDAPP\\src\\com\\abc\\properties\\application.properties";
		FileInputStream fileInputStream = new FileInputStream(filePath);
		properties.load(fileInputStream);

		String url = properties.getProperty("jdbc.url");
		String username = properties.getProperty("jdbc.username");
		String password = properties.getProperty("jdbc.password");

		return DriverManager.getConnection(url, username, password);

	}

	public static void close(ResultSet resultSet, Statement statement, Connection connection) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
