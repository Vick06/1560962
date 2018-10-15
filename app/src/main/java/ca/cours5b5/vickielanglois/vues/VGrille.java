package ca.cours5b5.vickielanglois.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.vickielanglois.modeles.MParametres;
import ca.cours5b5.vickielanglois.modeles.MPartie;

public class VGrille extends GridLayout{
    public VGrille(Context context) {
        super(context);
    }

    public VGrille(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VGrille(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private int nombreRangees;


    private class Colonne extends ArrayList<VCase>{}

    private List<VEntete> entetes;
    private List<Colonne> lesCases;

    @Override
    protected  void onFinishInflate(){
        super.onFinishInflate();
    }

    void creerGrille(int hauteur, int largeur{

        entetes = new ArrayList<>();
        lesCases = new ArrayList<>();
        nombreRangees = hauteur;

        initialiserColonnes(largeur);
        ajouterEnTetes(largeur);
        ajouterCases(hauteur, largeur);

    }

    private void initialiserColonnes(int largeur){

        for(int i = 0; i < largeur; i++){
            lesCases.add(new Colonne());
        }

    }

    private void ajouterEnTetes(int largeur){

        for(int i = 0; i < largeur; i++) {
            VEntete entete = new VEntete(getContext());

            //Vue
            this.addView(entete, getMiseEnPageEntete(i));

            //Ajout de entête
            entetes.add(entete);

        }

    }

    private LayoutParams getMiseEnPageEntete(int colonne){





        return colonne;

    }

    private void ajouterCases(int hauteur, int largeur){

        for(int ligne = 0; largeur < ligne; ligne++){
            ligne = new Ligne();
            for(int colonne = 0; hauteur < colonne; colonne++){
                colonne = new Colonne();
            }
        }

    }

    private LayoutParams getMiseEnPageCase(int rangee, int colonne){

        LayoutParams mesParams = new LayoutParams(specRangee, specColonne);

        mesParams.width = 0;
        mesParams.height = 0;
        mesParams.setGravity(Gravity.FILL);

        mesParams.rightMargin = 5;
        mesParams.leftMargin = 5;

        GridLayout grille = //

        grille.addView(grille, mesParams);

    }
}
