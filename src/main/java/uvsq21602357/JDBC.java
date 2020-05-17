package uvsq21602357;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class JDBC {

	private static final String Driver = "org.apache.derby.jdbc.EmbeddedDriver";
	private static String dburl = "jdbc:derby:pglp:create=true";
	Connection conn;
	
	public JDBC() {
		try {
			this.conn = DriverManager.getConnection(dburl);
			if(this.conn != null) {
				System.out.println("Connexion reussi");
			}
			else { 
				System.out.println("Echec de connexion");
			}
		} catch  (SQLException e) {
			
		}
	}
	
	public static void main(String[] args) {
		JDBC connectTest = new JDBC();
	}

}
