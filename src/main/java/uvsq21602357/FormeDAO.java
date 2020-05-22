package uvsq21602357;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FormeDAO extends DAO<Forme> {

	 public FormeDAO(Connection conn) {
		    super(conn);
		  }
	
	@Override
	public void create(Cercle c) {
		try {
			PreparedStatement prepare = connect.prepareStatement(
					"INSERT INTO formes (Type, Nom, p1X, p1Y, Rayon) VALUES (?,?,?,?,?)");
			prepare.setString(1, "Cercle");
			prepare.setString(2, c.getNom());
			prepare.setInt(3, c.getCentreX());
			prepare.setInt(4, c.getCentreY());
			prepare.setInt(5, c.getRayon());
			int result = prepare.executeUpdate();
			System.out.println("Creation de "+c.getNom());
			assert result == 1;
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void create(Rectangle R) {
		try {
			PreparedStatement prepare = connect.prepareStatement(
					"INSERT INTO formes (Type, Nom, p1X, p1Y, p2X, p2Y) VALUES (?,?,?,?,?,?)");
			prepare.setString(1, "Rectangle");
			prepare.setString(2, R.getNom());
			prepare.setInt(3, R.getHGX());
			prepare.setInt(4, R.getHGY());
			prepare.setInt(5, R.getBDX());
			prepare.setInt(6, R.getBDY());
			int result = prepare.executeUpdate();
			System.out.println("Creation de "+R.getNom());
			assert result == 1;
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void create(Carré c) {
		try {
			PreparedStatement prepare = connect.prepareStatement(
					"INSERT INTO formes (Type, Nom, p1X, p1Y, Taille) VALUES (?,?,?,?,?)");
			prepare.setString(1, "Carré");
			prepare.setString(2, c.getNom());
			prepare.setInt(3, c.getHGX());
			prepare.setInt(4, c.getHGY());
			prepare.setInt(5, c.getTaille());
			int result = prepare.executeUpdate();
			System.out.println("Creation de "+c.getNom());
			assert result == 1;
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void create(Triangle t) {
		try {
			PreparedStatement prepare = connect.prepareStatement(
					"INSERT INTO formes (Type, Nom, p1X, p1Y, p2X, p2Y, p3X, p3Y) VALUES (?,?,?,?,?,?,?,?)");
			prepare.setString(1, "Triangle");
			prepare.setString(2, t.getNom());
			prepare.setInt(3, t.getP1X());
			prepare.setInt(4, t.getP1Y());
			prepare.setInt(5, t.getP2X());
			prepare.setInt(6, t.getP2Y());
			prepare.setInt(7, t.getP3X());
			prepare.setInt(8, t.getP3Y());
			int result = prepare.executeUpdate();
			System.out.println("Creation de "+t.getNom());
			assert result == 1;
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public Forme find(String Nom) {
		Forme f = null;
		try {
			PreparedStatement prepare = connect.prepareStatement(
					"SELECT * FROM formes WHERE nom = ? ");
			prepare.setString(1,  Nom);
			ResultSet result = prepare.executeQuery();
			while(result.next()) {
				if(result.getString("Type").equals("Cercle")) {
					f = new Cercle(
							result.getString("Nom"),
							result.getInt("p1X"),
							result.getInt("p1Y"),
							result.getInt("Rayon"));
					System.out.println("Forme = "+result.getString("Type")+", Nom = "+result.getString("Nom")+ " (("+ result.getInt("p1X") +", " + result.getInt("p1Y") +
							"), "+result.getInt("Rayon")+")");
				}
				else if(result.getString("Type").equals("Rectangle")) {
					f = new Rectangle(
							result.getString("Nom"),
							result.getInt("p1X"),
							result.getInt("p1Y"),
							result.getInt("p2X"),
							result.getInt("p2Y"));
					System.out.println("Forme = "+result.getString("Type")+", Nom = "+result.getString("Nom")+ " (("+ result.getInt("p1X") +", " + result.getInt("p1Y") +
							"),("+result.getInt("p2X")+", "+result.getInt("p2Y")+"))");
				}
				else if(result.getString("Type").equals("Carré")) {
					f = new Carré(
							result.getString("Nom"),
							result.getInt("p1X"),
							result.getInt("p1Y"),
							result.getInt("Taille"));
					System.out.println("Forme = "+result.getString("Type")+", Nom = "+result.getString("Nom")+ " (("+ result.getInt("p1X") +", " + result.getInt("p1Y") +
							"), "+result.getInt("Taille")+")");
				}
				else if(result.getString("Type").equals("Triangle")) {
					f = new Triangle(
							result.getString("Nom"),
							result.getInt("p1X"),
							result.getInt("p1Y"),
							result.getInt("p2X"),
							result.getInt("p2Y"),
							result.getInt("p3X"),
							result.getInt("p3Y"));
					System.out.println("Forme = "+result.getString("Type")+", Nom = "+result.getString("Nom")+ " (("+ result.getInt("p1X") +", " + result.getInt("p1Y") +
							"),( "+result.getInt("p2X")+", "+result.getInt("p2Y")+"),(" + result.getInt("p2X")+", "+result.getInt("p2Y")+"))" );
				}		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return f;
	}

	@Override
	public void update(String Nom, int x, int y) {
		try {
			PreparedStatement prepare = connect.prepareStatement(
					"SELECT * FROM formes WHERE nom = ? ");
			prepare.setString(1,  Nom);
			ResultSet result = prepare.executeQuery();
			if(result.next()) {
				if(result.getString("Type").equals("Cercle")) {
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
				else if(result.getString("Type").equals("Rectangle")) {
					int i = result.getInt("p1X");
					int j = result.getInt("p1Y");
					i = i + x;
					j = j + y;
					PreparedStatement prepare2 = connect.prepareStatement(
							"UPDATE places SET p1X = ?, p1Y = ? WHERE Nom = ?");
					prepare2.setInt(1, i);
					prepare2.setInt(2, j);
					prepare2.setString(3, Nom);
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
					i = i + x;
					j = j + y;
					PreparedStatement prepare2 = connect.prepareStatement(
							"UPDATE places SET p1X = ?, p1Y = ? WHERE Nom = ?");
					prepare2.setInt(1, i);
					prepare2.setInt(2, j);
					prepare2.setString(3, Nom);
					prepare2.executeUpdate();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public void delete(String Nom) {
		try {
			PreparedStatement prepare = connect.prepareStatement(
					"DELETE FROM formes WHERE nom = ? ");
			prepare.setString(1, Nom);
			prepare.executeUpdate();
			System.out.println(Nom + " supprimer");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
