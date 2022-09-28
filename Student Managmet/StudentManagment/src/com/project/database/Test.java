package com.project.database;

import java.sql.Connection;

public class Test {
	
	public static void main(String[] args) {
		Connection conn=DBC.ProvideConnection();
		System.out.println(conn);
	}

}
