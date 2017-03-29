package demonstrateur;

import regles.RegleBranche;

public class Tableau {
	private static final int TAILLE_TABLEAU = 50000;
	private static final int TAILLE_PILE_BRANCHES = 100;
	
	public Assertion[] asserts;
	public int iAssert;
	
	private int branches_pos[];
	private int branches_assert[];
	private RegleBranche branches_regle[];
	private boolean branches_b2[];
	private int iBranches;
	
	public Tableau(){
		this.asserts = new Assertion[TAILLE_TABLEAU];
		this.iAssert = 0;
		
		this.branches_pos = new int[TAILLE_PILE_BRANCHES];
		this.branches_assert = new int[TAILLE_PILE_BRANCHES];
		this.branches_regle = new RegleBranche[TAILLE_PILE_BRANCHES];
		this.branches_b2 = new boolean[TAILLE_PILE_BRANCHES];
		this.branches_pos[0] = 0;
		this.branches_assert[0] = 0;
		this.branches_regle[0] = null;
		this.branches_b2[0] = false;
		this.iBranches = 1;
	}
	
	public void branche(int i, RegleBranche r, boolean b2from){
		this.branches_pos[iBranches] = iAssert;
		this.branches_assert[iBranches] = i;
		this.branches_regle[iBranches] = r;
		this.branches_b2[iBranches] = b2from;
		this.iBranches ++;
	}
	
	public Debranchement debranche(){
		this.iBranches--;
		this.iAssert = this.branches_pos[iBranches];
		if(termine() || ! this.branches_b2[iBranches]){
			return null;
		}else{
			Debranchement debr = new Debranchement(branches_assert[iBranches], branches_regle[iBranches]);
			return debr;
		}
	}
	
	public void ajouter(Assertion a){
		this.asserts[iAssert] = a;
		this.iAssert++;
	}
	
	public Assertion get(int i){
		if(i<this.iAssert){
			return this.asserts[i];
		}else{
			throw new RuntimeException("Tagleau.get : Assertion hors bornes");
		}
	}
	
	public boolean termine(){
		return this.iBranches == 0;
	}
	
	public String toString(){
		String str="***TABLEAU***\n";
		int x = 0;
		int y = 0;
		while( x < this.iAssert){
			if(x == this.branches_pos[y]){
				y++;
				str += "    |\n    |\n";
			}
			str += this.asserts[x].toString()+"\n";
			x++;
		}
		return str+"***       ***";
	}
	
}
