package ca.cours5b5.vickielanglois.vues;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.util.Log;

import ca.cours5b5.vickielanglois.activites.AParametres;

public abstract class Vue extends ConstraintLayout{

    public void log(String nomMethode){
        Log.d("Atelier04", this.getClass() +":"+ nomMethode);
    }

    public Vue(Context context) {
        super(context);
    }

    public Vue(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Vue(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
