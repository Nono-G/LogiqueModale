package regles;

import demonstrateur.Tableau;

/**
 * Created by Nono on 18/04/2017.
 */
public class RImpl extends RegleBranche {

    @Override
    public boolean essayerAppliquer(int i, Tableau tab) {
        return false;
    }

    @Override
    public boolean essayerAppliquerMembre2(int i, Tableau tab) {
        return false;
    }
}
