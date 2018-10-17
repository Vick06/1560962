package ca.cours5b5.vickielanglois.controleurs;

import java.util.List;
import java.util.Map;

import ca.cours5b5.vickielanglois.controleurs.interfaces.Fournisseur;
import ca.cours5b5.vickielanglois.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.vickielanglois.global.GCommande;

public class ControleurAction {

    private static Map<GCommande, Action> action;
    private static List<Action> fileAttenteExecution;

    static{

        /*TRUC: initialiser le Map actions comme suit:
         * - pour chaque GCommande
         *      - inserer une action
         *
         * (L'avantage est qu'ensuite on a plus a tester si une
         * GCommande est dans le Map... elle y sont toutes!)
         *
         */
    }

    public static Action demanderAction(GCommande commande){
        /*
         * Retourner l'action au demandeur
         */

        return null;
    }

    public static void fournirAction(Fournisseur fournisseur, GCommande commande, ListenerFournisseur listenerFournisseur){

        /*
         * Enregistrer le fournisseur
         * Appeler la methode qui execute chaque
         *  action de la fil d 'attente
         */
    }

    static void executerDesQuePossible(Action action){
        /*
         *Mettre l'action en file d'attente
         * Appeler la methode qui execute chaque
         *  action de la fil d'attente
         */
    }

    private static void executerActionsExecutable(){
        /*
         *Iterer la file d'attente
         *     Si l'action est executable:
         *
         *          Action d'executer l'action:
         *              - l'enelver de la file d'attente
         *          Appeler la methode pour executer l'action maintenant
         *
         *          Apres avoir execute l'action
         *              - lancer l'observation du fournisseur de cette action (si possible
         */
    }

    static boolean siActionExecutable(Action action){

        /*
         *Une action est executable si:
         *  - le listenerFournisseur n'est pas null
         *
         */
        return true;
    }

    private static synchronized void executerMaintenant(Action action){
        /*
         *Appeler le listenerFournisseur de l'action
         *
         */
    }

    private static void lancerObservationSiApplicable(Action action){
        /*
         *Appeler le controleur pour lancer l'observation
         *  du fournisseur (seulement si le fournisseur est un modele)
         */
    }

    private static void enregistrerFournisseur(Fournisseur fournisseur, GCommande commande, ListenerFournisseur listenerFournisseur){

        /*
         *Enregistrer le foournisseur et le listenerFournisseur dans l'action
         */
    }

    private static void ajouterActionEnFileDAttente(Action action){
        /*
         *Creer un clone de l'action et
         *  ajouter le clone a la file d'attente
         */
    }
}
