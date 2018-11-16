package ca.cours5b5.vickielanglois.proxy;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.List;

import ca.cours5b5.vickielanglois.controleurs.Action;
import ca.cours5b5.vickielanglois.controleurs.interfaces.Fournisseur;

public class ProxyListe extends Proxy implements Fournisseur {

    private ChildEventListener childEventListener;
    private Query requete;
    private Action actionNouvelItem;
    private List<DatabaseReference> noeudsAjoutes;

    public ProxyListe(String cheminServeur){
        super(cheminServeur);
    }

    public void ajouterValeur(Object valeur){

    }

    public void connecterAuServeur(){
        super.connecterAuServeur();
    }

    private void creerListener(){

    }

    protected Query getRequete(){

        String chemin = "";
        DatabaseReference noeud = FirebaseDatabase.getInstance().getReference(chemin);

        Query requete = noeudServeur.orderByValue().limitToLast(10);

    }

    @Override
    public void deconnecterDuServeur(){

    }

    @Override
    public void detruireValeurs(){

    }


    @Override
    public void detruireValeurs() {

    }

}
