package ca.cours5b5.vickielanglois.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

import ca.cours5b5.vickielanglois.R;
import ca.cours5b5.vickielanglois.controleurs.ControleurObservation;
import ca.cours5b5.vickielanglois.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.vickielanglois.exceptions.ErreurObservation;
import ca.cours5b5.vickielanglois.modeles.MParametres;
import ca.cours5b5.vickielanglois.modeles.MParametresPartie;
import ca.cours5b5.vickielanglois.modeles.MPartie;
import ca.cours5b5.vickielanglois.modeles.Modele;


public class VPartie extends Vue {

    private VGrille grille;

    public VPartie(Context context) {
        super(context);
    }

    public VPartie(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VPartie(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        Log.d("atelier", "OnFinishInflate :: VPartie");

        initialiser();

        observerPartie();

    }

    private void initialiser() {

        grille = findViewById(R.id.grille);

    }

    //TODO: appeler getNomModele() pour installer l'observaton
    private void observerPartie() {


        ControleurObservation.observerModele(MPartie.class.getSimpleName(),
                new ListenerObservateur() {
                    @Override
                    public void reagirNouveauModele(Modele modele) {

                        MPartie partie = getPartie(modele);

                        preparerAffichage(partie);

                        miseAJourGrille(partie);

                    }

                    @Override
                    public void reagirChangementAuModele(Modele modele) {

                        MPartie partie = getPartie(modele);

                        miseAJourGrille(partie);

                    }
                });
    }

    private void preparerAffichage(MPartie partie) {

        MParametresPartie parametresPartie = partie.getParametres();

        grille.creerGrille(parametresPartie.getHauteur(), parametresPartie.getLargeur());

    }

    private MPartie getPartie(Modele modele){

        try{

            return (MPartie) modele;

        }catch(ClassCastException e){

            throw new ErreurObservation(e);

        }

    }

    private void miseAJourGrille(MPartie partie){

        grille.afficherJetons(partie.getGrille());

    }

    protected String getNomModele(){
        MParametres.class.getSimpleName();

        return null;
    }

}
