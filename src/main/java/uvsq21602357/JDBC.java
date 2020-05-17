package uvsq21602357;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBC {

	private static String dburl = "jdbc:derby:test;create=true";
	private static String userName = "user";
	private static String password = "password";
	
	public static void connexion() throws SQLException {
		  String dbURL1 = "jdbc:derby:codejava/webdb1;create=true";
          Connection conn1 = DriverManager.getConnection(dbURL1);
          if (conn1 != null) {
              System.out.println("Connected to database #1");
          }
	}
	
	public static void main(String[] args) throws SQLException {
		connexion();
	}
}
