package exprs;

public class NonExpr extends Op1Expr{

	public NonExpr(Expr e){
		super(e);
		op="!";
	}

	@Override
	public boolean estNonExpr() {
		return true;
	}
}
