package regles;

import demonstrateur.*;
import exprs.*;

/**
 * Created by Nono on 17/04/2017.
 */
public class RNegConj extends RegleBranche {

    @Override
    public boolean essayerAppliquer(int i, Tableau tab) {
        Assertion a = tab.getAssert(i);
        if(a.estAssertionSat()
                && ((AssertionSat)a).expr.estNonExpr()
                && ((NonExpr)((AssertionSat) a).expr).membre.estEtExpr()
                ){
            a.reagi = tab.getiBranches();
            tab.branche(i, this, true);
            NonExpr e1 = new NonExpr(((EtExpr)((NonExpr)((AssertionSat)a).expr).membre).membre1);
            tab.ajouter(new AssertionSat(a.monde, e1));
            return true;
        }
        return false;
    }

    @Override
    public boolean essayerAppliquerMembre2(int i, Tableau tab) {
        Assertion a = tab.getAssert(i);
        if(a.estAssertionSat()
                && ((AssertionSat)a).expr.estNonExpr()
                && ((NonExpr)((AssertionSat) a).expr).membre.estEtExpr()
                ){
            a.reagi = tab.getiBranches();
            tab.branche(i, this, false);
            NonExpr e2 = new NonExpr(((EtExpr)((NonExpr)((AssertionSat)a).expr).membre).membre2);
            tab.ajouter(new AssertionSat(a.monde, e2));
            return true;
        }
        return false;
    }
}
