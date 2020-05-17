package uvsq21602357;

import java.util.ArrayList;
import java.util.List;

public class FormeComposite implements Forme {
	 private List<Forme> EnfantsFormes = new ArrayList<Forme>();
	 	 
	 public void print() {
		 for(Forme forme : EnfantsFormes) {
			 forme.print();
		 }
	 }
	 
	 
	 public List<Forme> getAllForme() {
         return this.EnfantsFormes;
	 }
	 
	public void add(Forme forme) {
		EnfantsFormes.add(forme);
	}
	
	public void remove(Forme forme) {
		EnfantsFormes.remove(forme);
	}


	public Forme get(int i) {
		return EnfantsFormes.remove(i);
	}
	
	public String getNom() {
		return "null";
	}
	
	
	

}
