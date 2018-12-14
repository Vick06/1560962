package ca.cours5b5.vickielanglois.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import ca.cours5b5.vickielanglois.R;
import ca.cours5b5.vickielanglois.controleurs.ControleurObservation;
import ca.cours5b5.vickielanglois.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.vickielanglois.exceptions.ErreurObservation;
import ca.cours5b5.vickielanglois.modeles.MParametresPartie;
import ca.cours5b5.vickielanglois.modeles.MPartieIA;
import ca.cours5b5.vickielanglois.modeles.Modele;

public class VPartieIA extends Vue{

    private VGrille grille;

    private TextView joueurUn;
    private TextView joueurDeux;

    public VPartieIA(Context context) {
        super(context);
    }

    public VPartieIA(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VPartieIA(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        initialiser();
        adapterTexteNomJoueurSiPaysage();
        observerPartie();
    }

    private void initialiser() {

        grille = findViewById(R.id.grille);
        joueurUn = findViewById(R.id.joueurUnIA);
        joueurDeux = findViewById(R.id.joueurDeuxIA);
    }

    private void observerPartie() {

        ControleurObservation.observerModele(getNomModele(),
                new ListenerObservateur() {
                    @Override
                    public void reagirNouveauModele(Modele modele) {

                        MPartieIA partieAI = getPartie(modele);
                        MParametresPartie parametresPartie = partieAI.getParametres();

                        grille.creerGrille(parametresPartie.getHauteur(), parametresPartie.getLargeur());

                        miseAJourGrille(partieAI);

                        miseAJourNomJoueur(partieAI);
                    }

                    @Override
                    public void reagirChangementAuModele(Modele modele) {

                        MPartieIA partieAI = getPartie(modele);

                        miseAJourNomJoueur(partieAI);

                        miseAJourGrille(partieAI);


                    }
                });

    }

    protected String getNomModele(){
        return MPartieIA.class.getSimpleName();
    }

    private void adapterTexteNomJoueurSiPaysage() {

        if(!getResources().getBoolean(R.bool.si_portrait)){

            adapterTexteNomJoueurSiPaysage(joueurUn);
           // adapterTexteNomJoueurSiPaysage(joueurDeux);
        }

    }

    private void miseAJourNomJoueur(MPartieIA partie) {

        switch(partie.getCouleurCourante()){

            case ROUGE:

               // joueurDeux.setVisibility(INVISIBLE);
                joueurUn.setVisibility(VISIBLE);
                break;

            case JAUNE:

                joueurUn.setVisibility(INVISIBLE);
              //  joueurDeux.setVisibility(VISIBLE);
                break;

        }
    }

    private MPartieIA getPartie(Modele modele){
        try{

            return (MPartieIA) modele;

        }catch(ClassCastException e){

            throw new ErreurObservation(e);

        }
    }

    private void miseAJourGrille(MPartieIA partieAI){

        grille.afficherJetons(partieAI.getGrille());

    }


    private void adapterTexteNomJoueurSiPaysage(TextView texteJoueur) {

        CharSequence nomJoueur = texteJoueur.getText();

        String nomJoueurPaysage = texteEnPaysage(nomJoueur);

        texteJoueur.setText(nomJoueurPaysage);

    }

    private String texteEnPaysage(CharSequence texte){
        String textePaysage = "";

        for(int i=0; i<texte.length(); i++){
            char c = texte.charAt(i);

            textePaysage += c;

            if(i < texte.length()){
                textePaysage += "\n";
            }

        }

        return textePaysage;
    }
}
