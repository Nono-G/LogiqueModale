package exprs;

public class EtExpr extends Op2Expr{

	public EtExpr (Expr e1, Expr e2) {
		super(e1,e2);
		op="^";
	}

	@Override
	public boolean estEtExpr() {
		return true;
	}
}
