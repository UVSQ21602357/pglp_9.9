package uvsq21602357;

import java.sql.Connection;

public abstract class DAO2{
	protected Connection connect = null;

	public DAO2(Connection conn){
	 this.connect = conn;
	}
	
	public abstract void create(String g, String f);
	
	public abstract void find(String Nom);
	
	public abstract void update(String Nom, int x, int y);
	
	public abstract void delete(String Nom);
	


}
