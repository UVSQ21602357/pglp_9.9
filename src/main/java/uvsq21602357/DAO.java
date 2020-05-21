package uvsq21602357;

import java.sql.Connection;

public abstract class DAO<T> {
	protected Connection connect = null;

	public DAO(Connection conn){
	 this.connect = conn;
	}
	
	public abstract T create(Cercle C);
	public abstract T create(Rectangle R);
	public abstract T create(Carré C);
	public abstract T create(Triangle T);
	
	public abstract T find(String Nom);
	
	public abstract void update(String Nom, int x, int y);
	
	public abstract void delete(String Nom);
	


}
