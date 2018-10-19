package ca.cours5b5.vickielanglois.modeles;

import java.util.Map;

import ca.cours5b5.vickielanglois.controleurs.ControleurAction;
import ca.cours5b5.vickielanglois.controleurs.interfaces.Fournisseur;
import ca.cours5b5.vickielanglois.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.vickielanglois.exceptions.ErreurSerialisation;
import ca.cours5b5.vickielanglois.global.GCommande;
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
        this.grille = new MGrille(parametres.getLargeur(), parametres.getHauteur());

        initialiserCouleurCourante();
        fournirActionPlacerJeton();

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
        couleurCourante = GCouleur.JAUNE;
    }

    private void fournirActionPlacerJeton(){

        ControleurAction.fournirAction(this, GCommande.JOUER_COUP_ICI, new ListenerFournisseur() {
            @Override
            public void executer(Object... args){

                jouerCoup((int)args[0]);
                /*args[0] = couleurCourante;

                int colonne = ((int) args[0]);

                jouerCoup(colonne);

                prochaineCouleurCourante();*/
            }
        });

    }

    protected void jouerCoup(int colonne){

        grille.placerJeton(colonne, couleurCourante);
        prochaineCouleurCourante();
    }

    private void prochaineCouleurCourante(){

        switch (couleurCourante){
            case ROUGE:
                couleurCourante = GCouleur.JAUNE;
                break;
            case JAUNE:
                couleurCourante = GCouleur.ROUGE;
                break;
        }

    }
}
