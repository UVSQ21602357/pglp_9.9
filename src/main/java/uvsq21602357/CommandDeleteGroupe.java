package uvsq21602357;

import java.sql.Connection;

public class CommandDeleteGroupe implements Command {
	private String Nom;
	private Connection conn;
	
	public CommandDeleteGroupe(Connection connection, String str){
        this.conn = connection;
        this.Nom = str;
    }
    
   
    
public void execute() {
	GroupeDAO GD = new GroupeDAO(conn);
	GD.delete(Nom);
}

}
