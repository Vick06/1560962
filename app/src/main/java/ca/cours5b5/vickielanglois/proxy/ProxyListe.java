package ca.cours5b5.vickielanglois.proxy;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.vickielanglois.controleurs.Action;
import ca.cours5b5.vickielanglois.controleurs.ControleurAction;
import ca.cours5b5.vickielanglois.controleurs.interfaces.Fournisseur;
import ca.cours5b5.vickielanglois.global.GCommande;
import ca.cours5b5.vickielanglois.global.GConstantes;

public class ProxyListe extends Proxy implements Fournisseur {

    private ChildEventListener childEventListener;
    private Query requete;
    private Action actionNouvelItem;
    private List<DatabaseReference> noeudsAjoutes;

    public ProxyListe(String cheminServeur){
        super(cheminServeur);

        noeudsAjoutes = new ArrayList<>();
        getRequete();
    }

    public void setActionNouvelItem(GCommande commande){

        actionNouvelItem = ControleurAction.demanderAction(commande);
    }

    public void ajouterValeur(Object valeur){

        DatabaseReference nouveauNoeud = this.noeudServeur.push();
        noeudsAjoutes.add(nouveauNoeud);
        nouveauNoeud.setValue(valeur);

    }

    public void connecterAuServeur(){

        super.connecterAuServeur();
        creerListener();

        requete = noeudServeur;
        requete.addChildEventListener(childEventListener);
    }

    private void creerListener(){

        childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                Object valeurAjoute = dataSnapshot.getValue();
                actionNouvelItem.setArguments(valeurAjoute);
                actionNouvelItem.executerDesQuePossible();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

    }

    protected Query getRequete(){

        requete.orderByKey().limitToLast(GConstantes.NOMBER_DE_VALEURS_A_CHARGER_DU_SERVEUR_PAR_DEFAUT);
        return requete;

    }

    @Override
    public void deconnecterDuServeur(){

        requete.removeEventListener(childEventListener);
        noeudsAjoutes.clear();
        super.deconnecterDuServeur();

    }

    @Override
    public void detruireValeurs(){

        noeudServeur.removeValue();
        noeudsAjoutes.clear();

    }

}
