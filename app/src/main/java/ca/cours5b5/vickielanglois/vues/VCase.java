package ca.cours5b5.vickielanglois.vues;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.widget.GridLayout;

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

        rangee = 0;
        colonne = 0;

        float poidRangee = 0;
        float poidsColonne = 0;

        GridLayout.Spec specRangee = GridLayout.spec(rangee, poidRangee);
        GridLayout.Spec specColonne = GridLayout.spec(colonne, poidsColonne);



        /*
        Afficher la rangée et la colonne
        Changer la couleur de fond si désiré
         */
    }

    public void initialiser(){

    }
}
