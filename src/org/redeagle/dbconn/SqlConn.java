package org.redeagle.dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlConn {
	private String host, uname, pass, dbName, port;
	private Connection connection;
	private Statement statement;
	private ResultSet rs;
	
	public SqlConn(String host, String uname, String pass, String dbName, String port) {
		this.host = host;
		this.uname = uname;
		this.pass = pass;
		this.dbName = dbName;
		this.port = port;
	}
	
	public SqlConn(String host, String uname, String pass, String dbName) {
		this.host = host;
		this.uname = uname;
		this.pass = pass;
		this.dbName = dbName;
		this.port = "3306";
	}

	public void start() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("MySQL JDBC Driver Not Found");
			e.printStackTrace();
			return;
		}
		connection = null;

		try {
			connection = DriverManager
			.getConnection("jdbc:mysql://"+ this.getIP() + ":" + this.getPort() + "/" + this.getDB(),this.getUsername(),this.getPassword());

		} catch (SQLException e) {
			System.out.println("MySQL Connection Failed");
			e.printStackTrace();
			return;
		}
		
		if(connection != null) {
			System.out.println("Successfully connected to Database");
		}
	}
	
	public void query(String query) {
		try {
			statement = connection.createStatement();
			String[] checkQuery = query.split(" ");
			if(checkQuery[0] == "INSERT") {
				statement.executeUpdate(query);
			}
			if(checkQuery[0] == "SELECT") {
				rs = statement.executeQuery(query);
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public ResultSet rs() {
		return this.rs;
	}
	
	public void close() throws SQLException {
		connection.close();
	}
	
	public String getIP() {
		return this.host;
	}
	
	public String getUsername() {
		return this.uname;
	}
	
	public String getPassword() {
		return this.pass;
	}
	
	public String getDB() {
		return this.dbName;
	}
	
	public String getPort() {
		return this.port;
	}
}
