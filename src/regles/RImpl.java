package regles;

import demonstrateur.*;
import exprs.*;

/**
 * Created by Nono on 18/04/2017.
 */
public class RImpl extends RegleBranche {

    @Override
    public boolean essayerAppliquer(int i, Tableau tab) {
        Assertion a = tab.getAssert(i);
        if(a.estAssertionSat()
                && ((AssertionSat)a).expr.estImplExpr()){
            a.reagi = tab.getiBranches();
            tab.branche(i, this, true);
            tab.ajouter(new AssertionSat(a.monde, new NonExpr(((ImplExpr)((AssertionSat)a).expr).membre1)));
            return true;
        }
        return false;
    }

    @Override
    public boolean essayerAppliquerMembre2(int i, Tableau tab) {
        Assertion a = tab.getAssert(i);
        if(a.estAssertionSat()
                && ((AssertionSat)a).expr.estOuExpr() ){
            tab.branche(i, this, false);
            tab.ajouter(new AssertionSat(a.monde, ((ImplExpr)((AssertionSat)a).expr).membre2));
            return true;
        }
        return false;
    }
}