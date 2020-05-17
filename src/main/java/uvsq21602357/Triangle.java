package uvsq21602357;

public class Triangle implements Forme {
	private String Nom;
	private int p1X;
	private int p1Y;
	private int p2X;
	private int p2Y;
	private int p3X;
	private int p3Y;
	
	public Triangle(String nom, int x1, int y1, int x2, int y2, int x3, int y3) {
		this.Nom = nom;
		this.p1X = x1;
		this.p1Y = y1;
		this.p2X = x2;
		this.p2Y = y2;
		this.p3X = x3;
		this.p3Y = y3;
	}
	
	public String getNom() {
		return this.Nom;
	}
	
	public int getP1X() {
		return p1X;
	}
	
	public int getP1Y() {
		return p1Y;
	}
	
	public int getP2X() {
		return p2X;
	}
	
	public int getP2Y() {
		return p2Y;
	}
	
	public int getP3X() {
		return p3X;
	}
	
	public int getP3Y() {
		return p3Y;
	}
	
	public void print() {
		System.out.println("Triangle(P1=("+ p1X + "," + p1Y + "),P2=(" + p2X +","+p2Y+ ",p3=("+p3X+","+p3Y+"))");
	}
}
