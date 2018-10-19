package ca.cours5b5.vickielanglois.controleurs;

import android.util.Log;

import ca.cours5b5.vickielanglois.controleurs.interfaces.Fournisseur;
import ca.cours5b5.vickielanglois.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.vickielanglois.modeles.Modele;

public class Action {

    Fournisseur fournisseur;
    ListenerFournisseur listenerFournisseur;
    Object[] args;

    public void setArgs(Object... args){
        if(args != null){
            this.args = args;
        }
    }

    public void executerDesQuePossible(){

        Log.d("Atelier 07", "Action.executerDesQuePossible");
        ControleurAction controleurAction = new ControleurAction();
        controleurAction.executerDesQuePossible(this);

    }

    Action cloner(){

        Action action = new Action();

        action.fournisseur = this.fournisseur;
        action.listenerFournisseur = this.listenerFournisseur;

        if(args != null){
            action.setArgs(args);
        }

        return action;
    }



}
