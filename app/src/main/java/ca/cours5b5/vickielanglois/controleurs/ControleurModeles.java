package ca.cours5b5.vickielanglois.controleurs;

import android.content.Intent;
import android.util.Log;
import android.view.Display;

import com.firebase.ui.auth.AuthUI;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.cours5b5.vickielanglois.controleurs.interfaces.Fournisseur;
import ca.cours5b5.vickielanglois.controleurs.interfaces.ListenerGetModele;
import ca.cours5b5.vickielanglois.donnees.ListenerChargement;
import ca.cours5b5.vickielanglois.donnees.Serveur;
import ca.cours5b5.vickielanglois.donnees.SourceDeDonnees;
import ca.cours5b5.vickielanglois.exceptions.ErreurModele;
import ca.cours5b5.vickielanglois.global.GConstantes;
import ca.cours5b5.vickielanglois.modeles.MParametres;
import ca.cours5b5.vickielanglois.modeles.MParametresPartie;
import ca.cours5b5.vickielanglois.modeles.MPartie;
import ca.cours5b5.vickielanglois.modeles.Modele;
import ca.cours5b5.vickielanglois.donnees.Disque;
import ca.cours5b5.vickielanglois.usagers.UsagerCourant;

public final class ControleurModeles {

    private ControleurModeles(){}

    private static Map<String, Modele> modelesEnMemoire;

    private static SourceDeDonnees[] sequenceDeChargement;

    private static List<SourceDeDonnees> listeDeSauvegardes;

    static {

        modelesEnMemoire = new HashMap<>();

        listeDeSauvegardes = new ArrayList<>();
        listeDeSauvegardes.add(Disque.getInstance());
        listeDeSauvegardes.add(Serveur.getInstance());

    }

    public static void setSequenceDeChargement(SourceDeDonnees... sequenceDeChargement){
        Log.d("Atelier 12", "setSequenceDeChargement");
        ControleurModeles.sequenceDeChargement = sequenceDeChargement;

    }

    public static void sauvegarderModeleDansCetteSource(String nomModele, SourceDeDonnees sourceDeDonnees) {
        Log.d("Atelier 12", "sauvegarderModeleFansCetteRessource");

        Modele modele = modelesEnMemoire.get(nomModele);

        if(modele != null){

            Map<String, Object> objetJson = modele.enObjetJson();

            sourceDeDonnees.sauvegarderModele(getCheminSauvegarde(nomModele), objetJson);

        }
    }

    static void getModele(String nomModele, ListenerGetModele listenerGetModele){
        Log.d("Atelier 11", "getModele");
        Modele modele = modelesEnMemoire.get(nomModele);

        if(modele == null){
            final String mod = nomModele;
            creerModeleEtChargerDonnees(mod, listenerGetModele);
        }
    }


    private static Modele chargerViaSequenceDeChargement(final String nomModele){
        Log.d("Atelier 12", "chargerViaSequenceDeChargement");

        Modele modele = creerModeleSelonNom(nomModele);

        modelesEnMemoire.put(nomModele, modele);

        String cheminSauvegarde = getCheminSauvegarde(nomModele);
        for(SourceDeDonnees sourceDeDonnees : sequenceDeChargement){

            Map<String, Object> objetJson = sourceDeDonnees.chargerModele(cheminSauvegarde);

            if(objetJson != null){

                modele.aPartirObjetJson(objetJson);
                break;

            }

        }

        return modele;
    }

    public static void sauvegarderModele(String nomModele) throws ErreurModele {
        Log.d("Atelier 12", "sauvegarderModele");

        for(SourceDeDonnees source : listeDeSauvegardes){

            sauvegarderModeleDansCetteSource(nomModele, source);

        }

    }

    public static void detruireModele(String nomModele) {
        Log.d("Atelier 12", "detruireModele");

        Modele modele = modelesEnMemoire.get(nomModele);

        if(modele != null){

            modelesEnMemoire.remove(nomModele);

            ControleurObservation.detruireObservation(modele);

            if(modele instanceof Fournisseur){

                ControleurAction.oublierFournisseur((Fournisseur) modele);

            }
        }
    }

    private static String getCheminSauvegarde(String nomModele){
        Log.d("Atelier 12", "getCheminSauvegarde");

        String idUsager = UsagerCourant.getId();
        String cheminSauvegarde = "";

        if(idUsager != null && nomModele != null){
            cheminSauvegarde = nomModele + "/" + idUsager;
        }

        return  cheminSauvegarde;

    }

