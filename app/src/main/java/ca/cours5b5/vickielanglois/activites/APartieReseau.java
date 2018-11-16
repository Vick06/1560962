package ca.cours5b5.vickielanglois.activites;

import android.os.Bundle;
import android.util.Log;

import ca.cours5b5.vickielanglois.R;
import ca.cours5b5.vickielanglois.controleurs.ControleurPartieReseau;
import ca.cours5b5.vickielanglois.controleurs.interfaces.Fournisseur;

public class APartieReseau extends  Activite implements Fournisseur {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d("atelier", "OnCreate.savedInstance state :: APartieReseau");
        setContentView(R.layout.activity_partie_reseau);
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("atelier", "OnPause :: APartieReseau");
        ControleurPartieReseau.getInstance().detruireSauvegardeServeur();
        ControleurPartieReseau.getInstance().deconnecterDuServeur();
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("atelier", "OnResume.savedInstance state :: APartieReseau");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("atelier", "OnDestroy.savedInstance state :: APartieReseau");
    }
}
