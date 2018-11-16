package ca.cours5b5.vickielanglois.controleurs;

import ca.cours5b5.vickielanglois.modeles.MPartie;
import ca.cours5b5.vickielanglois.modeles.MPartieReseau;
import ca.cours5b5.vickielanglois.proxy.ProxyListe;

public class ControleurPartieReseau {

    private static final ControleurPartieReseau instance;

    public static ControleurPartieReseau getInstance() {
        return null;
    }

    private ProxyListe proxyEmettreCoups;
    private ProxyListe proxyRecevoirCoups;

    public void connecterAuServeur(){

    }

    private void connecterAuServeur(String idJoueurHote){

    }

    private void connecterEnTantQueJoueurHote(String cheminCoupsJoueurHote, String cheminCoupsJoueurInvite){

    }

    private void connecterEnTantQueJoueurInvite(String cheminCoupsJoueurHote, String cheminCoupsJoueurInvite){

    }

    public void deconnecterDuServeur(){

    }

    public void transmettreCoup(Integer idColonne){

    }

    private String getCheminCoupsJoueurInvite(String idJoueurHote){

    }

    private String getCheminCoupsJoueurHote(String idJoueurHote){

    }

    private String getCheminPartie(String idJoueurHote){

    }

    public void detruireSauvegardeServeur(){

    }
}
