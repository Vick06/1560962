package ca.cours5b5.vickielanglois.modeles;

import java.util.Map;

import ca.cours5b5.vickielanglois.exceptions.ErreurSerialisation;
import ca.cours5b5.vickielanglois.serialisation.AttributSerialisable;

public class MPartie {

    @AttributSerialisable
    public MParametres parametres;
    private final String _parametres = "parametres";

    public MPartie(MParametresPartie parametres){

    }
    public MParametresPartie getParametres(){

    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation{
        /*
        Inutilisé pour l'instant
         */
    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurSerialisation{
        /*
        Inutilisé pour l'instant
         */
    }

}
