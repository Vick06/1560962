package ca.cours5b5.vickielanglois.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import ca.cours5b5.vickielanglois.controleurs.ControleurModeles;
import ca.cours5b5.vickielanglois.donnees.Disque;
import ca.cours5b5.vickielanglois.donnees.SauvegardeTemporaire;
import ca.cours5b5.vickielanglois.donnees.Serveur;
import ca.cours5b5.vickielanglois.donnees.Transition;
import ca.cours5b5.vickielanglois.modeles.MParametres;


public abstract class Activite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("atelier", "OnCreate.savedInstanceState :: Activite");

        initialiserControleurModeles(savedInstanceState);
        initialiserApplication();

    }

    protected void initialiserControleurModeles(Bundle savedInstanceState) {

        Intent intention = new Intent(this, APartieReseau.class);

        ControleurModeles.setSequenceDeChargement(
                new SauvegardeTemporaire(savedInstanceState),
                Disque.getInstance(), Serveur.getInstance(), new Transition(getIntent().getExtras()));

    }

    protected void initialiserApplication(){

        Disque.getInstance().setRepertoireRacine(getFilesDir());

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("atelier", "OnSaveInstance :: Activite");

        ControleurModeles.sauvegarderModeleDansCetteSource(MParametres.class.getSimpleName(),
                new SauvegardeTemporaire(outState));
    }

}
