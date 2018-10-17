package ca.cours5b5.vickielanglois.modeles;

import java.util.List;
import java.util.Map;

import ca.cours5b5.vickielanglois.exceptions.ErreurSerialisation;
import ca.cours5b5.vickielanglois.global.GCouleur;

public class MColonne extends Modele{

    private List<GCouleur> jetons;

    public MColonne(){

    }

    public List<GCouleur> getJetons(){

        return null;
    }

    public void placerJeton(GCouleur couleur){

    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation{
        /*
         * Inutilise
         */
    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurSerialisation{
        /*
         * Inutilise
         */
        return null;
    }

}
