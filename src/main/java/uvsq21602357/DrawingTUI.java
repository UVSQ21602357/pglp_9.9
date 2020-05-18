package uvsq21602357;

import java.util.Scanner;

public class DrawingTUI {
	public Scanner sc;
	
	public DrawingTUI() {
		this.sc = new Scanner(System.in);
	}
	
	private void nextCommand() {
		
		//Création
		System.out.print("Commande = ");
		String str = sc.nextLine();
		while(str.equals("Fin") == false) {
			
			if(str.equals("Create") || str.equals("create")) {
				str = sc.nextLine();
				String[] s = str.split("=");
				String[] s2 = s[1].split("\\(\\(");
				if(s2[0].equals("Cercle") || s2[0].equals("cercle")) {
					String[] s3 = s2[1].split("\\),");
					String[] s4 = s3[0].split(",");
					String[] s5 = s3[1].split("\\)");
					/*System.out.println("s = " + s[0]);
					System.out.println("s2 = " + s2[0]);
					System.out.println("s4[0] = " + s4[0]);
					System.out.println("s4[1] = " + s4[1]);
					System.out.println("s5 = " + s5[0]);*/
				}
				else if(s2[0].equals("Rectangle") || s2[0].equals("rectangle")) {
					String[] s3 = s2[1].split("\\),\\(");
					String[] s4 = s3[0].split(",");
					String[] s5 = s3[1].split(",");
					String[] s6 = s5[1].split("\\)");
					System.out.println("s2 = " + s2[0]);
					System.out.println("s4[0] = " + s4[0]);
					System.out.println("s4[1] = " + s4[1]);
					System.out.println("s5 = " + s5[0]);
					System.out.println("s6 = " + s6[0]);
					//c1=Rectangle((0,0),(10,15))
				}
				else if(s2[0].equals("Carré") || s2[0].equals("carré")) {
					String[] s3 = s2[1].split("\\),\\(");
					String[] s4 = s3[0].split(",");
					String[] s5 = s3[1].split(",");
					String[] s6 = s5[1].split("\\)");
					System.out.println("s2 = " + s2[0]);
					System.out.println("s4[0] = " + s4[0]);
					System.out.println("s4[1] = " + s4[1]);
					System.out.println("s5 = " + s5[0]);
					System.out.println("s6 = " + s6[0]);
				}
				else if(s2[0].equals("Triangle") || s2[0].equals("triangle")) {
					//T1=triangle((0,0),(10,10),(15,25))
					String[] s3 = s2[1].split("\\),\\(");
					String[] s4 = s3[0].split(",");
					String[] s5 = s3[1].split(",");
					String[] s6 = s5[1].split("\\),\\(");
					String[] s7 = s3[2].split(",");
					String[] s8 = s7[1].split("\\)");
					System.out.println("s2 = " + s2[0]);
					System.out.println("s4[0] = " + s4[0]);
					System.out.println("s4[1] = " + s4[1]);
					System.out.println("s5 = " + s5[0]);
					System.out.println("s6 = " + s6[0]);
					System.out.println("s7 = " + s7[0]);
					System.out.println("s8 = " + s8[0]);
				}
			}
			else {
				String[] s = str.split("\\(");
				if(s[0].equals("move") || s[0].equals("Move")) {
					String[] s2 = s[1].split(",");
					String[] s3 = s[2].split(",");
					String[] s4 = s3[1].split("\\)\\)");
					System.out.println(s[0]);
					System.out.println(s2[0]);
					System.out.println("S3="+s3[0]);
					System.out.println(s4[0]);
				}
				else if(s[0].equals("Delete") || s[0].equals("delete")) {
					String[] s2 = s[1].split("\\)");
					System.out.println(s[0]);
					System.out.println(s2[0]);
				}
				else if(s[0].equals("Group") || s[0].equals("group")) {
					String[] s2 = s[1].split(",");
					String[] s3 = s2[1].split("\\)");
					System.out.println(s[0]);
					System.out.println(s2[0]);
					System.out.println(s3[0]);
				}
				else if(s[0].equals("show") || s[0].equals("Show")) {
					System.out.println("Dessin: ");
				}
				else {
					System.out.println("Erreur, la commande n'est pas reconnu");
				}
			}


			
			
			System.out.print("Commande = ");
			str = sc.nextLine();
		}
	}
	
	public static void main(String[] args) {
		DrawingTUI d = new DrawingTUI();
		d.nextCommand();
	}
}
