package ca.cours5b5.vickielanglois.controleurs;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.cours5b5.vickielanglois.controleurs.interfaces.Fournisseur;
import ca.cours5b5.vickielanglois.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.vickielanglois.global.GCommande;
import ca.cours5b5.vickielanglois.modeles.Modele;

public class ControleurAction {

    private static Map<GCommande, Action> actions;
    private static List<Action> fileAttenteExecution;

    static{

            actions = new HashMap<>();
            for(GCommande commande : GCommande.values()){

                actions.put(commande, new Action());
        }

            fileAttenteExecution = new ArrayList<>();
        }

    public static Action demanderAction(GCommande commande){

        return actions.get(commande);
    }

    public static void fournirAction(Fournisseur fournisseur, GCommande commande, ListenerFournisseur listenerFournisseur){

        enregistrerFournisseur(fournisseur, commande, listenerFournisseur);
        executerActionsExecutable();

    }

    static void executerDesQuePossible(Action action){

        Log.d("Atelier 07", "ControllerAction.executerDesQuePossible");

        //Mettre l'action en file d'attente

        ajouterActionEnFileDAttente(action);

        //Méthode qui exécute chaque action
        executerActionsExecutable();

    }

    private static void executerActionsExecutable(){

        Log.d("Atelier 07", "ControllerAction.executerActionsExecutable");

        for(Action action : fileAttenteExecution) {
            if (siActionExecutable(action)) {

                fileAttenteExecution.remove(action);
                executerMaintenant(action);
                lancerObservationSiApplicable(action);

            }
        }
    }

    static boolean siActionExecutable(Action action){

        if(action.listenerFournisseur != null){

            return true;
        }else{
            return false;
        }

    }

    private static synchronized void executerMaintenant(Action action){

        action.listenerFournisseur.executer(action.args);

    }

    private static void lancerObservationSiApplicable(Action action){

        Log.d("Atelier 07", "ControleurAction.lancerObservationSiApplicable");
            Fournisseur fournisseur = action.fournisseur;

            if(fournisseur instanceof Modele){

                ControleurObservation.lancerObservation((Modele)fournisseur);
            }

        /*
         *Appeler le controleur pour lancer l'observation
         *  du fournisseur (seulement si le fournisseur est un modele)
         */
    }

    private static void enregistrerFournisseur(Fournisseur fournisseur, GCommande commande, ListenerFournisseur listenerFournisseur){

        Action action = actions.get(commande);
        action.listenerFournisseur = listenerFournisseur;
        action.fournisseur = fournisseur;
        /*
         *Enregistrer le foournisseur et le listenerFournisseur dans l'action
         */
    }

    private static void ajouterActionEnFileDAttente(Action action){

        fileAttenteExecution.add(action.cloner());

    }
}
