package uvsq21602357;

import java.sql.Connection;

public class CommandCreer implements Command {
	private Connection conn;
    private Cercle cercle;
    private Rectangle rect;
    private Carré carré;
    private Triangle triangle;
    
        CommandCreer(Connection connection, Cercle c){
            this.conn = connection;
            this.cercle = c;
        }
        
        CommandCreer(Connection connection, Rectangle r){
            this.conn = connection;
            this.rect = r;
        }
        
        CommandCreer(Connection connection, Carré c){
            this.conn = connection;
            this.carré = c;
        }
        
        CommandCreer(Connection connection, Triangle t){
            this.conn = connection;
            this.triangle = t;
        }
        
    public void execute() {
    	FormeDAO FD = new FormeDAO(conn);
        Forme f = null;
        if(cercle != null) {
        	Forme test = FD.find(this.cercle.getNom());
        	if(test != null) {
           	 FD.create(cercle);
            }
        }
        else if(rect != null) {
        	Forme test = FD.find(this.rect.getNom());
        	if(test != null) {
              	 FD.create(rect);
               }
        }
        else if(carré != null) {
        	Forme test = FD.find(this.carré.getNom());
        	if(test != null) {
              	 FD.create(carré);
               }
        }
        else if(triangle != null) {
        	Forme test = FD.find(this.triangle.getNom());
        	if(test != null) {
              	 FD.create(triangle);
               }
        }   
        System.out.println("Forme créer");
    }
}
