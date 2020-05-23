package uvsq21602357;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class JDBC {
	public Connection conn;
	
	public JDBC() throws SQLException, ClassNotFoundException {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	      //Getting the Connection object
	      String URL = "jdbc:derby:DB;create=true";
	      this.conn = DriverManager.getConnection(URL);
	      if(conn!= null) {
	      System.out.println("Connecté à la base");
	      }
	      //Creating the Statement object
	   }
	
	
	public void CreateTable() {
		  Statement stmt;
		try {
			stmt = this.conn.createStatement();
			 //Executing the query
		      String query = "CREATE TABLE formes( "
		         + "Nom VARCHAR(255) NOT NULL, "
		         + "Type VARCHAR(255) NOT NULL, "
		         + "p1X INT, "
		         + "p1Y INT, "
		         + "p2X INT, "
		         + "p2Y INT, "
		         + "p3X INT, "
		         + "p3Y INT, "
		         + "Rayon INT, "
		         + "Taille INT, "
		         + "PRIMARY KEY (Nom))";
		         stmt.execute(query);
		         System.out.println("Table formes créée");
		         String query2 = "CREATE TABLE groupes( "
				         + "NomGroupe VARCHAR(255) NOT NULL, "
				         + "NomForme VARCHAR(255) NOT NULL, "
				         + "PRIMARY KEY (NomGroupe,NomForme))";
				 stmt.execute(query2);
				 System.out.println("Table groupes créée");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			 
	     
	}

}
