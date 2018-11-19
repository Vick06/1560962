package ca.cours5b5.vickielanglois.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import ca.cours5b5.vickielanglois.R;
import ca.cours5b5.vickielanglois.controleurs.Action;
import ca.cours5b5.vickielanglois.controleurs.ControleurAction;
import ca.cours5b5.vickielanglois.global.GCommande;
import ca.cours5b5.vickielanglois.usagers.UsagerCourant;


public class VMenuPrincipal extends Vue {

    private Button boutonParametres;
    private Action actionParametres;

    private Button boutonPartie;
    private Action actionPartie;

    private Button boutonPartieReseau;
    private Action actionPartieReseau;

    private Button boutonConnexion;
    private Action actionConnexion;
    private Action actionDeconnexion;

    public VMenuPrincipal(Context context) {
        super(context);
    }

    public VMenuPrincipal(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VMenuPrincipal(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();

        Log.d("atelier", "OnFinishInflate :: VMenuPrincipal");

        recupererControles();
        demanderActions();
        installerListeners();

    }

    private void recupererControles() {

        boutonPartie = findViewById(R.id.bouton_partie);
        boutonPartieReseau = findViewById(R.id.button_online);
        boutonParametres = findViewById(R.id.bouton_parametres);
        boutonConnexion = findViewById(R.id.bouton_connexion);

    }

    private void demanderActions() {

        actionPartie = ControleurAction.demanderAction(GCommande.DEMARRER_PARTIE);
        actionPartieReseau = ControleurAction.demanderAction(GCommande.JOINDRE_OU_CREER_PARTIE_RESEAU);
        actionParametres = ControleurAction.demanderAction(GCommande.OUVRIR_MENU_PARAMETRES);
        actionConnexion = ControleurAction.demanderAction(GCommande.CONNEXION);
       // actionDeconnexion = ControleurAction.demanderAction(GCommande.DECONNEXION);

    }

    private void installerListeners() {

        installerListenerPartie();
        installerListenerPartieReseau();
        installerListenerParametres();
        installerListenerConnexion();
    }

    private void installerListenerPartie() {

        boutonPartie.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                actionPartie.executerDesQuePossible();
            }
        });

    }

    private void installerListenerPartieReseau(){

        boutonPartieReseau.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                actionPartieReseau.executerDesQuePossible();
            }
        });
    }

    private void installerListenerParametres() {

        boutonParametres.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                actionParametres.executerDesQuePossible();
            }
        });

    }

    private void installerListenerConnexion(){

        boutonConnexion.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                actionConnexion.executerDesQuePossible();
            }
        });
    }

    private void installerListenerDeconnexion(){

        boutonConnexion.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                actionDeconnexion.executerDesQuePossible();
            }
        });
    }
}
