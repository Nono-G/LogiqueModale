package regles;

import java.util.List;
import java.util.ArrayList;

public class Factory {

	private static List<Regle> getReglesCommunes(){
		List<Regle> l = new ArrayList<Regle>();
		l.add(new RDoubleNeg());
		l.add(new RDisj());
		l.add(new RConj());
		l.add(new RNegDisj());
		l.add(new RNegImpl());
		l.add(new RNegConj());
		l.add(new RNegCarre());
		l.add(new RImpl());
		l.add(new RLosange());
		l.add(new RNegLosange());
		l.add(new RCarreBis());
		return l;
	}

	public static List<Regle> getReglesSysK(){
		List<Regle> l = getReglesCommunes();
		l.add(new RCarre());
		return l;
	}

	public static List<Regle> getReglesSysT(){
		List<Regle> l = getReglesCommunes();
		l.add(new RT());
		return l;
	}

	public static List<Regle> getReglesSysKT4(){
		return null;
	}
}
