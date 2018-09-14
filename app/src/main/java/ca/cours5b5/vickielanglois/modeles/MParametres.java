package ca.cours5b5.vickielanglois.modeles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.cours5b5.vickielanglois.global.GConstantes;
import ca.cours5b5.vickielanglois.serialisation.AttributSerialisable;

public class MParametres extends Modele {

    public static MParametres instance;

    @AttributSerialisable
    public Integer hauteur;
    private final String _hauteur = "hauteur";

    @AttributSerialisable
    public Integer largeur;
    private final String _largeur = "largeur";

    @AttributSerialisable

    public Integer pourGagner;
    private final String _pourGagner = "pourGagner";

    private List<Integer> getChoixHauteur;
    private List<Integer> getChoixLargeur;
    private List<Integer> getChoixPourGagner;

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) {

       for(Map.Entry<String, Object> entry : objetJson.entrySet()){

           String cle = entry.getKey();
           Object valeur = entry.getValue();

           if(cle.equals(_hauteur)){
               hauteur = Integer.valueOf((String) valeur);
           }else if(cle.equals(_largeur)){
               largeur = Integer.valueOf((String) valeur);
           }else{
               pourGagner = Integer.valueOf((String) valeur);
           }
       }
    }

    @Override
    public Map<String, Object> enObjetJson() {

        Map<String, Object> objetJson = new HashMap<>();
        objetJson.put(_hauteur, hauteur.toString());
        objetJson.put(_largeur, largeur.toString());
        objetJson.put(_pourGagner, pourGagner.toString());

        return objetJson;
    }


  /*  public MParametres() {

   /*     genererListesDeChoix();
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

    }*/
}
