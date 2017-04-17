package demonstrateur;

public class AssertionSucc extends Assertion {
	
	public Monde succ;	
	
	public AssertionSucc(Monde m1, Monde m2) {
		super(m1);
		this.succ = m2;
	}
	
	public String toString(){
		return this.monde.toString() + " -> " + this.succ.toString();
	}

	@Override
	public boolean estAssertionSucc() {
		return true;
	}
}
