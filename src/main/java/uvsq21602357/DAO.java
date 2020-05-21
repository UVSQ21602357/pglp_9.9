package uvsq21602357;

import java.sql.Connection;

public abstract class DAO<T> {
	protected Connection connect = null;

	public DAO(Connection conn){
	 this.connect = conn;
	}
	
	public abstract void create(Cercle C);
	public abstract void create(Rectangle R);
	public abstract void create(Carré C);
	public abstract void create(Triangle T);
	
	public abstract T find(String Nom);
	
	public abstract void update(String Nom, int x, int y);
	
	public abstract void delete(String Nom);
	


}
