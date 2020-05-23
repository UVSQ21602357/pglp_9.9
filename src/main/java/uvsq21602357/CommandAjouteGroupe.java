package uvsq21602357;

import java.sql.Connection;

public class CommandAjouteGroupe implements Command {
	private Connection conn;
    private String NomG;
    private String NomF;
    
    	public CommandAjouteGroupe(Connection connection, String str, String s){
            this.conn = connection;
            this.NomG = str;
            this.NomF = s;
        }
        
       
        
    public void execute() {
    	GroupeDAO GD = new GroupeDAO(conn);
    	boolean test = GD.find(NomG, NomF);
    	if(test == false) {
    		GD.create(NomG, NomF);
    	}
    }

}
