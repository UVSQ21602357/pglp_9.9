package uvsq21602357;

public class Carré extends Forme{
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
}
