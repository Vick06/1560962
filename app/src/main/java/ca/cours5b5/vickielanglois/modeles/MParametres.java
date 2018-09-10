package ca.cours5b5.vickielanglois.modeles;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.vickielanglois.global.GConstantes;
import ca.cours5b5.vickielanglois.serialisation.AttributSerialisable;

public class MParametres extends Modele {

    public static MParametres instance;

    @AttributSerialisable
    public Integer hauteur;

    @AttributSerialisable
    public Integer largeur;

    @AttributSerialisable
    public Integer pourGagner;

    private List<Integer> choixHauteur;
    private List<Integer> choixLargeur;
    private List<Integer> choixPourGagner;

    public MParametres() {

        genererListesDeChoix();
    }

    public List<Integer> getChoixHauteur(){
        return choixHauteur;
    }

    public List<Integer> getChoixLargeur(){
        return choixLargeur;
    }

    public List<Integer> getChoixPourGagner(){
        return choixPourGagner;
    }

    public Integer getHauteur(){
        return hauteur;
    }

    public Integer getLargeur() {
        return largeur;
    }

    public Integer getPourGagner() {
        return pourGagner;
    }


    public void setHauteur(int hauteur){

    }

    public void setLargeur(int largeur){

    }

    public void setPourGagner(int pourGagner){

    }

    private void genererListesDeChoix(){

        genererListeChoixHauteur();
        genererListeChoixLargeur();
        genererListeChoixPourGagner();

    }

    private List<Integer> genererListeChoix(int min, int max){

        List<Integer> listeChoix = new ArrayList<>();

        for( ; min <= max; min++){

            listeChoix.add(min);
        }

        return listeChoix;

    }

    private void genererListeChoixHauteur(){

       choixHauteur = genererListeChoix(GConstantes.MIN_HAUTEUR, GConstantes.MAX_HAUTEUR);

    }

    private void genererListeChoixLargeur(){

       choixLargeur = genererListeChoix(GConstantes.MIN_LARGEUR, GConstantes.MAX_LARGEUR);

    }

    private void genererListeChoixPourGagner(){

        choixPourGagner = genererListeChoix(GConstantes.MIN_POURGAGNER, GConstantes.MAX_POURGAGNER);

    }
}
