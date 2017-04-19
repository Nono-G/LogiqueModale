package regles;

import demonstrateur.*;
import exprs.CarreExpr;
import exprs.LosangeExpr;
import exprs.NonExpr;

/**
 * Created by Nono on 19/04/2017.
 */
public class RNegLosange extends RegleSansBranche{

    @Override
    public boolean essayerAppliquer(int i, Tableau tab) {
        Assertion a = tab.getAssert(i);
        if(a.estAssertionSat() &&
                ((AssertionSat)a).expr.estNonExpr() &&
                ((NonExpr)((AssertionSat)a).expr).membre.estLosangeExpr()){
            a.reagi = tab.getiBranches();
            tab.ajouter(new AssertionSat(a.monde, new CarreExpr(new NonExpr(((LosangeExpr)((NonExpr)((AssertionSat)a).expr).membre).membre))));
            return true;
        }
        return false;
    }
}
