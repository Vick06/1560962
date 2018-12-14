package ca.cours5b5.vickielanglois.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.util.Log;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.vickielanglois.R;
import ca.cours5b5.vickielanglois.controleurs.ControleurAction;
import ca.cours5b5.vickielanglois.controleurs.interfaces.Fournisseur;
import ca.cours5b5.vickielanglois.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.vickielanglois.global.GCommande;
import ca.cours5b5.vickielanglois.usagers.UsagerCourant;

import static ca.cours5b5.vickielanglois.global.GConstantes.CODE_CONNEXION_FIREBASE;

public class AMenuPrincipal extends Activite implements Fournisseur {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Examen3","AMenuPrincipal :: onCreate.savedInstanceState");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        fournirActions();

        if(!UsagerCourant.siUsagerConnecte()){
            Snackbar.make(findViewById(R.id.Menu), R.string.Message, Snackbar.LENGTH_LONG).show();
        }

    }


    private void fournirActions() {
        Log.d("Examen3","AMenuPrincipal :: fournirAction");

        fournirActionParametres();

        fournirActionDemarrerPartie();

        fournirActionConnexion();

        fournirActionDeconnexion();

        fournirActionJoindreOuCreerPartieReseau();

        fournirActionDemarrerIa();

    }


    private void fournirActionJoindreOuCreerPartieReseau() {
        Log.d("Examen3","AMenuPrincipal ::fournirACtionJoindreOuCreerPartieReseau");

        ControleurAction.fournirAction(this,
                GCommande.JOINDRE_OU_CREER_PARTIE_RESEAU,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                            transitionAttendreAdversaire();
                    }
                });
    }


    private void fournirActionDeconnexion() {
        Log.d("Examen3","AMenuPrincipal :: fournirActionDeconnexion");

        ControleurAction.fournirAction(this,
                GCommande.DECONNEXION,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        effectuerDeconnexion();

                    }
                });
    }


    private void fournirActionConnexion() {
        Log.d("Examen3","AMenuPrincipal :: fournirActionConnexion");

        ControleurAction.fournirAction(this,
                GCommande.CONNEXION,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        effectuerConnexion();

                    }
                });
    }

    private void fournirActionDemarrerPartie() {
        Log.d("Examen3","AMenuPrincipal :: fournirActionDemarrerPartie");

        ControleurAction.fournirAction(this,
                GCommande.DEMARRER_PARTIE,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        transitionPartie();

                    }
                });
    }

    private void fournirActionDemarrerIa(){
        ControleurAction.fournirAction(this, GCommande.DEMARRER_PARTIE_IA, new ListenerFournisseur() {
            @Override
            public void executer(Object... args) {
                transitionIA();
            }
        });
    }

    private void fournirActionParametres() {
        Log.d("Examen3","AMenuPrincipal :: fournirActionParametres");
        ControleurAction.fournirAction(this,
                GCommande.OUVRIR_MENU_PARAMETRES,
                new ListenerFournisseur() {

                    @Override
                    public void executer(Object... args) {

                        transitionParametres();

                    }
                });
    }

    private void transitionAttendreAdversaire() {
        Log.d("Examen3","AMenuPrincipal :: transitionAttendreAdversaire");

        Intent intentionAttendreAdversaire = new Intent(this, AEnAttenteAdversaire.class);

        startActivity(intentionAttendreAdversaire);

    }


    private void transitionParametres() {
        Log.d("Examen3","AMenuPrincipal :: transitionParametres");

        Intent intentionParametres = new Intent(this, AParametres.class);
        startActivity(intentionParametres);

    }


    private void transitionPartie() {
        Log.d("Examen3","AMenuPrincipal :: transitionPartie");
        Intent intentionPartie = new Intent(this, APartie.class);
        startActivity(intentionPartie);

    }

    private void transitionIA(){
        Intent intentionIA = new Intent(this, AIA.class);
        startActivity(intentionIA);
    }


    private void effectuerConnexion() {
        Log.d("Examen3","AMenuPrincipal :: effectuerConnexion");

        List<AuthUI.IdpConfig> fournisseursDeConnexion = new ArrayList<>();

        fournisseursDeConnexion.add(new AuthUI.IdpConfig.GoogleBuilder().build());
        fournisseursDeConnexion.add(new AuthUI.IdpConfig.EmailBuilder().build());
        fournisseursDeConnexion.add(new AuthUI.IdpConfig.PhoneBuilder().build());

        Intent intentionConnexion = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(fournisseursDeConnexion)
                .build();

        this.startActivityForResult(intentionConnexion, CODE_CONNEXION_FIREBASE);

    }


    public void effectuerDeconnexion() {
        Log.d("Examen3","AMenuPrincipal :: effectuerDeconnexion");

        AuthUI.getInstance()
                .signOut(this)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    public void onComplete(@NonNull Task<Void> task) {

                        // Rien

                        Snackbar.make(findViewById(R.id.Menu), R.string.Message, Snackbar.LENGTH_LONG).show();

                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("Examen3","AMenuPrincipal :: onActivityResult");
        if (requestCode == CODE_CONNEXION_FIREBASE) {

            //IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {

                // Connexion réussie

            } else {

                // connexion échouée
            }
        }
    }


}
