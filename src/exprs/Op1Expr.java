package exprs;

public abstract class Op1Expr extends ExprOp{
	public Expr membre;

	public Op1Expr(Expr e){
		this.membre = e;
	}

	@Override
	public String toString(){
		return this.op+"("+membre+")";
	}
	
	public String toStringInfixe(){
		return this.toString();
	}
}
