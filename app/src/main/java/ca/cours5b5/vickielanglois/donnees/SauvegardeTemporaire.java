package ca.cours5b5.vickielanglois.donnees;

import android.os.Bundle;

import java.util.Map;


import ca.cours5b5.vickielanglois.serialisation.Jsonification;

public class SauvegardeTemporaire extends SourceDeDonnees {

    private Bundle bundle;

    public SauvegardeTemporaire(Bundle bundle){
        this.bundle = bundle;
    }

    @Override
    public void chargerModele(String cheminSauvegarde, ListenerChargement listenerChargement) {

        String cle = getCle(cheminSauvegarde);

        if(bundle != null && bundle.containsKey(cle)) {

            String json = bundle.getString(cle);

            Map<String, Object> objetJson = Jsonification.aPartirChaineJson(json);

            listenerChargement.reagirSucces(objetJson);

        }

            listenerChargement.reagirErreur(new Exception());


    }

    @Override
    public void sauvegarderModele(String cheminSauvegarde, Map<String, Object> objetJson) {
        if(bundle != null){

            String json = Jsonification.enChaineJson(objetJson);
            bundle.putString(getCle(cheminSauvegarde), json);

        }
    }

    private String getCle(String cheminSauvegarde){

        String nomModele = null;

        if(cheminSauvegarde != null){

            nomModele = cheminSauvegarde.split("/")[0];
        }
        return nomModele;
    }

}