package uvsq21602357;

public class Cercle implements Forme {
	private String Nom;
	private int Rayon;
	private int CentreX;
	private int CentreY;
	public String Groupe;
	
	public Cercle(String nom, int x, int y, int rayon) {
		this.Nom = nom;
		this.CentreX = x;
		this.CentreY = y;
		this.Rayon = rayon;
	}
	
	public String getNom() {
		return this.Nom;
	}
	
	public String getType() {
		return "Cercle";
	}
	
	public void setGroupe(String str) {
		this.Groupe = str;
	}
	
	public String getGroupe() {
		return this.Groupe;
	}
	
	public int getRayon() {
		return this.Rayon;
	}
	
	public int getCentreX() {
		return this.CentreX;
	}
	
	public int getCentreY() {
		return this.CentreY;
	}
	
	public void print() {
		System.out.println("Cercle(centre=("+ CentreX + "," + CentreY + "),Rayon=" + Rayon + ")");
	}
}
