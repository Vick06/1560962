package ca.cours5b5.vickielanglois.vues;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.vickielanglois.controleurs.Action;
import ca.cours5b5.vickielanglois.controleurs.ControleurAction;
import ca.cours5b5.vickielanglois.global.GCommande;
import ca.cours5b5.vickielanglois.global.GCouleur;
import ca.cours5b5.vickielanglois.modeles.MColonne;
import ca.cours5b5.vickielanglois.modeles.MGrille;
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

    private int nombreRangees; //?


    private class Colonne extends ArrayList<VCase>{}

    private List<VEntete> entetes;
    private List<Colonne> lesCases;
   // private VCase[][] cases;
    private Action action;

    @Override
    protected  void onFinishInflate(){
        super.onFinishInflate();

    }

    void creerGrille(int hauteur, int largeur){

        //entetes = new ArrayList<>();
       // lesCases = new ArrayList<>();
       // nombreRangees = hauteur;

        initialiserColonnes(largeur);
        ajouterEnTetes(largeur);
        ajouterCases(hauteur, largeur);
        demanderActionEntete();

    }

    private void initialiserColonnes(int largeur){
        lesCases = new ArrayList<>();
        for(int i = 0; i < largeur; i++){
            lesCases.add(new Colonne());
        }

    }

    private LayoutParams getMiseEnPageEntete(int colonne){

        Spec specRangee = GridLayout.spec(0, 3.0f);
        Spec specColonne = GridLayout.spec(colonne, 2.0f);

        LayoutParams mesParams = new LayoutParams(specRangee, specColonne);

        mesParams.width = 0;
        mesParams.height = 0;
        mesParams.setGravity(Gravity.FILL);

        mesParams.rightMargin = 5;
        mesParams.leftMargin = 5;

        return mesParams;

    }

    private void ajouterCases(int hauteur, int largeur){

        for(int i = 0; i < largeur; i++) {
            Colonne colonne = new Colonne();
            for (int j = hauteur; j > 0; j--) {

                VCase vCase = new VCase(getContext(), j - (2 * (j - hauteur)) - hauteur, i);

                this.addView(vCase, getMiseEnPageCase(j, i));
                colonne.add(vCase);
                Log.d("Atelier06", "cases" + i + j);
            }
            lesCases.add(i, colonne);
        }
    }

    private LayoutParams getMiseEnPageCase(int rangee, int colonne){

        Spec specRangee = GridLayout.spec(rangee, 1.0f);
        Spec specColonne = GridLayout.spec(colonne, 1.0f);

        LayoutParams mesParams = new LayoutParams(specRangee, specColonne);

        mesParams.width = 0;
        mesParams.height = 0;
        mesParams.setGravity(Gravity.FILL);

        mesParams.rightMargin = 5;
        mesParams.leftMargin = 5;

        return mesParams;

    }


    private void demanderActionEntete(){

       action = ControleurAction.demanderAction(GCommande.JOUER_COUP_ICI);

    }

    private void ajouterEnTetes(int largeur){

        this.entetes = new ArrayList<>();
        VEntete entete;

        for(int i = 0; i < largeur; i++){
            entete = new VEntete(this.getContext(), i);
            this.addView(entete, this.getMiseEnPageEntete(i));
            installerListenerEntete(entete, i);
            this.entetes.add(entete);

        }

    }

    private void installerListenerEntete(VEntete entete, final int colonne){

        entete.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("Atelier 07", "VGrilles.onClick");


                action.setArgs(colonne);
                action.executerDesQuePossible();
            }
        });

    }

    void afficherJetons(MGrille grille){

        for(int i = 0; i < grille.getColonnes().size(); i++){
            for(int j = 0; j < grille.getColonnes().get(i).getJetons().size(); j++){
                afficherJeton(i, j, grille.getColonnes().get(i).getJetons().get(j));
            }
        }
    }

    private void afficherJeton(int colonne, int rangee, GCouleur jeton){

        VCase vCase = lesCases.get(colonne).get(rangee);
        vCase.afficherJeton(jeton);
    }
}
