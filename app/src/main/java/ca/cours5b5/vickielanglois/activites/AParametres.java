package ca.cours5b5.vickielanglois.activites;


import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import ca.cours5b5.vickielanglois.R;
import ca.cours5b5.vickielanglois.controleurs.ControleurAction;
import ca.cours5b5.vickielanglois.controleurs.ControleurModeles;
import ca.cours5b5.vickielanglois.controleurs.interfaces.Fournisseur;
import ca.cours5b5.vickielanglois.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.vickielanglois.global.GCommande;
import ca.cours5b5.vickielanglois.modeles.MParametres;
import ca.cours5b5.vickielanglois.modeles.MPartie;
import ca.cours5b5.vickielanglois.modeles.MPartieIA;
import ca.cours5b5.vickielanglois.vues.VGrille;


public class AParametres extends Activite implements Fournisseur{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Examen3","AParametre :: onCreate.savedInstanceState");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);

        fournirActions();

    }


    private void fournirActions() {
        Log.d("Examen3","AParametre :: fournirAction");
        ControleurAction.fournirAction(this,
                GCommande.EFFACER_PARTIE_COURANTE,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        ControleurModeles.detruireModele(MPartie.class.getSimpleName());
                        ControleurModeles.detruireModele(MPartieIA.class.getSimpleName());
                        //VGrille.desactiverEntetes = new ArrayList<>();


                    }
                });
    }

    @Override
    protected void onPause() {
        Log.d("Examen3","AParametre :: onPause");
        super.onPause();

        ControleurModeles.sauvegarderModele(MParametres.class.getSimpleName());

    }


}
