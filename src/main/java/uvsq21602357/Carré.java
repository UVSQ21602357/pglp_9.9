package uvsq21602357;

public class Carré implements Forme{
	private String Nom;
	private int HGX;
	private int HGY;
	private int taille;
	public String Groupe;
	
	public Carré(String nom, int x, int y, int t) {
		this.Nom = nom;
		this.HGX = x;
		this.HGY = y;
		this.taille = t;
	}
	
	public String getNom() {
		return this.Nom;
	}
	
	public String getType() {
		return "Carré";
	}
	
	public void setGroupe(String str) {
		this.Groupe = str;
	}
	
	public String getGroupe() {
		return this.Groupe;
	}
	
	public int getHGX() {
		return this.HGX;
	}
	
	public int getHGY() {
		return this.HGY;
	}
	
	public int getTaille() {
		return this.taille;
	}
	
	public void print() {
		System.out.println("Carré(P1=("+ HGX + "," + HGY + "),taille=(" +taille+"))");
	}
}
