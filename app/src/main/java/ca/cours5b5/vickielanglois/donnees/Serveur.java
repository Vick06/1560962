package ca.cours5b5.vickielanglois.donnees;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;

public class Serveur extends SourceDeDonnees {

    private Serveur(){}

    private static final Serveur instance = new Serveur();

    public static Serveur getInstance(){
        return instance;
    }

    @Override
    public Map<String, Object> chargerModele(String cheminSauvegarde) {
        return null;
    }

    @Override
    public void sauvegarderModele(String cheminSauvegarde, Map<String, Object> objetJson) {
        Log.d("Atelier 11", "sauvegarderModele");
        DatabaseReference noeud = FirebaseDatabase.getInstance().getReference(cheminSauvegarde);
        noeud.setValue(objetJson);
    }
}
