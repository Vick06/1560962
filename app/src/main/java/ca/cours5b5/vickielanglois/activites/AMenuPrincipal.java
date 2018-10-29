package ca.cours5b5.vickielanglois.activites;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.signin.SignIn;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.vickielanglois.R;
import ca.cours5b5.vickielanglois.controleurs.ControleurAction;
import ca.cours5b5.vickielanglois.controleurs.interfaces.Fournisseur;
import ca.cours5b5.vickielanglois.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.vickielanglois.global.GCommande;
import ca.cours5b5.vickielanglois.global.GConstantes;
import ca.cours5b5.vickielanglois.vues.VMenuPrincipal;

public class AMenuPrincipal extends Activite implements Fournisseur {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("atelier", "OnCreate.savedInstace state :: AMenuPrincipal");
        setContentView(R.layout.activity_menu_principal);

        fournirActions();
        fournirActionConnection();

    }

    private void fournirActions() {

        fournirActionOuvrirMenuParametres();

        fournirActionDemarrerPartie();
    }

    private void fournirActionOuvrirMenuParametres() {

        ControleurAction.fournirAction(this,
                GCommande.OUVRIR_MENU_PARAMETRES,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        transitionParametres();

                    }
                });
    }

    private void fournirActionDemarrerPartie() {

        ControleurAction.fournirAction(this,
                GCommande.DEMARRER_PARTIE,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        transitionPartie();

                    }
                });
    }

    private void transitionParametres(){

        Intent intentionParametres = new Intent(this, AParametres.class);
        startActivity(intentionParametres);

    }

    private void transitionPartie(){

        Intent intentionParametres = new Intent(this, APartie.class);
        startActivity(intentionParametres);

    }

    private void fournirActionConnection(){

        List<AuthUI.IdpConfig> fournisseursDeConnexion = new ArrayList<>();

        fournisseursDeConnexion.add(new AuthUI.IdpConfig.GoogleBuilder().build());
        fournisseursDeConnexion.add(new AuthUI.IdpConfig.EmailBuilder().build());
        fournisseursDeConnexion.add(new AuthUI.IdpConfig.PhoneBuilder().build());

        Intent intentionConnexion = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(fournisseursDeConnexion)
                .build();

        this.startActivityForResult(intentionConnexion, GConstantes.CONNEXION);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        if(requestCode == GConstantes.CONNEXION){
            if(resultCode == RESULT_OK){
                startActivity(SignedInActivity.createIntent(this, response));
                finish();
            }else{
                //A TROUVER
            }
        }
    }

}
