package ca.cours5b5.vickielanglois.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import ca.cours5b5.vickielanglois.R;
import ca.cours5b5.vickielanglois.controleurs.Action;
import ca.cours5b5.vickielanglois.controleurs.ControleurAction;
import ca.cours5b5.vickielanglois.global.GCommande;
import ca.cours5b5.vickielanglois.usagers.UsagerCourant;


public class VMenuPrincipal extends Vue {



    public VMenuPrincipal(Context context) {
        super(context);
    }

    public VMenuPrincipal(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VMenuPrincipal(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Button boutonParametres;
    private Action actionParametres;

    private Button boutonPartie;
    private Action actionPartie;

    private Button boutonPartieReseau;
    private Action actionPartieReseau;

    private Button boutonConnexion;
    private Action actionConnexion;
    private Action actionDeconnexion;

    private Button boutonIA;
    private Action actionIA;


    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();

        recupererControles();

        demanderActions();

        installerListeners();

        ajusterTexteConnexionDeconnexion();

        if(!UsagerCourant.siUsagerConnecte()){
            Toast.makeText(getContext(), R.string.Message, Toast.LENGTH_LONG).show();
        }

    }


    private void recupererControles() {

        boutonParametres = findViewById(R.id.bouton_parametres);

        boutonPartie = findViewById(R.id.bouton_partie);

        boutonPartieReseau = findViewById(R.id.bouton_partie_reseau);

        boutonConnexion = findViewById(R.id.bouton_connexion);

        boutonIA = findViewById(R.id.bouton_IA);

    }

    private void demanderActions() {

        actionParametres = ControleurAction.demanderAction(GCommande.OUVRIR_MENU_PARAMETRES);

        actionPartie = ControleurAction.demanderAction(GCommande.DEMARRER_PARTIE);

        actionPartieReseau = ControleurAction.demanderAction(GCommande.JOINDRE_OU_CREER_PARTIE_RESEAU);

        actionConnexion = ControleurAction.demanderAction(GCommande.CONNEXION);

        actionDeconnexion = ControleurAction.demanderAction(GCommande.DECONNEXION);

        actionIA = ControleurAction.demanderAction(GCommande.DEMARRER_PARTIE_IA);


    }


    private void installerListeners() {

       /**/

        boutonPartie.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if(UsagerCourant.siUsagerConnecte()){
                    actionPartie.executerDesQuePossible();
                }else{
                    Toast.makeText(getContext(), R.string.Message, Toast.LENGTH_LONG).show();

                    actionConnexion.executerDesQuePossible();
                    boutonConnexion.setText(R.string.deconnexion);

                    if(UsagerCourant.siUsagerConnecte()){
                        actionPartie.executerDesQuePossible();
                    }
                }
            }
        });

        boutonParametres.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                actionParametres.executerDesQuePossible();
            }
        });

        boutonPartieReseau.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if(UsagerCourant.siUsagerConnecte()){
                    actionPartieReseau.executerDesQuePossible();
                }else{
                    Toast.makeText(getContext(), R.string.Message, Toast.LENGTH_LONG).show();
                    actionConnexion.executerDesQuePossible();
                    //actionConnexion.notify();
                    boutonConnexion.setText(R.string.deconnexion);

                    if(UsagerCourant.siUsagerConnecte()){
                        actionPartieReseau.executerDesQuePossible();
                    }
                }
            }
        });

        boutonConnexion.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!UsagerCourant.siUsagerConnecte()){

                    actionConnexion.executerDesQuePossible();
                    boutonConnexion.setText(R.string.deconnexion);

                }else{

                    actionDeconnexion.executerDesQuePossible();
                    boutonConnexion.setText(R.string.connexion);

                }

            }
        });

        boutonIA.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                if(UsagerCourant.siUsagerConnecte()){
                    actionIA.executerDesQuePossible();
                }else{
                    Toast.makeText(getContext(), R.string.Message, Toast.LENGTH_LONG).show();
                    actionConnexion.executerDesQuePossible();
                    boutonConnexion.setText(R.string.deconnexion);

                    if(UsagerCourant.siUsagerConnecte()){
                        actionIA.executerDesQuePossible();
                    }
                }
            }
        });
    }

    private void ajusterTexteConnexionDeconnexion() {
        if(UsagerCourant.siUsagerConnecte()){

            boutonConnexion.setText(R.string.deconnexion);

        }else{

            boutonConnexion.setText(R.string.connexion);

        }
    }



}