    private static void creerModeleSelonNom(String nomModele, final ListenerGetModele listenerGetModele) throws ErreurModele {
        Log.d("Atelier 12", "creerModeleSelonNom");

        if(nomModele.equals(MParametres.class.getSimpleName())) {
            listenerGetModele.reagirAuModele(new MParametres());

        }else if(nomModele.equals(MPartie.class.getSimpleName())){

            getModele(MParametres.class.getSimpleName(), new ListenerGetModele() {
                @Override
                public void reagirAuModele(Modele modele ) {
                    MParametres parametres = (MParametres) modele;

                    MPartie mPartie = new MPartie(parametres.getParametresPartie().cloner());
                    listenerGetModele.reagirAuModele(mPartie);
                }
            });
        }else{

            throw new ErreurModele("Mauvais Modele: " + nomModele);
        }


    }

    private static void creerModeleEtChargerDonnees(final String nomModele, final ListenerGetModele listenerGetModele){
        Log.d("Atelier 12", "creerModeleEtChargerDonnees");

        creerModeleSelonNom(nomModele, new ListenerGetModele() {

        @Override
        public void reagirAuModele(Modele modele){

            //put pour memoire
            modelesEnMemoire.put(nomModele, modele);
            chargerDonnees(modele, nomModele, listenerGetModele);
        }
        });

            //modelesEnMemoire(modele);
            /*
            Aussi: memoriser le modele dans modelesEnMemoire
         */
    }

    private static void chargerDonnees(Modele modele, String nomModele, ListenerGetModele listenerGetModele){
        Log.d("Atelier 12", "chargerDonnees");

        String save = getCheminSauvegarde(nomModele);
        int ind = 0;

        //Charger via sequence
        chargementViaSequence(modele, save, listenerGetModele, ind);
    }

    private static void chargementViaSequence(Modele modele, String cheminDeSauvegarde, ListenerGetModele listenerGetModele, int indiceSourceCourante){
        Log.d("Atelier 12", "chargementViaSequence");

        //Si plus grand que la temps de chargement
        if(indiceSourceCourante >= sequenceDeChargement.length) {

            terminerChargement(modele, listenerGetModele);

        }else{

            chargementViaSourceCouranteOuSuivante(modele, cheminDeSauvegarde, listenerGetModele, indiceSourceCourante);
        }
    }

    private static void chargementViaSourceCouranteOuSuivante(final Modele modele, final String cheminDeSauvegarde, final ListenerGetModele listenerGetModele, final int indiceSourceCourante){
        Log.d("Atelier 12", "ChargementViaSourceCouranteOuSuivante");

        //Chargement du Modele
        sequenceDeChargement[indiceSourceCourante].chargerModele(cheminDeSauvegarde, new ListenerChargement() {
            @Override
            public void reagirSucces(Map<String, Object> objetJson) {
                Log.d("Atelier 12", "chargerModeleSuccess" + modele.getClass().getSimpleName());

                terminerChargementAvecDonnees(objetJson, modele, listenerGetModele);
            }

            @Override
            public void reagirErreur(Exception e) {
                Log.d("Atelier 12", "chargerModeleErreur" + modele.getClass().getSimpleName());

                chargementViaSourceSuivante(modele, cheminDeSauvegarde, listenerGetModele, indiceSourceCourante);
            }
        });

    }

    private static void terminerChargementAvecDonnees(Map<String, Object> objetJson, Modele modele, ListenerGetModele listenerGetModele){
        Log.d("Atelier 12", "TerminerChargementAvecDonnees");

        modele.aPartirObjetJson(objetJson);
         terminerChargement(modele, listenerGetModele);

    }

    private static void terminerChargement(Modele modele, ListenerGetModele listenerGetModele){
        Log.d("Atelier 12", "Terminer le chargement" + modele.getClass().getSimpleName());

        listenerGetModele.reagirAuModele(modele);
    }

    private static void chargementViaSourceSuivante(Modele modele, String cheminDeSauvegarde, ListenerGetModele listenerGetModele, int indiceSourceCourante){
            Log.d("Atelier 12", "ChargementViaSourceSuivante");

            chargementViaSequence(modele, cheminDeSauvegarde, listenerGetModele, (indiceSourceCourante + 1));
    }

}
