package uvsq21602357;

import java.sql.Connection;

public class CommandFin implements Command{
	public JDBC j;
	public CommandFin(JDBC jd) {
		this.j = jd;
	}
	
	public void execute() {
		System.out.println("Fin du programme");
		DrawingTUI d = new DrawingTUI();
			if(d.SupprTable()) {
				j.Supprime();
			}
		System.exit(0);
	}
}