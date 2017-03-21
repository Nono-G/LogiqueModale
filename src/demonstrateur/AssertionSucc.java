package demonstrateur;

public class AssertionSucc extends Assertion {
	
	public Monde succ;	
	
	public AssertionSucc(Monde m1, Monde m2) {
		super(m1);
		this.succ = m2;
	}


}
