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
		public void find(String Nom) {
			Forme f = null;
			try {
				PreparedStatement prepare = connect.prepareStatement(
						"SELECT * FROM groupes WHERE nom = ? ");
				prepare.setString(1,  Nom);
				ResultSet result = prepare.executeQuery();
				while(result.next()) {
					System.out.println("Le groupe existe");
					}	
				}catch (SQLException e) {
				e.printStackTrace();
			}
		}

	 
	 @Override
	 	public void update(String Nom, int x, int y) {
		 Forme f;
			PreparedStatement prepare;
			try {
				prepare = connect.prepareStatement(
						"SELECT * FROM groupes WHERE NomGroupe = ?");
			prepare.setString(1,  Nom);
			ResultSet result = prepare.executeQuery();
			while(result.next()) {
				if(result.getString("Type").equals("Cercle")) {
					int i = result.getInt("p1X");
					int j = result.getInt("p1Y");
					i = i + x;
					j = j + y;PreparedStatement prepare2 = connect.prepareStatement(
							"UPDATE formes SET p1X = ?, p1Y = ?WHERE Nom = ?");
					prepare2.setInt(1, i);
					prepare2.setInt(2, j);
					prepare2.setString(3, Nom);
					prepare2.executeUpdate();
					
				}
				else if(result.getString("Type").equals("Rectangle")) {
					int i = result.getInt("p1X");
					int j = result.getInt("p1Y");
					int k = result.getInt("p2X");
					int l = result.getInt("p2Y");
					i = i + x;
					j = j + y;
					k = k + x;
					l = l + y;
					PreparedStatement prepare2 = connect.prepareStatement(
							"UPDATE places SET p1X = ?, p1Y = ?,p2X = ?, p2Y = ? WHERE Nom = ?");
					prepare2.setInt(1, i);
					prepare2.setInt(2, j);
					prepare2.setInt(3, k);
					prepare2.setInt(4, l);
					prepare2.setString(5, Nom);
					prepare2.executeUpdate();
				}
				else if(result.getString("Type").equals("Carré")) {
					int i = result.getInt("p1X");
					int j = result.getInt("p1Y");
					i = i + x;
					j = j + y;
					PreparedStatement prepare2 = connect.prepareStatement(
							"UPDATE places SET p1X = ?, p1eY = ? WHERE Nom = ?");
					prepare2.setInt(1, i);
					prepare2.setInt(2, j);
					prepare2.setString(3, Nom);
					prepare2.executeUpdate();
				}
				else if(result.getString("Type").equals("Triangle")) {
					int i = result.getInt("p1X");
					int j = result.getInt("p1Y");
					int k = result.getInt("p2X");
					int l = result.getInt("p2Y");
					int m = result.getInt("p3X");
					int n = result.getInt("p3Y");
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
					prepare2.setString(7, Nom);
					prepare2.executeUpdate();
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
				System.out.println(Nom + " supprimer");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	 }
	 
	 }
