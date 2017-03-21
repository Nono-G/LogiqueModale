package demonstrateur;
import exprs.*;

public class AssertionSat extends Assertion {
	public Expr expr;
	
	public AssertionSat(Monde m, Expr e){
		super(m);
		this.expr = e;
	}
}
