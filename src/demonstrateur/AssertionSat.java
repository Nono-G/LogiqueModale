package demonstrateur;
import exprs.*;

public class AssertionSat extends Assertion {
	public Expr expr;
	
	public AssertionSat(Monde m, Expr e){
		super(m);
		this.expr = e;
	}
	
	public String toString(){
		return this.monde.toString() + " : "+(this.reagi>0?"R":"_")+" : "+ this.expr.toStringInfixe();
	}

	@Override
	public boolean estAssertionSat() {
		return true;
	}
}
