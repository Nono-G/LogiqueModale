package regles;

import exprs.*;
import demonstrateur.*;

public class RDoubleNeg extends RegleSansBranche{

	@Override
	public boolean essayerAppliquer(int i, Tableau tab) {
		Assertion a = tab.getAssert(i);
		if(a.estAssertionSat()
			&& ((AssertionSat)a).expr.estNonExpr()
			&& ((NonExpr)((AssertionSat)a).expr).membre.estNonExpr()
			){//DOUBLE NEGATION
			a.reagi = tab.getiBranches();
			tab.ajouter(new AssertionSat(a.monde, ((NonExpr)((NonExpr)((AssertionSat)a).expr).membre).membre));
			return true;
		}
		return false;
	}
}