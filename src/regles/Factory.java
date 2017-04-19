package regles;

import java.util.List;
import java.util.ArrayList;

public class Factory {

	public static List<Regle> getReglesSysK(){
		List<Regle> l = new ArrayList<Regle>();
		l.add(new RDoubleNeg());
		l.add(new RDisj());
		l.add(new RConj());
		l.add(new RNegDisj());
		l.add(new RNegImpl());
		l.add(new RNegConj());
		l.add(new RNegCarre());
		l.add(new RCarre());
		l.add(new RImpl());
		l.add(new RLosange());
		//Ajouter d'autres règles pour les systemes T, KT4, KT45
		return l;
	}

	public static List<Regle> getReglesSysT(){return null;}
	public static List<Regle> getReglesSysKT4(){
		return null;
	}
}
