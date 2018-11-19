package ca.cours5b5.vickielanglois.activites;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.firebase.ui.auth.AuthUI;
import java.util.ArrayList;
import java.util.List;
import ca.cours5b5.vickielanglois.R;
import ca.cours5b5.vickielanglois.controleurs.ControleurAction;
import ca.cours5b5.vickielanglois.controleurs.interfaces.Fournisseur;
import ca.cours5b5.vickielanglois.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.vickielanglois.global.GCommande;
import ca.cours5b5.vickielanglois.global.GConstantes;
import ca.cours5b5.vickielanglois.modeles.MPartieReseau;

public class AMenuPrincipal extends Activite implements Fournisseur {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("atelier", "OnCreate.savedInstance state :: AMenuPrincipal");
        setContentView(R.layout.activity_menu_principal);

        fournirActions();


    }

    private void fournirActions() {
        Log.d("atelier 11", "fournirActions");

        fournirActionOuvrirMenuParametres();

        fournirActionDemarrerPartie();

        fournirActionConnection();

        fournirActionJoindreOuCreerPartieReseau();

    }

    private void fournirActionOuvrirMenuParametres() {
        Log.d("atelier 11", "fournirActionOuvrirMenuParametres");
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
        Log.d("atelier 11", "fournirActionDemarrerPartie");
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
        Log.d("atelier 11", "transitionPartie");
        Intent intentionParametres = new Intent(this, AParametres.class);
        startActivity(intentionParametres);

    }

    private void transitionPartie(){
        Log.d("atelier 11", "transitionPartie");
        Intent intentionParametres = new Intent(this, APartie.class);
        startActivity(intentionParametres);

    }

    private void fournirActionConnection(){
        Log.d("atelier 11", "fournirActionConnection");

        ControleurAction.fournirAction(this, GCommande.CONNEXION,
                new ListenerFournisseur() {
            @Override
            public void executer(Object... args) {
                Log.d("atelier 11", "fournirActionConnection");
                transitionConnexion();

            }
        });
    }

    private void transitionConnexion() { // #connection
        Log.d("atelier 11", "transitionConnexion");

        List<AuthUI.IdpConfig> fournisseursDeConnexion = new ArrayList<>();

        fournisseursDeConnexion.add(new AuthUI.IdpConfig.GoogleBuilder().build());
        fournisseursDeConnexion.add(new AuthUI.IdpConfig.EmailBuilder().build());
        fournisseursDeConnexion.add(new AuthUI.IdpConfig.PhoneBuilder().build());

        Intent intentionConnexion = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(fournisseursDeConnexion)
                .build();

        this.startActivityForResult(intentionConnexion, GConstantes.CODE_DE_CONNEXION);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        Log.d("atelier 11", "onActivityResult");

        if(requestCode == GConstantes.CODE_DE_CONNEXION){
            if(resultCode == RESULT_OK){
                Log.d("atelier 11", "Connexion reussi");

            }else{
                Log.d("atelier 11", "Connexion echouee");
            }
        }
    }

    private void fournirActionJoindreOuCreerPartieReseau(){

        ControleurAction.fournirAction(this, GCommande.JOINDRE_OU_CREER_PARTIE_RESEAU,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {
                        transitionPartieReseau();
                    }
                });
    }

    private void transitionPartieReseau(){
        Log.d("atelier 12", "transitionPartieReseau");

        Intent intent = new Intent(this, APartieReseau.class);
        intent.putExtra(MPartieReseau.class.getSimpleName(), GConstantes.FIXME_JSON_PARTIE_RESEAU);
        startActivity(intent);

    }

}
