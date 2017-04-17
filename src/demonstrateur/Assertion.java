package demonstrateur;

public abstract class Assertion {
	public Monde monde;
	public int reagi;

	public Assertion(Monde m){
		this.monde=m;
		this.reagi= 0;
	}
	
	//public abstract String toString();

	public boolean estAssertionSat(){
		return false;
	}

	public boolean estAssertionSucc(){
		return false;
	}
}
