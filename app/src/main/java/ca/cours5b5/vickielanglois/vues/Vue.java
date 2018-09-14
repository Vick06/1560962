package ca.cours5b5.vickielanglois.vues;


import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import ca.cours5b5.vickielanglois.R;

public abstract class Vue extends ConstraintLayout{

    public Vue(Context context) {
        super(context);
    }

    public Vue(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Vue(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void Log(String nomMethode){
        Log.d("Atelier 4", this.getClass().getSimpleName() + ":" + nomMethode);

    }



   /* spinnerH = this.findView(R.id.spinnerH);
    spinnerH.setAdapter(adapterH);
    spinnerH.setSelection(2);

    spinnerL = this.findViewById(R.id.spinnerL);

        spinnerL.setAdapter(adapterL);
        spinnerL.setSelection(3);

    spinnerG = this.findViewById(R.id.spinnerG);

        spinnerG.setAdapter(adapterG);
        spinnerG.setSelection(1);*/

}
