package exprs;

public abstract class Expr {
	
	public abstract String toStringInfixe();

	//Sera redéfini :
	public boolean estOuExpr(){return  false;}
	public boolean estEtExpr(){return false;}
	public boolean estImplExpr(){return false;}
	public boolean estNonExpr(){return false;}

}
