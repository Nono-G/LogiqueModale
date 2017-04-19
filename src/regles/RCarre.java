package regles;

import demonstrateur.Assertion;
import demonstrateur.AssertionSat;
import demonstrateur.AssertionSucc;
import demonstrateur.Tableau;
import exprs.CarreExpr;

/**
 * Created by Nono on 18/04/2017.
 */
public class RCarre extends RegleSansBranche {

    @Override
    public boolean essayerAppliquer(int i, Tableau tab) {
        Assertion a = tab.getAssert(i);
        if(a.estAssertionSat() &&
                ((AssertionSat)a).expr.estCarreExpr()){
            int j = 0;
            while(j<tab.iAssert){
                Assertion a2 = tab.getAssert(j);
                if(a2.estAssertionSucc() && a2.monde.equals(a.monde)){
                    tab.ajouter(new AssertionSat(((AssertionSucc)a2).succ, ((CarreExpr)((AssertionSat)a).expr).membre));
                }
                j++;
            }
            a.reagi = tab.getiBranches();
            return true;
        }
        return false;
    }
}
