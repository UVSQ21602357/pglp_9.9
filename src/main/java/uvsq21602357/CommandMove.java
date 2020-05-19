package uvsq21602357;

import java.sql.Connection;

public class CommandMove {
	private Connection conn;
    private Cercle cercle;
    private Rectangle rect;
    private Carré carré;
    private Triangle triangle;
    int i;
    int j;
    
        CommandMove(Connection connection, Cercle c, int x, int y){
            this.conn = connection;
            this.cercle = c;
            this.i = x;
            this.j = y;
        }
        
        CommandMove(Connection connection, Rectangle r, int x, int y){
            this.conn = connection;
            this.rect = r;
            this.i = x;
            this.j = y;
        }
        
        CommandMove(Connection connection, Carré c, int x, int y){
            this.conn = connection;
            this.carré = c;
            this.i = x;
            this.j = y;
        }
        
        CommandMove(Connection connection, Triangle t, int x, int y){
            this.conn = connection;
            this.triangle = t;
            this.i = x;
            this.j = y;
        }
        
        public void execute() {
        	FormeDAO FD = new FormeDAO(conn);
            Forme f = null;
            if(cercle != null) {
            	Forme test = FD.find(this.cercle.getNom());
            	if(test != null) {
               	 FD.update(cercle, i, j);
                }
            }
            else if(rect != null) {
            	Forme test = FD.find(this.rect.getNom());
            	if(test != null) {
                  	 FD.update(rect, i, j);
                   }
            }
            else if(carré != null) {
            	Forme test = FD.find(this.carré.getNom());
            	if(test != null) {
                  	 FD.update(carré, i, j);
                   }
            }
            else if(triangle != null) {
            	Forme test = FD.find(this.triangle.getNom());
            	if(test != null) {
                  	 FD.update(triangle, i, j);
                   }
            }  
            System.out.println("Forme déplacé");
        }
}
