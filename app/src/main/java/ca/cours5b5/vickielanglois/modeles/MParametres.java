package ca.cours5b5.vickielanglois.modeles;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.cours5b5.vickielanglois.exceptions.ErreurSerialisation;
import ca.cours5b5.vickielanglois.global.GConstantes;
import ca.cours5b5.vickielanglois.serialisation.AttributSerialisable;

public class MParametres extends Modele {

    // FIXME: c'est temporaire ; on va écrire un gestionnaire de modèles à l'Atelier07
    public static MParametres instance = new MParametres();


    static{
        Log.d("Atelier04", MParametres.class.getSimpleName() + "::static");

        //instance = new MParametres();
    }

    @AttributSerialisable
    public MParametresPartie parametresPartie;
    private String _parametresPartie = "parametresPartie";

    private List<Integer> choixHauteur;
    private List<Integer> choixLargeur;
    private List<Integer> choixPourGagner;

    public MParametres(){
       genererListesDeChoix();
       parametresPartie = new MParametresPartie();
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

    public MParametresPartie getParametresPartie() {
        return parametresPartie;
    }

    private void genererListesDeChoix(){
        genererListeChoixHauteur();
        genererListeChoixLargeur();
        genererListeChoixPourGagner();
    }

    private List<Integer> genererListeChoix(int min, int max){
        List<Integer> listeChoix = new ArrayList<>();

        for(int i = min; i <= max; i++){
            listeChoix.add(i);
        }

        return listeChoix;
    }

    private void genererListeChoixHauteur(){
        choixHauteur = genererListeChoix(GConstantes.HAUTEUR_MIN, GConstantes.HAUTEUR_MAX);
    }

    private void genererListeChoixLargeur(){
        choixLargeur = genererListeChoix(GConstantes.LARGEUR_MIN, GConstantes.LARGEUR_MAX);
    }

    private void genererListeChoixPourGagner(){
        choixPourGagner = genererListeChoix(GConstantes.POUR_GAGNER_MIN, GConstantes.POUR_GAGNER_MAX);
    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation{
        for(Map.Entry<String, Object> entry : objetJson.entrySet()){

            String chaineValeur = (String) entry.getValue();
            Object valeur = entry.getValue();

            if(chaineValeur == _parametresPartie){
                parametresPartie.aPartirObjetJson((Map<String, Object>) valeur);
            }
        }
    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurSerialisation {
        Map<String, Object> objetJson = new HashMap<>();

        objetJson.put(this._parametresPartie, this.parametresPartie);

        return objetJson;
    }
}
