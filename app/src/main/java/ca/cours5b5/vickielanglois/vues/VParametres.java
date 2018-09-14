package ca.cours5b5.vickielanglois.vues;

import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import ca.cours5b5.vickielanglois.R;
import ca.cours5b5.vickielanglois.activites.AParametres;
import ca.cours5b5.vickielanglois.modeles.MParametres;

public class VParametres extends Vue{

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

         ArrayAdapter<Integer> adapterH = new ArrayAdapter<>(getContext(), R.layout.support_simple_spinner_dropdown_item);
         spinnerH.setAdapter(adapterH);
         spinnerH.setSelection(2);

         ArrayAdapter<Integer> adapterL = new ArrayAdapter<>(getContext(), R.layout.support_simple_spinner_dropdown_item);
         spinnerL.setAdapter(adapterL);
         spinnerL.setSelection(3);

         ArrayAdapter<Integer> adapterG = new ArrayAdapter<>(getContext(), R.layout.support_simple_spinner_dropdown_item);
         spinnerG.setAdapter(adapterG);
         spinnerG.setSelection(1);

    }

}