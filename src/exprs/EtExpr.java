package exprs;

public class EtExpr extends Op2Expr{

	public EtExpr (){
		op="^";
	}

	@Override
	public boolean estEtExpr() {
		return true;
	}
}
