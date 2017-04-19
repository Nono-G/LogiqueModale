package regles;

import demonstrateur.Assertion;
import demonstrateur.AssertionSat;
import demonstrateur.Tableau;
import exprs.*;

public class RConj extends RegleSansBranche {

	@Override
	public boolean essayerAppliquer(int i, Tableau tab) {
		Assertion a = tab.getAssert(i);
		if(a.estAssertionSat()
		   && ((AssertionSat)a).expr.estEtExpr()){
			a.reagi = tab.getiBranches();
			tab.ajouter(new AssertionSat(a.monde,((EtExpr)((AssertionSat)a).expr).membre1));
			tab.ajouter(new AssertionSat(a.monde,((EtExpr)((AssertionSat)a).expr).membre2));
			return true;
		}
		return false;
	}

}
