package uvsq21602357;

import java.sql.SQLException;

public class DrawingApp {
	public DrawingApp() {
		System.out.println("Début du dessin");
	}
	
	public void run() throws ClassNotFoundException, SQLException {
		DrawingTUI d = new DrawingTUI();
		JDBC j = new JDBC();
		j.CreateTable();
		while(true) {
			Command c = d.nextCommand(j.conn);
			c.execute();
		}		
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DrawingApp da = new DrawingApp();
		da.run();
	}
}
