package regles;

import demonstrateur.*;
import exprs.CarreExpr;

/**
 * Created by Nono on 23/04/2017.
 */
public class RCarreBis extends RegleSansBranche{

    @Override
    public boolean essayerAppliquer(int i, Tableau tab) {
        Assertion a = tab.getAssert(i);
        if(a.estAssertionSucc()){
            int k = 0;
            while(k < tab.iAssert){
                Assertion a2 = tab.getAssert(k);
                if(a2.estAssertionSat() &&
                        a2.monde.equals(a.monde) &&
                        ((AssertionSat)a2).expr.estCarreExpr()){
                    tab.ajouter(new AssertionSat(((AssertionSucc)a).succ, ((CarreExpr)((AssertionSat)a2).expr).membre));
                }
                k++;
            }
            a.reagi = tab.getiBranches();
            return true;
        }
        return false;
    }
}
