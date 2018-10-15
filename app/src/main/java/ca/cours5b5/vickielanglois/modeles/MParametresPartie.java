package ca.cours5b5.vickielanglois.modeles;

import android.view.Display;

import java.util.HashMap;
import java.util.Map;

import ca.cours5b5.vickielanglois.exceptions.ErreurSerialisation;
import ca.cours5b5.vickielanglois.global.GConstantes;
import ca.cours5b5.vickielanglois.serialisation.AttributSerialisable;

public class MParametresPartie extends Modele{

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

        MParametresPartie mParametresPartie = mParametres.getParametresPartie().cloner();

        return mParametresPartie;
    }

    public MParametresPartie cloner(){

    MParametresPartie mParametresPartie = this;
    return mParametresPartie;
    }

    public MParametresPartie(){

        hauteur = GConstantes.HAUTEUR_PAR_DEFAUT;
        largeur = GConstantes.LARGEUR_PAR_DEFAUT;
        pourGagner = GConstantes.POUR_GAGNER_PAR_DEFAUT;

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

        for(Map.Entry<String, Object> entry: objetJson.entrySet()){
            String cle = entry.getKey();
            Object  valeur = entry.getValue();

            if(cle == this._hauteur){
                this.setHauteur((Integer)valeur);
            } else if(cle == this._largeur){
                this.setLargeur((Integer)valeur);
            }else if(cle == this._pourGagner){
                this.setPourGagner((Integer)valeur);
            }
        }
    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurSerialisation{
        Map<String, Object> objetJson = new HashMap<>();

        objetJson.put(this._hauteur, this.hauteur);
        objetJson.put(this._largeur, this.largeur);
        objetJson.put(this._pourGagner, this.pourGagner);

        return objetJson;
    }

}
