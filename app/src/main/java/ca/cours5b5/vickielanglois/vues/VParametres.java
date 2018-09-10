package ca.cours5b5.vickielanglois.vues;

import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Spinner;

import ca.cours5b5.vickielanglois.R;
import ca.cours5b5.vickielanglois.activites.AParametres;

public class VParametres extends ConstraintLayout implements Vue{

    static{
        Log.d("Atelier04", AParametres.class.getSimpleName()+"static");
    }

    public VParametres(Context context) {
        super(context);
    }

    public VParametres(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VParametres(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


     @Override
        protected void onFinishInflate(){
        super.onFinishInflate();



    }

}