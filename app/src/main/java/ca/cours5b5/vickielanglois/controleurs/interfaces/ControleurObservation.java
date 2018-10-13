package ca.cours5b5.vickielanglois.controleurs.interfaces;

import java.util.Map;

import ca.cours5b5.vickielanglois.modeles.MParametres;
import ca.cours5b5.vickielanglois.modeles.MPartie;
import ca.cours5b5.vickielanglois.modeles.Modele;

public class ControleurObservation {

    private static Map<Modele, ListenerObservateur> observations;

    // L'Attribut est private: la vue doit obtenir le modèle par l'observation
    private static MPartie partie;

    static{

    }

    public static void observerModele(String nomModele, final ListenerObservateur listenerObservateur){

        observations.put(MParametres.instance, listenerObservateur);
        /*
         * Appeler le listener une première fois
         */


        }

    public static Map<Modele, ListenerObservateur> getObservations() {


    }


    }
}
