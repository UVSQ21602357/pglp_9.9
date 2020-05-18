package uvsq21602357;

import java.util.Scanner;

public class DrawingTUI {
	public Scanner sc;
	
	public DrawingTUI() {
		this.sc = new Scanner(System.in);
	}
	
	private void nextCommand() {
		System.out.print("Commande = ");
		String str = sc.nextLine();
		while(str.equals("Fin") == false) {
			
			String[] s = str.split("=");
			String[] s2 = s[1].split("\\(\\(");
			String[] s3 = s2[1].split("\\);");
			String[] s4 = s3[0].split(",");
			//String[] s5 = s3[1].split("\\)");
			System.out.println("s = " + s[0]);
			System.out.println("s2 = " + s2[0]);
			System.out.println("s4[0] = " + s4[0]);
			System.out.println("s4[1] = " + s4[1]);
			System.out.println("s3[1] = " + s3[1]);
			//System.out.println("s5 = " + s5[0]);
			System.out.print("Commande = ");
			str = sc.nextLine();
		}
	}
	
	public static void main(String[] args) {
		DrawingTUI d = new DrawingTUI();
		d.nextCommand();
	}
}
