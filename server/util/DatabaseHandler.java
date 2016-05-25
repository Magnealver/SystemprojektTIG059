package server.util;

import java.sql.*;
import java.awt.event.*;
import java.util.*;


public class DatabaseHandler {
	public Connection c;
	Statement s;
	PreparedStatement sm; 
	ResultSet rs;

	public DatabaseHandler(){
		c = createConnection();
	}

	public Connection createConnection(){
			Connection localConn = null;
			try {
				Class.forName("org.sqlite.JDBC");
			} catch(ClassNotFoundException cnfe){
				System.out.println("No driver found");
			} 
			System.out.println("Driver found!");
			
			try{
				localConn = DriverManager.getConnection("jdbc:sqlite:databasen.db");
			} catch (SQLException se){
				System.out.println("Couldn't connect to the database");
			}
			
			if(localConn !=null)
				System.out.println("Connected to the database");
			else
				System.out.println("Couldn't connect to the database");
			return localConn;
		}
	

	
}