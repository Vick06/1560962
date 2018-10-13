package ca.cours5b5.vickielanglois.modeles;

import java.util.HashMap;
import java.util.Map;

import ca.cours5b5.vickielanglois.exceptions.ErreurSerialisation;
import ca.cours5b5.vickielanglois.serialisation.AttributSerialisable;

public class MParametresPartie {

    @AttributSerialisable
    public Integer hauteur;
    protected final String _hauteur = "hauteur";

    @AttributSerialisable
    public Integer largeur;
    protected final String _largeur = "largeur";

    @AttributSerialisable
    public Integer pourGagner;
    protected final String _pourGagner = "pourGagner";

    public static MParametresPartie aPartirMParametres(MParametres mParametres){



        /*
        Retourner une instance de MParametresPartie avec
        exactement les mêmes hauteur/largeur/pourGagner
        que le MParametres reçu en argument
         */
    }

    public MParametresPartie cloner(){


        /*
        Retourne une instance de MParametersPartie avec
        exactement les mêmes hauteur/largeur/pourGagner
         */
    }

    public MParametresPartie(){

    }

    public Integer getHauteur(){
        return hauteur;
    }

    public Integer getLargeur(){
        return largeur;
    }

    public Integer getPourGagner(){
        return pourGagner;
    }

    public void setHauteur(int hauteur){
        this.hauteur = hauteur;
    }

    public void setLargeur(int largeur){
        this.largeur = largeur;
    }

    public void setPourGagner(int pourGagner){
        this.pourGagner = pourGagner;
    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation{

    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurSerialisation{
        Map<String, Object> objetJson = new HashMap<>();

        objetJson.put(_hauteur, hauteur.toString());
        objetJson.put(_largeur, largeur.toString());
        objetJson.put(_pourGagner, pourGagner.toString());

        return objetJson;
    }



}
