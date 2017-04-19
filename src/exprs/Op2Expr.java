package exprs;

public abstract class Op2Expr extends ExprOp{
	public Expr membre1;
	public Expr membre2;

	public Op2Expr (Expr e1, Expr e2){
		this.membre1 = e1;
		this.membre2 = e2;
	}
	
	@Override
	public String toString(){
		return this.op+"("+membre1+","+membre2+")";
	}
	
	public String toStringInfixe(){
		return "("+membre1.toStringInfixe()+""+this.op+""+membre2.toStringInfixe()+")";
	}
}
