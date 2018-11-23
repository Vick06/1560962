package ca.cours5b5.vickielanglois.activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import ca.cours5b5.vickielanglois.donnees.SauvegardeTemporaire;
import ca.cours5b5.vickielanglois.donnees.Transition;
import ca.cours5b5.vickielanglois.controleurs.ControleurModeles;
import ca.cours5b5.vickielanglois.donnees.Disque;
import ca.cours5b5.vickielanglois.donnees.Serveur;
import ca.cours5b5.vickielanglois.modeles.MParametres;


public abstract class Activite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Examen3","Activiter :: onCreate.savedInstanceState");
        super.onCreate(savedInstanceState);

        initialiserControleurModeles(savedInstanceState);

        initialiserApplication();

        prechargerLesModeles();

    }


    private void prechargerLesModeles() {
        Log.d("Examen3","Activiter :: prechargerLesModeles");
        ControleurModeles.prechargerModele(MParametres.class.getSimpleName());

    }


    protected void initialiserControleurModeles(Bundle savedInstanceState) {
        Log.d("Examen3","Activiter :: initialiserControleurModeles");
        ControleurModeles.setSequenceDeChargement(
                new SauvegardeTemporaire(savedInstanceState),
                new Transition(getIntent().getExtras()),
                Serveur.getInstance(),
                Disque.getInstance());

    }


    protected void initialiserApplication(){
        Log.d("Examen3","Activiter :: initialiserApplication");
        Disque.getInstance().setRepertoireRacine(getFilesDir());

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d("Examen3","Activiter :: savedInstanceState");
        super.onSaveInstanceState(outState);

        ControleurModeles.sauvegarderModeleDansCetteSource(MParametres.class.getSimpleName(),
                new SauvegardeTemporaire(outState));

    }


    protected void quitterCetteActivite(){
        Log.d("Examen3","Activiter :: quitterCetteActivite");
        finish();
    }

}