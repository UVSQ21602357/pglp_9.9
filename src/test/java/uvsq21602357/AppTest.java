package uvsq21602357;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class AppTest
{
    @Test
    public void testCercle(){
    	Cercle c1 = new Cercle("C1", 0, 0, 50);
    	String str = c1.getNom();
        assertEquals(str, "C1");
    }
    
    @Test
    public void testRectangle(){
    	Rectangle r1 = new Rectangle("R1", 0, 0, 50, 50);
    	String str = r1.getNom();
        assertEquals(str, "R1");
    }
    
    @Test
    public void testTriangle(){
    	Triangle t1 = new Triangle("T1", 0, 0, 50, 50, 70, 25);
    	String str = t1.getNom();
        assertEquals(str, "T1");
    }
    
    @Test
    public void testCarré(){
    	Carré c1 = new Carré("C1", 0, 0, 50, 50);
    	String str = c1.getNom();
        assertEquals(str, "C1");
    }
}