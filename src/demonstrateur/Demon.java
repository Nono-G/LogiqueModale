package demonstrateur;

import java.util.*;

import exprs.*;
import regles.*;

public class Demon {
	
	public static List<Regle> regles = Factory.getReglesSysK();
	
	public static boolean sat(Tableau tab, boolean verbeux){
		while( ! tab.termine()){
			reagirTous(tab,verbeux);
			//String messageContradiction = new String();
			if(contradiction(tab, verbeux/*, messageContradiction*/)){
				Debranchement debr = null;
				while(! tab.termine() && debr == null){
					debr = tab.debranche();
				}
				if(debr != null){
					debr.regle.essayerAppliquerMembre2(debr.iAssert, tab);
				}else{
					//if(verbeux){System.out.println(messageContradiction);}
					return false;
				}
			}else{
				//formule satifaisable ?
				if(verbeux){System.out.println("Formule valide, pas de contradiction.");}
				return true;
			}
		}
		return true;
	}
	
	public static void reagirTous(Tableau tab, boolean verbeux){
		int i = 0;
		boolean agi = false;
		while(i < tab.iAssert){
			Assertion a = tab.asserts[i];
			if(a.reagi == 0){//Si la règle est déjà marquée comme ayant réagi, on la saute
				for(Regle r : regles){
					agi = r.essayerAppliquer(i, tab);
					if(agi){break;}//On ne fait agir qu'une règle
				}
			}
			i++;
		}
		if(verbeux){System.out.println(tab);}
		//return false;//retour = une règle a agi ou non
	}
	
	public static boolean contradiction(Tableau tab, boolean verbeux/*, String message*/){
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
						if(verbeux){
							//message += "Contradiction littéral "+((Var)((AssertionSat)a).expr).nom+" dans le monde "+((AssertionSat)a).monde.nom+".";
							System.out.println("Contradiction littéral \""+((Var)((AssertionSat)a).expr).nom+"\" dans le monde \""+((AssertionSat)a).monde.nom+"\".");
						}
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
