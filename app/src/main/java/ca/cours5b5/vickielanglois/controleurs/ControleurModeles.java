package ca.cours5b5.vickielanglois.controleurs;

import android.content.Intent;

import com.firebase.ui.auth.AuthUI;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.cours5b5.vickielanglois.controleurs.interfaces.Fournisseur;
import ca.cours5b5.vickielanglois.controleurs.interfaces.ListenerGetModele;
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

        ControleurModeles.sequenceDeChargement = sequenceDeChargement;

    }

    public static void sauvegarderModeleDansCetteSource(String nomModele, SourceDeDonnees sourceDeDonnees) {

        Modele modele = modelesEnMemoire.get(nomModele);

        if(modele != null){

            Map<String, Object> objetJson = modele.enObjetJson();

            sourceDeDonnees.sauvegarderModele(getCheminSauvegarde(nomModele), objetJson);

        }
    }

    static Modele getModele(final String nomModele){

        Modele modele = modelesEnMemoire.get(nomModele);

        if(modele == null){

            modele =  chargerViaSequenceDeChargement(nomModele);

        }

        return modele;
    }


    private static Modele chargerViaSequenceDeChargement(final String nomModele){

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

        for(SourceDeDonnees source : listeDeSauvegardes){

            sauvegarderModeleDansCetteSource(nomModele, source);

        }

    }


    private static Modele creerModeleSelonNom(String nomModele) throws ErreurModele {

        if(nomModele.equals(MParametres.class.getSimpleName())){
            return new MParametres();
        }else if(nomModele.equals(MPartie.class.getSimpleName())){
            MParametres mParametres = (MParametres) getModele(MParametres.class.getSimpleName());
            return new MPartie(mParametres.getParametresPartie().cloner());
        }else{
            throw new ErreurModele("Modèle inconnu: " + nomModele);

        }
    }

    public static void detruireModele(String nomModele) {

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

        String idUsager = UsagerCourant.getId();
        String cheminSauvegarde = "";

        if(idUsager != null && nomModele != null){
            cheminSauvegarde = nomModele + "/" + idUsager;
        }

        return  cheminSauvegarde;

    }

    private static void creerModeleEtChargerDonnees(final String nomModele, final ListenerGetModele listenerGetModele){

    }

    private static void chargerDonnees(Modele modele, String nomModele, ListenerGetModele listenerGetModele){

    }

    private static void chargementViaSequence(Modele modele, String cheminDeSauvegarde, ListenerGetModele listenerGetModele, int indiceSourceCourante){

    }

    private static void chargementViaSourceCOuranteOuSuivante(final Modele modele, final String cheminDeSauvegarde, final ListenerGetModele listenerGetModele, final int indiceSourceCourante){

    }

    private static void terminerChargementAvecDonnees(Map<String, Object> objetJson, Modele modele, ListenerGetModele listenerModele){

    }

    private static void terminerChargement(Modele modele, ListenerGetModele listenerGetModele){

    }

    private static void chargementViaSourceSuivante(Modele modele, String cheminDeSauvegarde, ListenerGetModele listenerGetModele, int indiceSourceCourante){

    }

}
