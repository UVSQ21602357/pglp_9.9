package uvsq21602357;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FormeDAO extends DAO<Forme> {

	@Override
	public Forme create(Cercle c) {
		try {
			PreparedStatement prepare = connect.prepareStatement(
					"INSERT INTO formes (Nom, CentreX, CentreY, Rayon) VALUES (?,?,?,?)");
			prepare.setString(1, c.getNom());
			prepare.setInt(2, c.getCentreX());
			prepare.setInt(3, c.getCentreY());
			prepare.setInt(4, c.getRayon());
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
					"INSERT INTO formes (Nom, p1X, p1Y, p2X, p2Y) VALUES (?,?,?,?,?)");
			prepare.setString(1, R.getNom());
			prepare.setInt(2, R.getHGX());
			prepare.setInt(3, R.getHGY());
			prepare.setInt(4, R.getBDX());
			prepare.setInt(5, R.getBDY());
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
					"INSERT INTO formes (Nom, p1X, p1Y, p2X, p2Y) VALUES (?,?,?,?,?)");
			prepare.setString(1, c.getNom());
			prepare.setInt(2, c.getHGX());
			prepare.setInt(3, c.getHGY());
			prepare.setInt(4, c.getBDX());
			prepare.setInt(5, c.getBDY());
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
					"INSERT INTO formes (Nom, p1X, p1Y, p2X, p2Y, p3X, p3Y) VALUES (?,?,?,?,?,?,?)");
			prepare.setString(1, t.getNom());
			prepare.setInt(2, t.getP1X());
			prepare.setInt(3, t.getP1Y());
			prepare.setInt(4, t.getP2X());
			prepare.setInt(5, t.getP2Y());
			prepare.setInt(6, t.getP3X());
			prepare.setInt(7, t.getP3Y());
			int result = prepare.executeUpdate();
			assert result == 1;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return t;
	}
	

	@Override
	public Forme find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Forme update(Forme obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Forme obj) {
		// TODO Auto-generated method stub
		
	}

}
