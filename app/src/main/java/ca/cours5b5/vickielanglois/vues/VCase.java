package ca.cours5b5.vickielanglois.vues;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.widget.GridLayout;

import ca.cours5b5.vickielanglois.global.GCouleur;
import ca.cours5b5.vickielanglois.modeles.MParametres;

public class VCase extends AppCompatButton {

    public VCase(Context context) {
        super(context);
    }

    public VCase(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VCase(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public VCase(Context context, int rangee, int colonne){
        super(context);

        this.setText(rangee + "," + colonne);
    }

    public void afficherJeton(GCouleur jeton){


        /*
         * Changer la couleur de fond selonle jeton a afficher
         */
    }

}
