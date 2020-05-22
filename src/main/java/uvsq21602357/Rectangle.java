package uvsq21602357;

public class Rectangle implements Forme {
	private String Nom;
	private int HGX;
	private int HGY;
	private int BDX;
	private int BDY;
	public String Groupe;
	
	public Rectangle(String nom, int x, int y, int x2, int y2) {
		this.Nom = nom;
		this.HGX = x;
		this.HGY = y;
		this.BDX = x2;
		this.BDY = y2;
	}
	
	public String getNom() {
		return this.Nom;
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
	
	public int getBDX() {
		return this.BDX;
	}
	
	public int getBDY() {
		return this.BDY;
	}
	
	public void print() {
		System.out.println("Rectangle(P1=("+ HGX + "," + HGY + "),P2=(" + BDX +","+BDY+ "))");
	}
}
