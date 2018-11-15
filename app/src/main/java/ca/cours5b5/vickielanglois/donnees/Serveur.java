package ca.cours5b5.vickielanglois.donnees;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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

        noeud.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Map<String, Object> objetJson = (Map<String, Object>) dataSnapshot.getValue();

                    //Donnees lues
                }else{
                    // Pas de donnees dans ce noeud
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                    // Erreur de lecture
            }
        });

        //?????????
        noeud.setValue(objetJson);
    }

    //Immplementer automatiquement
    @Override
    public void chargerModele(String cheminSauvegarde, ListenerChargement listenerChargement) {

    }
}
