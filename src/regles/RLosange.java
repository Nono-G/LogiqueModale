package regles;

import demonstrateur.*;
import exprs.CarreExpr;
import exprs.LosangeExpr;
import exprs.NonExpr;

/**
 * Created by Nono on 19/04/2017.
 */
public class RLosange extends RegleSansBranche {
    // *a <=> !#!a
    @Override
    public boolean essayerAppliquer(int i, Tableau tab) {
        Assertion a = tab.getAssert(i);
        if(a.estAssertionSat() &&
                ((AssertionSat)a).expr.estLosangeExpr()){
            a.reagi = tab.getiBranches();
            tab.ajouter(new AssertionSat(a.monde, new NonExpr(new CarreExpr(new NonExpr(((LosangeExpr)((AssertionSat)a).expr).membre)))));
            return true;
        }
        return false;
    }
}
