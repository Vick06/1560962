package ca.cours5b5.vickielanglois.activites;

import android.os.Bundle;
import android.util.Log;

import ca.cours5b5.vickielanglois.R;
import ca.cours5b5.vickielanglois.controleurs.ControleurModeles;
import ca.cours5b5.vickielanglois.controleurs.interfaces.Fournisseur;
import ca.cours5b5.vickielanglois.modeles.MParametres;

public class AParametres extends Activite implements Fournisseur{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("atelier", "OnCreate.savedInstanceState :: AParametres");
        setContentView(R.layout.activity_parametres);

    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("atelier", "OnPause :: AParametres");

        ControleurModeles.sauvegarderModele(MParametres.class.getSimpleName());

    }

}
