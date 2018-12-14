package ca.cours5b5.vickielanglois.activites;

import android.os.Bundle;

import ca.cours5b5.vickielanglois.R;
import ca.cours5b5.vickielanglois.controleurs.ControleurAction;
import ca.cours5b5.vickielanglois.controleurs.ControleurModeles;
import ca.cours5b5.vickielanglois.controleurs.interfaces.Fournisseur;
import ca.cours5b5.vickielanglois.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.vickielanglois.donnees.SauvegardeTemporaire;
import ca.cours5b5.vickielanglois.global.GCommande;
import ca.cours5b5.vickielanglois.modeles.MPartieIA;

public class AIA extends Activite implements Fournisseur{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ia);

        fournirActionTerminerIA();
    }

    private void fournirActionTerminerIA(){

        ControleurAction.fournirAction(this,
                GCommande.TERMINER_PARTIE_IA,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        quitterCetteActivite();

                    }
                });
    }

    @Override
    protected void onPause() {
        super.onPause();
        sauvegarderPartie();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String nomModele = MPartieIA.class.getSimpleName();
        ControleurModeles.sauvegarderModeleDansCetteSource(nomModele,
                new SauvegardeTemporaire(outState));
    }

    protected void sauvegarderPartie(){
        ControleurModeles.sauvegarderModele(MPartieIA.class.getSimpleName());
    }
}
