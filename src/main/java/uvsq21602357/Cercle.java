package uvsq21602357;

public class Cercle extends Forme {
	private int Rayon;
	private int CentreX;
	private int CentreY;
	
	public Cercle(String nom, int x, int y, int rayon) {
		this.Nom = nom;
		this.CentreX = x;
		this.CentreY = y;
		this.Rayon = rayon;
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
}
