package ca.cours5b5.vickielanglois.donnees;

import java.io.File;
import java.util.Map;


public abstract class SourceDeDonnees {

    public abstract Map<String, Object> chargerModele(final String cheminSauvegarde);

    public abstract void sauvegarderModele(final String cheminSauvegarde, final Map<String, Object> objetJson);

    public String getNomModele(String cheminSauvegarde){
        return cheminSauvegarde.split(File.separator)[0];
    }

    public abstract void chargerModele(final String cheminSauvegarde, final ListenerChargement listenerChargement);
}
