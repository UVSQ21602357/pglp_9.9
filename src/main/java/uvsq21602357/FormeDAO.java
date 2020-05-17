package uvsq21602357;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FormeDAO extends DAO<Forme> {

	@Override
	public Forme create(Cercle c) {
		try {
			PreparedStatement prepare = connect.prepareStatement(
					"INSERT INTO formes (Type, Nom, CentreX, CentreY, Rayon) VALUES (?,?,?,?,?)");
			prepare.setString(1, "Cercle");
			prepare.setString(2, c.getNom());
			prepare.setInt(3, c.getCentreX());
			prepare.setInt(4, c.getCentreY());
			prepare.setInt(5, c.getRayon());
			int result = prepare.executeUpdate();
			assert result == 1;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	@Override
	public Forme create(Rectangle R) {
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
			assert result == 1;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return R;
	}
	
	@Override
	public Forme create(Carré c) {
		try {
			PreparedStatement prepare = connect.prepareStatement(
					"INSERT INTO formes (Type, Nom, p1X, p1Y, Taille) VALUES (?,?,?,?,?)");
			prepare.setString(1, "Carré");
			prepare.setString(2, c.getNom());
			prepare.setInt(3, c.getHGX());
			prepare.setInt(4, c.getHGY());
			prepare.setInt(5, c.getTaille());
			int result = prepare.executeUpdate();
			assert result == 1;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	@Override
	public Forme create(Triangle t) {
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
			assert result == 1;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return t;
	}
	

	@Override
	public Forme find(String Nom) {
		Forme f;
		try {
			PreparedStatement prepare = connect.prepareStatement(
					"SELECT * FROM formes WHERE nom = ? ");
			prepare.setString(1,  Nom);
			ResultSet result = prepare.executeQuery();
			if(result.first()) {
				if(result.getString("Type").equals("Cercle")) {
					f = new Cercle(
							result.getString("Nom"),
							result.getInt("CentreX"),
							result.getInt("CentreY"),
							result.getInt("Rayon"));
							
				}
				else if(result.getString("Type").equals("Rectangle")) {
					f = new Rectangle(
							result.getString("Nom"),
							result.getInt("p1X"),
							result.getInt("p1Y"),
							result.getInt("p2X"),
							result.getInt("p2Y"));
				}
				else if(result.getString("Type").equals("Carré")) {
					f = new Carré(
							result.getString("Nom"),
							result.getInt("p1X"),
							result.getInt("p1Y"),
							result.getInt("Taille"));
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
				}		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return f;
	}

	@Override
	public Forme update(Forme obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Forme obj) {
		try {
			PreparedStatement prepare = connect.prepareStatement(
					"DELETE FROM formes WHERE nom = ? ");
			prepare.setString(1,  obj.getNom());
			ResultSet result = prepare.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return f;

	}

}
