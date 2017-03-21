package regles;

import java.util.Iterator;
import java.util.List;

import demonstrateur.Assertion;
import demonstrateur.AssertionSat;
import exprs.*;

public class RConj extends Regle {

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

}
