package demonstrateur;

public class Tableau {
	private static final int TAILLE_TABLEAU = 50000;
	private static final int TAILLE_PILE_BRANCHES = 100;
	
	public Assertion[] asserts;
	public int iAssert;
	
	private int branches[];
	private int iBranches;
	
	public Tableau(){
		this.asserts = new Assertion[TAILLE_TABLEAU];
		this.iAssert = 0;
		
		this.branches = new int[TAILLE_PILE_BRANCHES];
		this.branches[0] = 0;
		this.iBranches = 1;
	}
	
	public void branche(){
		this.branches[iBranches] = iAssert;
		this.iBranches ++;
	}
	
	public void debranche(){
		this.iAssert = this.branches[iBranches-1];
		this.iBranches--;
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
	
}
