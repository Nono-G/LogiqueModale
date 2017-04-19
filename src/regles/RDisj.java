package regles;

import demonstrateur.*;
import exprs.OuExpr;

public class RDisj extends RegleBranche {

	@Override
	public boolean essayerAppliquerMembre2(int i, Tableau tab) {
		Assertion a = tab.getAssert(i);
		if(a.estAssertionSat()
		   && ((AssertionSat)a).expr.estOuExpr()){
			tab.branche(i, this, false);
			tab.ajouter(new AssertionSat(a.monde, ((OuExpr)((AssertionSat)a).expr).membre2));
			return true;
		}
		return false;
	}

	@Override
	public boolean essayerAppliquer(int i, Tableau tab) {
		Assertion a = tab.getAssert(i);
		if(a.estAssertionSat()
		   && ((AssertionSat)a).expr.estOuExpr()){
			a.reagi = tab.getiBranches();
			tab.branche(i, this, true);
			tab.ajouter(new AssertionSat(a.monde, ((OuExpr)((AssertionSat)a).expr).membre1));
			return true;
		}
		return false;
	}

}
