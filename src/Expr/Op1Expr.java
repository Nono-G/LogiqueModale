package Expr;

public abstract class Op1Expr extends ExprOp{
	public Expr membre;
	
	@Override
	public String toString(){
		return this.op+"("+membre+")";
	}
	
	public String toStringInfixe(){
		return this.toString();
	}
}
