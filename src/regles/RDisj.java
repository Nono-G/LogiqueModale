package regles;

import demonstrateur.*;
import exprs.OuExpr;

public class RDisj extends RegleBranche {

	@Override
	public boolean essayerAppliquerMembre2(int i, Tableau tab) {
		Assertion a = tab.getAssert(i);
		if(a instanceof AssertionSat
		   && ((AssertionSat)a).expr instanceof OuExpr){
			tab.branche(i, this, false);
			tab.ajouter(new AssertionSat(a.monde, ((OuExpr)((AssertionSat)a).expr).membre2));
			return true;
		}
		return false;
	}

	@Override
	public boolean essayerAppliquer(int i, Tableau tab) {
		Assertion a = tab.getAssert(i);
		if(a instanceof AssertionSat
		   && ((AssertionSat)a).expr instanceof OuExpr){
			a.reagi = tab.getiBranches();
			tab.branche(i, this, true);
			tab.ajouter(new AssertionSat(a.monde, ((OuExpr)((AssertionSat)a).expr).membre1));
			return true;
		}
		return false;
	}

}
