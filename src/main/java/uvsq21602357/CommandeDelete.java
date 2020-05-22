package uvsq21602357;

import java.sql.Connection;

public class CommandeDelete implements Command {
	private Connection conn;
    private String Nom;
    
    	public CommandeDelete(Connection connection, String str){
            this.conn = connection;
            this.Nom = str;
        }
        
       
        
    public void execute() {
    	FormeDAO FD = new FormeDAO(conn);
    	Forme test = FD.find(Nom);
        if(test != null) {
          	 FD.delete(Nom);
        }
        
        System.out.println("Forme supprimé");
    }
}
