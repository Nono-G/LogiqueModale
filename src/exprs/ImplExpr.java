package exprs;

public class ImplExpr extends Op2Expr{
	
	public ImplExpr(){
		op=">";
	}

	@Override
	public boolean estImplExpr() {
		return true;
	}
}
