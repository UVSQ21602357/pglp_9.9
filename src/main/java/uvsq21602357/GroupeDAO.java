package uvsq21602357;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupeDAO extends DAO2 {

	 public GroupeDAO(Connection conn) {
		    super(conn);
		  }

	 @Override
		public void create(String g, String f) {
			try {
				PreparedStatement prepare = connect.prepareStatement(
						"INSERT INTO groupes (NomGroupe, NomForme) VALUES (?,?)");
				prepare.setString(1, g);
				prepare.setString(2, f);
				int result = prepare.executeUpdate();
				System.out.println("Ajout de "+f+"dans le groupe "+g);
				assert result == 1;
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	 
	 @Override
		public boolean find(String Nom, String str) {
			Forme f = null;
			try {
				PreparedStatement prepare = connect.prepareStatement(
						"SELECT * FROM groupes WHERE NomGroupe = ? AND NomForme = ?");
				prepare.setString(1,  Nom);
				prepare.setString(2, str);
				ResultSet result = prepare.executeQuery();
				while(result.next()) {
					return true;
					}	
				}catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}

	 
	 @Override
	 	public void update(String Nom, int x, int y) {
		 Forme f;
			PreparedStatement prepare;
			try {
				prepare = connect.prepareStatement(
						"SELECT NomGroupe, NomForme FROM groupes WHERE NomGroupe = ?");
			prepare.setString(1,  Nom);
			ResultSet result = prepare.executeQuery();
			
			while(result.next()) {
				PreparedStatement prepare3 = connect.prepareStatement(
							"SELECT * FROM formes WHERE Nom = ?");
				prepare3.setString(1,  result.getString("NomForme"));
				ResultSet result2 = prepare3.executeQuery();
				if(result2.next()) {
					if(result2.getString("Type").equals("Cercle")) {
						int i = result2.getInt("p1X");
						int j = result2.getInt("p1Y");
						i = i + x;
						j = j + y;
						PreparedStatement prepare2 = connect.prepareStatement(
								"UPDATE formes SET p1X = ?, p1Y = ?WHERE Nom = ?");
						prepare2.setInt(1, i);
						prepare2.setInt(2, j);
						prepare2.setString(3, result.getString("NomForme"));
						prepare2.executeUpdate();
						
					}
					else if(result2.getString("Type").equals("Rectangle")) {
						int i = result2.getInt("p1X");
						int j = result2.getInt("p1Y");
						int k = result2.getInt("p2X");
						int l = result2.getInt("p2Y");
						i = i + x;
						j = j + y;
						k = k + x;
						l = l + y;
						PreparedStatement prepare2 = connect.prepareStatement(
								"UPDATE formes SET p1X = ?, p1Y = ?,p2X = ?, p2Y = ? WHERE Nom = ?");
						prepare2.setInt(1, i);
						prepare2.setInt(2, j);
						prepare2.setInt(3, k);
						prepare2.setInt(4, l);
						prepare2.setString(5, result.getString("NomForme"));
						prepare2.executeUpdate();
					}
					else if(result2.getString("Type").equals("Carré")) {
						int i = result2.getInt("p1X");
						int j = result2.getInt("p1Y");
						i = i + x;
						j = j + y;
						PreparedStatement prepare2 = connect.prepareStatement(
								"UPDATE formes SET p1X = ?, p1Y = ? WHERE Nom = ?");
						prepare2.setInt(1, i);
						prepare2.setInt(2, j);
						prepare2.setString(3, result.getString("NomForme"));
						prepare2.executeUpdate();
					}
					else if(result2.getString("Type").equals("Triangle")) {
						int i = result2.getInt("p1X");
						int j = result2.getInt("p1Y");
						int k = result2.getInt("p2X");
						int l = result2.getInt("p2Y");
						int m = result2.getInt("p3X");
						int n = result2.getInt("p3Y");
						i = i + x;
						j = j + y;
						k = k + x;
						l = l + y;
						m = m + x;
						n = n + y;
						PreparedStatement prepare2 = connect.prepareStatement(
								"UPDATE formes SET p1X = ?, p1Y = ?, p2X = ?, p2Y = ?, p3X = ?, p3Y = ? WHERE Nom = ?");
						prepare2.setInt(1, i);
						prepare2.setInt(2, j);
						prepare2.setInt(3, k);
						prepare2.setInt(4, l);
						prepare2.setInt(5, m);
						prepare2.setInt(6, n);
						prepare2.setString(7, result.getString("NomForme"));
						prepare2.executeUpdate();
					}
				}
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	 
	 
	 public void delete(String Nom) {
		 try {
				PreparedStatement prepare = connect.prepareStatement(
						"DELETE FROM groupes WHERE NomGroupe = ? ");
				prepare.setString(1, Nom);
				prepare.executeUpdate();
				System.out.println(Nom + " supprimé");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	 }
	 
	 }
