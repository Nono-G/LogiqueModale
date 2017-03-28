package regles;

import java.util.Iterator;
import java.util.List;
import exprs.*;
import demonstrateur.*;

public class RDoubleNeg extends Regle{

	@Override
	public boolean applicable(List<Assertion> asserts) {
		Iterator<Assertion> it = asserts.iterator();
		boolean applicable = false;
		while(it.hasNext() && !applicable){
			Assertion a = it.next();
			if(a instanceof AssertionSat){
				Expr e = ((AssertionSat)a).expr;
				if(e instanceof NonExpr && ((NonExpr)e).membre instanceof NonExpr){
					applicable = true;
				}
			}
		}
		return applicable;
	}
	
	@Override
	public boolean essayerAppliquer(List<Assertion> asserts) {
		Iterator<Assertion> it = asserts.iterator();
		boolean applicable = false;
		while(it.hasNext() && !applicable){
			Assertion a = it.next();
			if(a instanceof AssertionSat){
				Expr e = ((AssertionSat)a).expr;
				if(e instanceof NonExpr && ((NonExpr)e).membre instanceof NonExpr){
					applicable = true;
					AssertionSat newA = new AssertionSat(a.monde,((NonExpr)((NonExpr)e).membre).membre);
					asserts.add(newA);
				}
			}
		}
		return applicable;
	}

	@Override
	public boolean assayerAppliquer2(int i, Tableau tab) {
		Assertion a = tab.get(i);
		if(a instanceof AssertionSat
			&& ((AssertionSat)a).expr instanceof NonExpr
			&& ((NonExpr)((AssertionSat)a).expr).membre instanceof NonExpr
			){//DOUBLE NEGATION
			tab.ajouter(new AssertionSat(a.monde, ((NonExpr)((NonExpr)((AssertionSat)a).expr).membre).membre));
			return true;
		}
		return false;
	}
}
