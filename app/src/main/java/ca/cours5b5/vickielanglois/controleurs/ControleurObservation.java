package ca.cours5b5.vickielanglois.controleurs;

import java.util.HashMap;
import java.util.Map;

import ca.cours5b5.vickielanglois.modeles.MParametres;
import ca.cours5b5.vickielanglois.modeles.MParametresPartie;
import ca.cours5b5.vickielanglois.modeles.MPartie;
import ca.cours5b5.vickielanglois.modeles.Modele;
import ca.cours5b5.vickielanglois.controleurs.interfaces.ListenerObservateur;

public class ControleurObservation {

    private static Map<Modele, ListenerObservateur> observations;
    private static MPartie partie;

    static{
        observations = new HashMap<>();
    }

    public static void observerModele(String nomModele, final ListenerObservateur listenerObservateur){

        Modele modele = null;

        if(nomModele.equals("MPartie")) {
            partie = new MPartie(MParametresPartie.aPartirMParametres(MParametres.instance));
            observations.put(ControleurObservation.partie, listenerObservateur);
            modele = ControleurObservation.partie;
        }else if(nomModele.equals("MParametres")) {
            modele = MParametres.instance;
            observations.put(modele, listenerObservateur);
        }

        lancerObservation(modele);
    }

    public static void lancerObservation(Modele modele) {

        /*
         *verifier si le listener existe pour ce modele
         * Appeler le listener
         */

        ListenerObservateur listenerObservateur = observations.get(modele);
        listenerObservateur.reagirNouveauModele(modele);
    }

}
