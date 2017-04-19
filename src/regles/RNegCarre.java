package regles;

import demonstrateur.*;
import exprs.CarreExpr;
import exprs.NonExpr;

/**
 * Created by Nono on 18/04/2017.
 */
public class RNegCarre extends RegleSansBranche {
    @Override
    public boolean essayerAppliquer(int i, Tableau tab) {
        Assertion a = tab.getAssert(i);
        if(a.estAssertionSat() &&
                ((AssertionSat)a).expr.estNonExpr() &&
                ((NonExpr)((AssertionSat)a).expr).membre.estCarreExpr()
                ){
            a.reagi = tab.getiBranches();
            Monde m2 = new Monde();
            tab.ajouter(new AssertionSucc(a.monde, m2));
            tab.ajouter(new AssertionSat(m2, new NonExpr(((CarreExpr)((NonExpr)((AssertionSat)a).expr).membre).membre)) {
            });
        }
        return false;
    }
}
