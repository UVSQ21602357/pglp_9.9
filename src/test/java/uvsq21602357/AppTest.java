package uvsq21602357;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;

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
    
    @Test
    public void testComposite() {
    	Carré c1 = new Carré("C1", 0, 0, 50, 50);
    	Triangle t1 = new Triangle("T1", 0, 0, 50, 50, 70, 25);
    	Rectangle r1 = new Rectangle("R1", 0, 0, 50, 50);
    	Cercle ce1 = new Cercle("C1", 0, 0, 50);
    	Forme f1;
    	Forme f2;
    	Forme f3;
    	
    	FormeComposite fc1 = new FormeComposite();
    	FormeComposite fc2 = new FormeComposite();
    	
    	fc1.add(c1);
    	fc1.add(t1);
    	fc1.add(r1);
    	fc2.add(ce1);
    	
    	List<Forme> f = new ArrayList<Forme>();
		f.add(c1);
		f.add(t1);
		f.add(r1);
		assertEquals(fc1.getAllForme(),f);
    }
}