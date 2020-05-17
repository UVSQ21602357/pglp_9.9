package uvsq21602357;

import java.sql.Connection;

public abstract class DAO<T> {
	protected Connection connect = ;
	
	public abstract T create(Cercle C);
	public abstract T create(Rectangle R);
	public abstract T create(Carré C);
	public abstract T create(Triangle T);
	
	public abstract T find(String Nom);
	
	public abstract T update(T obj);
	
	public abstract void delete(T obj);


}
