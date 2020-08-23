package com.gilbertog.amazonviewer.db;

import java.sql.DriverManager;
import java.sql.Connection;
import static com.gilbertog.amazonviewer.db.DataBase.*;

public interface IDBConnection {

	default Connection connectToDB() {
		Connection connection = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL+DB, USER, PASSWORD);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			return connection;
		}
	}
	
}