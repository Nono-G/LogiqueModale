package exprs;

public class Var extends Expr{
	public String nom;
	
	@Override
	public String toString(){
		return this.nom;
	}
	
	public String toStringInfixe(){
		return this.toString();
	}

	@Override
	public boolean estVarExpr() {
		return  true;
	}
}
