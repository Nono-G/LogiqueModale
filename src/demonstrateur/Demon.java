package demonstrateur;

import java.util.*;

import exprs.*;
import regles.*;

public class Demon {
	
	public static List<Regle> regles = Factory.getRegles();
	public static void demontrer(){
		
	}
	
	public static boolean reagirTous(Tableau tab){
		int i = 0;
		while(i < tab.iAssert){
			Assertion a = tab.asserts[i];
			if(!a.reagi){//Si la règle est déjà marquée comme ayant réagi, on la saute
				for(Regle r : regles){
					r.assayerAppliquer2(i, tab);
					//DETECTER LES BRANCHES
				}
			}
			i++;
		}
		return false;//retour = une règle a agi ou non
	}
	
	public static boolean contradiction(Tableau tab){
		int i = 0;
		while(i < tab.iAssert){//Parcourir les assertions
			Assertion a = tab.get(i);
			if(a instanceof AssertionSat && ((AssertionSat)a).expr instanceof Var){
				//Un littéral positif
				int j = 0;
				while(j < tab.iAssert){
					Assertion a2 = tab.get(i);
					if(a2.monde.equals(a.monde) &&
					   a2 instanceof AssertionSat &&
					   ((AssertionSat)a).expr instanceof NonExpr &&
					   ((NonExpr)((AssertionSat)a).expr).membre instanceof Var &&
					   ((Var)((NonExpr)((AssertionSat)a).expr).membre).nom.equals(((Var)((AssertionSat)a).expr).nom)
					   ){//CONTRADICTION
						return true;
					}
					j++;
				}
			}
			i++;
		}
		return false;
	}

}
