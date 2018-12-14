package ca.cours5b5.vickielanglois.controleurs;

import ca.cours5b5.vickielanglois.global.GCommande;
import ca.cours5b5.vickielanglois.global.GCouleur;

public class ControleurPartieIA {

    private ControleurPartieIA(){

    }

    private static final ControleurPartieIA instance = new ControleurPartieIA();
    public static ControleurPartieIA getInstance(){return instance;}

    public void gagnerPartie(GCouleur couleurGagnante){

        Action actionTerminerPartieIA = ControleurAction.demanderAction(GCommande.TERMINER_PARTIE_IA);

        Action actionAfficherMessage = ControleurAction.demanderAction(GCommande.AFFICHER_MESSAGE_GAGNANT);


        actionAfficherMessage.setArguments(couleurGagnante,
                actionTerminerPartieIA);

        actionAfficherMessage.executerDesQuePossible();

    }
}
