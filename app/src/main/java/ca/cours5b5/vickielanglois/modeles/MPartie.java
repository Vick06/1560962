package ca.cours5b5.vickielanglois.modeles;

import java.util.Map;

import ca.cours5b5.vickielanglois.controleurs.interfaces.Fournisseur;
import ca.cours5b5.vickielanglois.exceptions.ErreurSerialisation;
import ca.cours5b5.vickielanglois.global.GCouleur;
import ca.cours5b5.vickielanglois.serialisation.AttributSerialisable;

public class MPartie extends Modele implements Fournisseur{

    @AttributSerialisable
    public MParametresPartie parametres;
    private final String _parametres = "parametres";
    private MGrille grille;
    private GCouleur couleurCourante;

    public MPartie(MParametresPartie parametres){

        this.parametres = parametres;

    }
    public MParametresPartie getParametres(){

        return parametres;

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
        return null;
    }

    public MGrille getGrille() {
        return grille;
    }

    private void initialiserCouleurCourante(){

    }

    private void fournirActionPlacerJeton(){
            /*
             * Appeler fournirAction
             */
    }

    protected void jouerCoup(int colonne){

    }

    private void prochaineCouleurCourante(){

    }
}
