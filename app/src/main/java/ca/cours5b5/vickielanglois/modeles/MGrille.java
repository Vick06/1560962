package ca.cours5b5.vickielanglois.modeles;

import android.view.Display;

import java.util.List;
import java.util.Map;

import ca.cours5b5.vickielanglois.exceptions.ErreurSerialisation;
import ca.cours5b5.vickielanglois.global.GCouleur;

public class MGrille extends Modele{

    private List<MColonne> colonnes;

    public MGrille(int largeur){

    }

    private void initialiserColonnes(int largeur){

    }

    public List<MColonne> getColonnes(){

        return null;
    }

    public void placerJeton(int colonne, GCouleur couleur){

    }

    //@Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation{
        /*
         * Inutilise
         */
    }

    //@Override
    public Map<String, Object> enObjetJson() throws ErreurSerialisation{
        /*
         * Inutilise
         */
        return null;
    }

}
