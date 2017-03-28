package regles;

import java.util.List;
import exprs.*;
import demonstrateur.*;

public abstract class Regle {

	public abstract boolean applicable(List<Assertion> asserts);
	
	public abstract boolean essayerAppliquer(List<Assertion> asserts);
	
	public abstract boolean assayerAppliquer2(int i, Tableau tab);
}
