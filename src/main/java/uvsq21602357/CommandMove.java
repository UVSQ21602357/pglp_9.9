package uvsq21602357;

import java.sql.Connection;

public class CommandMove implements Command{
	private Connection conn;
	private String Nom;
    int i;
    int j;
    
        CommandMove(Connection connection, String str, int x, int y){
            this.conn = connection;
            this.Nom = str;
            this.i = x;
            this.j = y;
        }
        
        public void execute() {
        	FormeDAO FD = new FormeDAO(conn);
            Forme test = FD.find(Nom);
            	if(test != null) {
               	 FD.update(Nom, i, j);
                }
            System.out.println("Forme déplacé");
        }
}
