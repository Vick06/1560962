package ca.cours5b5.vickielanglois.donnees;

import java.util.Map;

public class Serveur extends SourceDeDonnees {

    private Serveur(){}
    //
    //  //  private static final Serveur instance;

    public static Serveur getInstance(){
        return null;
    }


    @Override
    public Map<String, Object> chargerModele(String cheminSauvegarde) {
        return null;
    }

    @Override
    public void sauvegarderModele(String cheminSauvegarde, Map<String, Object> objetJson) {

    }
}
