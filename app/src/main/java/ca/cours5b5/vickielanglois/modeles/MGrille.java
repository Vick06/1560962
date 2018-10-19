package ca.cours5b5.vickielanglois.modeles;

import android.view.Display;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ca.cours5b5.vickielanglois.exceptions.ErreurSerialisation;
import ca.cours5b5.vickielanglois.global.GCouleur;

public class MGrille extends Modele{

    private List<MColonne> colonnes;
    private int hauteur;

    public MGrille(int largeur, int hauteur){
        this.hauteur = hauteur;
        initialiserColonnes(largeur);
    }

    private void initialiserColonnes(int largeur){

        colonnes = new ArrayList<>();

        for(int i = 0; i < largeur; i++){

            colonnes.add(new MColonne());
        }

    }

    public List<MColonne> getColonnes(){
      return colonnes;
    }

    public void placerJeton(int colonne, GCouleur couleur){
        MColonne curColonne = colonnes.get(colonne);
        int columnMax = curColonne.getJetons().size();
        if(columnMax < this.hauteur) {
            colonnes.get(colonne).placerJeton(couleur);
        }
    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation{
        /*
         * Inutilise
         */
    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurSerialisation{
        /*
         * Inutilise
         */
        return null;
    }

}
