package exprs;

public class OuExpr extends Op2Expr{

	public OuExpr(Expr e1, Expr e2){
		super(e1,e2);
		op="+";
	}

	@Override
	public boolean estOuExpr() {
		return true;
	}
}
