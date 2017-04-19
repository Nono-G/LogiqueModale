package exprs;

public class LosangeExpr extends Op1Expr{

	@Override
	public boolean estLosangeExpr() {
		return true;
	}

	public LosangeExpr(Expr e){
		super(e);
		op="*";
	}
}
