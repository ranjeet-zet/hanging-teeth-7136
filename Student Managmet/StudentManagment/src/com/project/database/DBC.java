package com.project.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBC {

	public static Connection ProvideConnection() {
		Connection conn = null;

		String url = "jdbc:mysql://localhost:3306/project";

		try {
			conn = DriverManager.getConnection(url, "root", "root");
		} catch (Exception e) {
			// TODO: handle exception
		}

		return conn;

	}

}
