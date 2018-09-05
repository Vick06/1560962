package ca.cours5b5.vickielanglois.activites;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import ca.cours5b5.vickielanglois.R;

public abstract class Activite extends AppCompatActivity{

    public void log(String nomMethode){
        Log.d("Atelier04", this.getClass() +":"+ nomMethode);
    }

}
