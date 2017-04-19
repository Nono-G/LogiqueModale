package regles;

import demonstrateur.*;
import exprs.*;

/**
 * Created by Nono on 17/04/2017.
 */
public class RNegDisj extends RegleSansBranche {

    @Override
    public boolean essayerAppliquer(int i, Tableau tab) {
        Assertion a = tab.getAssert(i);
        if(a.estAssertionSat()
                && ((AssertionSat)a).expr.estNonExpr()
                && ((NonExpr)((AssertionSat) a).expr).membre.estOuExpr()
                ){
            a.reagi = tab.getiBranches();
            NonExpr e1 = new NonExpr(((OuExpr)((NonExpr)((AssertionSat)a).expr).membre).membre1);
            NonExpr e2 = new NonExpr(((OuExpr)((NonExpr)((AssertionSat)a).expr).membre).membre2);
            tab.ajouter(new AssertionSat(a.monde, e1));
            tab.ajouter(new AssertionSat(a.monde, e2));
            return true;
        }
        return false;
    }
}
