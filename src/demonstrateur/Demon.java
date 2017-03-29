package demonstrateur;

import java.util.*;

import exprs.*;
import regles.*;

public class Demon {
	
	public static List<Regle> regles = Factory.getRegles();
	
	public static boolean sat(Tableau tab){
		while( ! tab.termine()){
			reagirTous(tab);
			if(contradiction(tab)){
				Debranchement debr = null;
				while(! tab.termine() && debr == null){
					debr = tab.debranche();
				}
				if(debr != null){
					debr.regle.essayerAppliquerMembre2(debr.iAssert, tab);
				}else{
					return false;
				}
			}else{
				//formule satifaisable ?
				return true;
			}
		}
		return true;
	}
	
	public static boolean reagirTous(Tableau tab){
		int i = 0;
		boolean agi = false;
		while(i < tab.iAssert){
			Assertion a = tab.asserts[i];
			if(!a.reagi){//Si la règle est déjà marquée comme ayant réagi, on la saute
				for(Regle r : regles){
					agi = r.essayerAppliquer(i, tab);
					if(agi){System.out.println(tab);break;}//On ne fait agir qu'une règle
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
				//a Un littéral positif
				int j = 0;
				while(j < tab.iAssert){//Parcourir les assertions pour trouver le littéral negatif
					Assertion a2 = tab.get(j);
					if(a2.monde.equals(a.monde) &&
					   a2 instanceof AssertionSat &&
					   ((AssertionSat)a2).expr instanceof NonExpr &&
					   ((NonExpr)((AssertionSat)a2).expr).membre instanceof Var &&
					   ((Var)((NonExpr)((AssertionSat)a2).expr).membre).nom.equals(((Var)((AssertionSat)a).expr).nom)
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
