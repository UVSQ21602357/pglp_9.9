package uvsq21602357;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class DrawingTUI {
	public Scanner sc;
	
	public DrawingTUI() {
		this.sc = new Scanner(System.in);
	}
	
	private void AfficheAll(Connection conn) throws SQLException {
		 
		  PreparedStatement prepare = conn.prepareStatement("SELECT * FROM formes");
		  ResultSet result = prepare.executeQuery();
		  ResultSetMetaData resultMeta = result.getMetaData();
		  Forme f;
		  while(result.next()){        

			  System.out.println("On y est");
		        	if(result.getString("Type").equals("Cercle")) {
						f = new Cercle(
								result.getString("Nom"),
								result.getInt("p1X"),
								result.getInt("p1Y"),
								result.getInt("Rayon"));
						System.out.println("Forme = "+result.getString("Type")+", Nom = "+result.getString("Nom")+ " ("+ result.getInt("p1X") +", " + result.getInt("p1Y") +
											"), "+result.getInt("Rayon")+")");
								
					}
					else if(result.getString("Type").equals("Rectangle")) {
						f = new Rectangle(
								result.getString("Nom"),
								result.getInt("p1X"),
								result.getInt("p1Y"),
								result.getInt("p2X"),
								result.getInt("p2Y"));
						System.out.println("Forme = "+result.getString("Type")+", Nom = "+result.getString("Nom")+ " ("+ result.getInt("p1X") +", " + result.getInt("p1Y") +
								"), ( "+result.getInt("p2X")+", "+ result.getInt("p2Y") +" ))" );
					}
					else if(result.getString("Type").equals("Carré")) {
						f = new Carré(
								result.getString("Nom"),
								result.getInt("p1X"),
								result.getInt("p1Y"),
								result.getInt("Taille"));
						System.out.println("Forme = "+result.getString("Type")+", Nom = "+result.getString("Nom")+ " ("+ result.getInt("p1X") +", " + result.getInt("p1Y") +
								"), taille = "+result.getInt("p2X")+")" );
					}
					else if(result.getString("Type").equals("Triangle")) {
						f = new Triangle(
								result.getString("Nom"),
								result.getInt("p1X"),
								result.getInt("p1Y"),
								result.getInt("p2X"),
								result.getInt("p2Y"),
								result.getInt("p3X"),
								result.getInt("p3Y"));
						System.out.println("Forme = "+result.getString("Type")+", Nom = "+result.getString("Nom")+ " ("+ result.getInt("p1X") +", " + result.getInt("p1Y") +
								"), ( "+result.getInt("p2X")+", "+ result.getInt("p2Y") +" ),( "+ result.getInt("p3X")+", "+ result.getInt("p3Y")+"))");
					}				
		            
		        System.out.println("\n---------------------------------");

		      }
				
		System.out.println("Affichage du dessin");
	}
	
	Command nextCommand(Connection conn) throws SQLException, ClassNotFoundException {
		
		//Création
		System.out.print("Commande = ");
		String str = sc.nextLine();
			if(str.equals("Fin") || str.equals("fin")) {
				CommandFin c = new CommandFin();
				return c;
			}
			
			if(str.equals("Create") || str.equals("create")) {
				str = sc.nextLine();
				String[] s = str.split("=");
				String[] s2 = s[1].split("\\(\\(");
				if(s2[0].equals("Cercle") || s2[0].equals("cercle")) {
					String[] s3 = s2[1].split("\\),");
					String[] s4 = s3[0].split(",");
					String[] s5 = s3[1].split("\\)");
					int x = Integer.parseInt(s4[0]);
					int y = Integer.parseInt(s4[1]);
					int z = Integer.parseInt(s5[0]);
					Cercle c = new Cercle(s[0], x, y, z);
					CommandCreer com = new CommandCreer(conn, c);
					return com;
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
					/*System.out.println("s2 = " + s2[0]);
					System.out.println("s4[0] = " + s4[0]);
					System.out.println("s4[1] = " + s4[1]);
					System.out.println("s5 = " + s5[0]);
					System.out.println("s6 = " + s6[0]);*/
					int x = Integer.parseInt(s4[0]);
					int y = Integer.parseInt(s4[1]);
					int z = Integer.parseInt(s5[0]);
					int t = Integer.parseInt(s6[0]);
					Rectangle R = new Rectangle(s[0], x, y, z, t);
					CommandCreer com = new CommandCreer(conn, R);
					return com;
				}
				else if(s2[0].equals("Carré") || s2[0].equals("carré")) {
					String[] s3 = s2[1].split("\\),");
					String[] s4 = s3[0].split(",");
					String[] s5 = s3[1].split("\\)");
					// Carré((5,10), 12)
					/*System.out.println("s2 = " + s2[0]);
					System.out.println("s4[0] = " + s4[0]);
					System.out.println("s4[1] = " + s4[1]);
					System.out.println("s5 = " + s5[0]);*/
					int x = Integer.parseInt(s4[0]);
					int y = Integer.parseInt(s4[1]);
					int z = Integer.parseInt(s5[0]);
					Carré c = new Carré(s[0], x, y, z);
					CommandCreer com = new CommandCreer(conn, c);
					return com;
				}
				else if(s2[0].equals("Triangle") || s2[0].equals("triangle")) {
					String[] s3 = s2[1].split("\\),\\(");
					String[] s4 = s3[0].split(",");
					String[] s5 = s3[1].split(",");
					String[] s6 = s5[1].split("\\),\\(");
					String[] s7 = s3[2].split(",");
					String[] s8 = s7[1].split("\\)");
					/*System.out.println("s2 = " + s2[0]);
					System.out.println("s4[0] = " + s4[0]);
					System.out.println("s4[1] = " + s4[1]);
					System.out.println("s5 = " + s5[0]);
					System.out.println("s6 = " + s6[0]);
					System.out.println("s7 = " + s7[0]);
					System.out.println("s8 = " + s8[0]);*/
					int x = Integer.parseInt(s4[0]);
					int y = Integer.parseInt(s4[1]);
					int z = Integer.parseInt(s5[0]);
					int t = Integer.parseInt(s6[0]);
					int m = Integer.parseInt(s7[0]);
					int n = Integer.parseInt(s8[0]);
					Triangle T = new Triangle(s[0], x, y, z, t, m, n);
					CommandCreer com = new CommandCreer(conn, T);
					return com;
				}
			}
			else {
				String[] s = str.split("\\(");
				if(s[0].equals("move") || s[0].equals("Move")) {
					String[] s2 = s[1].split(",");
					String[] s3 = s2[2].split("\\)");
					System.out.println(s[0]);
					System.out.println(s2[0]);
					System.out.println(s2[1]);
					System.out.println(s3[0]);
					int x = Integer.parseInt(s2[1]);
					int y = Integer.parseInt(s3[0]);
					CommandMove com = new CommandMove(conn, s2[0], x, y);
					return com;
					
				}
				else if(s[0].equals("Delete") || s[0].equals("delete")) {
					String[] s2 = s[1].split("\\)");
					System.out.println(s[0]);
					System.out.println(s2[0]);
					CommandeDelete com = new CommandeDelete(conn, s2[0]);
					return com;
				}
				else if(s[0].equals("Group") || s[0].equals("group")) {
					String[] s2 = s[1].split(",");
					String[] s3 = s2[1].split("\\)");
					System.out.println(s[0]);
					System.out.println(s2[0]);
					System.out.println(s3[0]);
					return null;
				}
				else if(s[0].equals("show") || s[0].equals("Show")) {
					System.out.println("Dessin: ");
					AfficheAll(conn);
					return null;
				}
				else {
					System.out.println("Erreur, la commande n'est pas reconnu");
					return null;
				}
			}


			
			
			System.out.print("Commande = ");
			str = sc.nextLine();
			return null;
	}
}
