package uvsq21602357;

public class Carré implements Forme{
	private String Nom;
	private int HGX;
	private int HGY;
	private int BDX;
	private int BDY;
	
	public Carré(String nom, int x, int y, int x2, int y2) {
		this.Nom = nom;
		this.HGX = x;
		this.HGY = y;
		this.BDX = x2;
		this.BDY = y2;
	}
	
	public String getNom() {
		return this.Nom;
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
		System.out.println("Carré(P1=("+ HGX + "," + HGY + "),P2=(" + BDX +","+BDY+ "))");
	}
}
