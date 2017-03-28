package regles;

import java.util.List;
import java.util.ArrayList;

public class Factory {

	public static List<Regle> getRegles(){
		List<Regle> l = new ArrayList<Regle>();
		l.add(new RDoubleNeg());
		//Ajouter d'autres règles pour les systemes T, KT4, KT45
		return l;
	}
}
