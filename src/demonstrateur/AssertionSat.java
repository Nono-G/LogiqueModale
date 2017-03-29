package demonstrateur;
import exprs.*;

public class AssertionSat extends Assertion {
	public Expr expr;
	
	public AssertionSat(Monde m, Expr e){
		super(m);
		this.expr = e;
	}
	
	public String toString(){
		return this.monde.toString() + " : "+(this.reagi?"R":" ")+" : "+ this.expr.toStringInfixe();
	}
}
