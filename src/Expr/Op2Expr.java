package Expr;

public abstract class Op2Expr extends ExprOp{
	public Expr membre1;
	public Expr membre2;
	
	@Override
	public String toString(){
		return this.op+"("+membre1+","+membre2+")";
	}
	
	public String toStringInfixe(){
		return "("+membre1.toStringInfixe()+" "+this.op+" "+membre2.toStringInfixe()+")";
	}
}
