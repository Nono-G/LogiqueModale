package demonstrateur;

public abstract class Assertion {
	public Monde monde;
	public boolean reagi;

	public Assertion(Monde m){
		this.monde=m;
		this.reagi= false;
	}
}
