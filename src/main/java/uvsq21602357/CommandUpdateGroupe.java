package uvsq21602357;

import java.sql.Connection;

public class CommandUpdateGroupe implements Command{
	private Connection conn;
	private String NomG;
	private int x;
	private int y;
	
	public CommandUpdateGroupe(Connection connection, String str, int a, int b){
        this.conn = connection;
        this.NomG = str;
        this.x = a;
        this.y = b;
    }
    
   
    
	public void execute() {
		GroupeDAO GD = new GroupeDAO(conn);
		GD.update(NomG, x, y);
	}
}
