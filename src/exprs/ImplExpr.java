package exprs;

public class ImplExpr extends Op2Expr{
	
	public ImplExpr(Expr e1, Expr e2) {
		super(e1,e2);
		op=">";
	}

	@Override
	public boolean estImplExpr() {
		return true;
	}
}
