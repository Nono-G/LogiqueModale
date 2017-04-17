package exprs;

public class NonExpr extends Op1Expr{

	public NonExpr(){
		op="!";
	}

	@Override
	public boolean estNonExpr() {
		return true;
	}
}
