package ca.cours5b5.vickielanglois.global;

public class test {

    /*

    reagirNouveauModele (Modele m)
    reagirChangementAuModele(Modele m)

    Sera appelée à l'intérieur d'une Vue → Les deux
    Sera appelée au plus une fois par modèle → reagirNouveauModele
    Sera appelée à l'intérieur d'une Activité → Aucune
    Il faudra «caster» m selon le type exact de modèle désiré → Les deux
    Le type exact de m dépend des arguments à Action::setArguments → Aucune
    Sera appelée dès que le modèle est chargé ou créé → reagirNouveauModele
    Sera appelée après l'exécution d'une action modifiant le modèle → reagirChangementAuModele
    Le type exact de m dépend des arguments à ControleurModeles::observerModele → Les deux


    Exemple Intent

    new Intent((AMenuPrincipal)this, AParametres.class);
    new Intent((AMenuPrincipal)this, APartie.class);

    Exemples Actions

    actionParametres .executerDesQuePossible ();
    actionPartie .executerDesQuePossible ();
    actionJouerCoup .setArguments (4);
    actionJouerCoup .executerDesQuePossible ();
    actonJouerCoup .setArguments (3);
    actionJouerCoup .executerDesQuePossible ();
    Vide
    Vide

    Pour la sauvegarde sur le disque

    APartie.onPause
    ControleurModeles.sauvegarderModele
    ControleurModeles.sauvegarderModeleDansCetteSource
    Disque.sauvegarderModele

    Pour la sauvegarde temporaire

    Activite.onSaveInstanceState
    ControleurModeles.sauvegarderModeleDansCetteSource
    SauvegardeTemporaire.sauvegarderModele

    Pour le chargement des paramètres

    VParametres.onFinishInflate
    VParametres.installerObservateur
    ControleurObservation.observerModele
    ControleurModeles.getModele
    ControleurModeles.chargerViaSequenceDeChargement
    SauvegardeTemporaire.chargerModele
    Disque.chargerModele
    VParametres$4.reagirChangementAuModele
     */
}
