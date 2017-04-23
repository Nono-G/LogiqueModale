package demonstrateur;

import java.util.*;

import exprs.*;
import regles.*;

public class Demon {

	public List<Regle> regles;
	public boolean verbeux;

	public Demon(Systeme sys, boolean verbeux){
		switch(sys){
			case K :
				this.regles = Factory.getReglesSysK();
				break;
			case T :
				this.regles = Factory.getReglesSysT();
				break;
			default:
				throw new RuntimeException("Système non supporté.");
		}
		this.verbeux=verbeux;
	}

	public boolean sat(Tableau tab){

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
	
	public void reagirTous(Tableau tab, boolean verbeux){
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
	
	public boolean contradiction(Tableau tab, boolean verbeux/*, String message*/){
		int i = 0;
		while(i < tab.iAssert){//Parcourir les assertions
			Assertion a = tab.getAssert(i);
			if(a.estAssertionSat() && ((AssertionSat)a).expr.estVarExpr()){
				//a Un littéral positif
				int j = 0;
				while(j < tab.iAssert){//Parcourir les assertions pour trouver le littéral negatif
					Assertion a2 = tab.getAssert(j);
					if(a2.monde.equals(a.monde) &&
					   a2.estAssertionSat() &&
					   ((AssertionSat)a2).expr.estNonExpr() &&
					   ((NonExpr)((AssertionSat)a2).expr).membre.estVarExpr() &&
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
