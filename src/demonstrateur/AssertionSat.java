package demonstrateur;
import exprs.*;

public class AssertionSat extends Assertion {
	public Expr expr;
	
	public AssertionSat(Monde m, Expr e){
		super(m);
		this.expr = e;
	}
	
	public String toString(){
		return (this.reagi>0?"R":"_") + " : " + this.monde.toString() + " : " + this.expr.toStringInfixe();
	}

	@Override
	public boolean estAssertionSat() {
		return true;
	}
}
