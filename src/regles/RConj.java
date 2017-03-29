package regles;

import java.util.Iterator;
import java.util.List;

import demonstrateur.Assertion;
import demonstrateur.AssertionSat;
import demonstrateur.Tableau;
import exprs.*;

public class RConj extends RegleSansBranche {
	/*
	@Override
	public boolean applicable(List<Assertion> asserts) {
		Iterator<Assertion> it = asserts.iterator();
		boolean applicable = false;
		while(it.hasNext() && !applicable){
			Assertion a = it.next();
			if(a instanceof AssertionSat){
				Expr e = ((AssertionSat)a).expr;
				if(e instanceof EtExpr){
					applicable = true;
				}
			}
		}
		return applicable;
	}

	@Override
	public boolean essayerAppliquer(List<Assertion> asserts) {
		Iterator<Assertion> it = asserts.iterator();
		boolean applicable = false;
		while(it.hasNext() && !applicable){
			Assertion a = it.next();
			if(a instanceof AssertionSat){
				Expr e = ((AssertionSat)a).expr;
				if(e instanceof EtExpr){
					applicable = true;
					asserts.add(new AssertionSat(a.monde, ((EtExpr)e).membre1));
					asserts.add(new AssertionSat(a.monde, ((EtExpr)e).membre2));
				}
			}
		}
		return applicable;
	}
	*/
	@Override
	public boolean essayerAppliquer(int i, Tableau tab) {
		Assertion a = tab.get(i);
		if(a instanceof AssertionSat
		   && ((AssertionSat)a).expr instanceof EtExpr){
			a.reagi = true;
			tab.ajouter(new AssertionSat(a.monde,((EtExpr)((AssertionSat)a).expr).membre1));
			tab.ajouter(new AssertionSat(a.monde,((EtExpr)((AssertionSat)a).expr).membre2));
			return true;
		}
		return false;
	}

}
