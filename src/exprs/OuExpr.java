package exprs;

public class OuExpr extends Op2Expr{

	public OuExpr(){
		op="+";
	}

	@Override
	public boolean estOuExpr() {
		return true;
	}
}
