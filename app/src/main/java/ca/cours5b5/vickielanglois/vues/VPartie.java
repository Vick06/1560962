package ca.cours5b5.vickielanglois.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import ca.cours5b5.vickielanglois.R;
import ca.cours5b5.vickielanglois.controleurs.ControleurObservation;
import ca.cours5b5.vickielanglois.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.vickielanglois.modeles.MParametresPartie;
import ca.cours5b5.vickielanglois.modeles.MPartie;
import ca.cours5b5.vickielanglois.modeles.Modele;

public class VPartie extends Vue{

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
    protected  void onFinishInflate(){
        super.onFinishInflate();
        Log.d("Atelier06", "VPArtie :: onFinishInflate");

        grille = findViewById(R.id.gridLayout);
        observerPartie();

    }

    private void observerPartie(){

        Log.d("Atelier 07", "VPartie :: observerPartie");

        ControleurObservation.observerModele(MPartie.class.getSimpleName(), new ListenerObservateur() {
            @Override
            public void reagirChangementAuModele(Modele modele) {
                Log.d("Ateleir 07", "VPartie.reagirChangementAuModele");

                initialiserGrille(getPartie(modele));
                miseAJourGrille(getPartie(modele));
            }
        });

    }

    private MPartie getPartie(Modele modele){
        return (MPartie) modele;

    }

    private void initialiserGrille(MPartie partie){

        Log.d("Atelier 07", "VPartie.initialiserGrille");

        MParametresPartie parametres = partie.getParametres();

        grille.creerGrille(parametres.getHauteur(), parametres.getLargeur());
    }

    public void miseAJourGrille(MPartie partie){

        Log.d("Atelier 07", "VPartie.miseAJourGrille");

        grille.afficherJetons(partie.getGrille());
    }
}
