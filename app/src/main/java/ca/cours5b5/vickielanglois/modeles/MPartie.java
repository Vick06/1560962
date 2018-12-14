package ca.cours5b5.vickielanglois.modeles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.cours5b5.vickielanglois.controleurs.Action;
import ca.cours5b5.vickielanglois.controleurs.ControleurAction;
import ca.cours5b5.vickielanglois.controleurs.ControleurPartie;
import ca.cours5b5.vickielanglois.controleurs.interfaces.Fournisseur;
import ca.cours5b5.vickielanglois.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.vickielanglois.exceptions.ErreurAction;
import ca.cours5b5.vickielanglois.exceptions.ErreurSerialisation;
import ca.cours5b5.vickielanglois.global.GCommande;
import ca.cours5b5.vickielanglois.global.GCouleur;
import ca.cours5b5.vickielanglois.serialisation.AttributSerialisable;
import ca.cours5b5.vickielanglois.vues.VGrille;

public class MPartie extends Modele implements Fournisseur {


    @AttributSerialisable
    public MParametresPartie parametres;
    private final String __parametres = "parametres";

    @AttributSerialisable
    public List<Integer> listeCoups;
    private final String __listeCoups = "listeCoups";

    protected MGrille grille;
    protected GCouleur couleurCourante;
    private List<Integer> colonneFini;

    public MPartie(MParametresPartie parametres) {

        this.parametres = parametres;

        initialiser();

        initialiserCouleurCourante();

        initialiserGrille();

        fournirActionPlacerJeton();

    }

    protected void initialiser() {
        listeCoups = new ArrayList<>();
        colonneFini = new ArrayList<>();
    }

    public List<Integer> getColonneFini(){
        return colonneFini;
    }
    private void initialiserCouleurCourante() {
        couleurCourante = GCouleur.ROUGE;
    }


    protected void initialiserGrille() {
        grille = new MGrille(parametres.getLargeur());
    }


    protected void fournirActionPlacerJeton() {

        ControleurAction.fournirAction(this,
                GCommande.PLACER_JETON_ICI,
                new ListenerFournisseur() {

                    @Override
                    public void executer(Object... args) {
                        try {

                            int colonne = (Integer) args[0];

                            jouerCoup(colonne);


                        } catch (ClassCastException e) {

                            throw new ErreurAction(e);

                        }
                    }
                });
    }


    protected void jouerCoup(int colonne) {

       /* if (siCoupLegal(colonne)) {
            jouerCoupLegal(colonne);

        }*/

       if(!siCoupLegal(colonne) || grille.siCouleurGagne(couleurCourante, parametres.getPourGagner())){
           VGrille.desactiverEntetes.add(colonne);
       }else{
           Action action = ControleurAction.demanderAction(GCommande.ENTETE);
       }
    }


    protected void jouerCoupLegal(int colonne) {

        listeCoups.add(colonne);
        grille.placerJeton(colonne, couleurCourante);
        
        if (grille.siCouleurGagne(couleurCourante, parametres.getPourGagner())) {

            ControleurPartie.getInstance().gagnerPartie(couleurCourante);

        } else {

            prochaineCouleurCourante();

        }
    }

    protected boolean siCoupLegal(int colonne) {

        MColonne mColonne = grille.getColonnes().get(colonne);

        return mColonne.getJetons().size() < parametres.getHauteur();

    }


    protected void prochaineCouleurCourante() {

        switch (couleurCourante) {

            case ROUGE:
                couleurCourante = GCouleur.JAUNE;
                break;

            case JAUNE:
                couleurCourante = GCouleur.ROUGE;
        }
    }


    public MGrille getGrille() {
        return grille;
    }

    public MParametresPartie getParametres() {
        return parametres;
    }


    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation {

        parametres.aPartirObjetJson((Map<String, Object>) objetJson.get(__parametres));

        initialiserCouleurCourante();

        initialiserGrille();

        List<String> listeCoupsObjetJson = (List<String>) objetJson.get(__listeCoups);

        if (listeCoupsObjetJson != null) {

            List<Integer> coupsARejouer = listeCoupsAPartirJson(listeCoupsObjetJson);
            rejouerLesCoups(coupsARejouer);

        }
    }


    protected List<Integer> listeCoupsAPartirJson(List<String> listeCoupsObjetJson) {
        List<Integer> listeCoups = new ArrayList<>();

        for (String coupChaine : listeCoupsObjetJson) {

            listeCoups.add(Integer.valueOf(coupChaine));

        }

        return listeCoups;
    }


    protected void rejouerLesCoups(List<Integer> coupsARejouer) {

        listeCoups.clear();

        for(Integer coup : coupsARejouer){

            jouerCoup(coup);

        }
    }


    @Override
    public Map<String, Object> enObjetJson() throws ErreurSerialisation {
        Map<String, Object> objetJson = new HashMap<>();

        objetJson.put(__parametres, parametres.enObjetJson());
        objetJson.put(__listeCoups, listeCoupsEnObjetJson(listeCoups));

        return objetJson;

    }


    protected List<String> listeCoupsEnObjetJson(List<Integer> listeCoups) {
        List<String> listeCoupsObjetJson = new ArrayList<>();

        for (Integer coup : listeCoups) {

            listeCoupsObjetJson.add(coup.toString());

        }

        return listeCoupsObjetJson;
    }

    public GCouleur getCouleurCourante() {
        return couleurCourante;
    }

    public boolean gagner(){
        return grille.siCouleurGagne(couleurCourante, parametres.getPourGagner());
    }
}
