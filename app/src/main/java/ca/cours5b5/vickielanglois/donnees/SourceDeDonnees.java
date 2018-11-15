package ca.cours5b5.vickielanglois.donnees;

import java.io.File;
import java.util.Map;


public abstract class SourceDeDonnees {

    public abstract void sauvegarderModele(final String cheminSauvegarde, final Map<String, Object> objetJson);
    public abstract void chargerModele(final String cheminSauvegarde, final ListenerChargement listenerChargement);

    public String getNomModele(String cheminSauvegarde){
        return cheminSauvegarde.split(File.separator)[0];
    }


}
