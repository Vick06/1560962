package ca.cours5b5.vickielanglois.activites;

import android.os.Bundle;
import android.util.Log;

import ca.cours5b5.vickielanglois.R;
import ca.cours5b5.vickielanglois.controleurs.ControleurAction;
import ca.cours5b5.vickielanglois.controleurs.ControleurModeles;
import ca.cours5b5.vickielanglois.controleurs.interfaces.Fournisseur;
import ca.cours5b5.vickielanglois.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.vickielanglois.global.GCommande;
import ca.cours5b5.vickielanglois.modeles.MPartie;

public class APartie extends Activite implements Fournisseur {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Examen3","APartie :: onCreate.savedInstanceState");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partie);

        fournirActionTerminerPartie();

    }


    private void fournirActionTerminerPartie() {
        Log.d("Examen3","APartie :: fournirActionTErminerPartie");
        ControleurAction.fournirAction(this,
                GCommande.TERMINER_PARTIE,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        quitterCetteActivite();

                    }
                });
    }


    @Override
    protected void onPause() {
        Log.d("Examen3","APartie :: onPause");
        super.onPause();
        sauvegarderPartie();
    }


    protected void sauvegarderPartie(){
        Log.d("Examen3","APartie :: sauvegarderPartie");
        ControleurModeles.sauvegarderModele(MPartie.class.getSimpleName());
    }


}