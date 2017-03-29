package demonstrateur;

import regles.RegleBranche;

public class Debranchement {
	public int iAssert;
	public RegleBranche regle;
	
	public Debranchement(int i, RegleBranche r){
		this.regle = r;
		this.iAssert = i;
	}
}
