package uvsq21602357;

import java.sql.Connection;

public class CommandFin implements Command{
	
	public CommandFin() {
		
	}
	
	public void execute() {
		System.out.println("Fin du programme");
		System.exit(0);
	}
}