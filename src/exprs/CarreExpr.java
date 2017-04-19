package exprs;

public class CarreExpr extends Op1Expr {
	
	public CarreExpr(Expr e){
		super(e);
		op = "#";
	}

	@Override
	public boolean estCarreExpr() {
		return true;
	}
}
