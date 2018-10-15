package ca.cours5b5.vickielanglois.activites;

import android.os.Bundle;
import android.util.Log;

import java.util.Map;

import ca.cours5b5.vickielanglois.R;
import ca.cours5b5.vickielanglois.modeles.MPartie;
import ca.cours5b5.vickielanglois.serialisation.Jsonification;

public class APartie extends Activite{

        static{
            Log.d("Atelier06", APartie.class.getSimpleName() + "::static");
        }

        @Override
        protected void onCreate(Bundle SavedInstanceState) {
            Log.d("Atelier06", this.getClass().getSimpleName() + "::" +  "onCreate");
            super.onCreate(SavedInstanceState);
            setContentView(R.layout.activity_apartie);

        }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Atelier06", this.getClass().getSimpleName() + "::" +  "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Atelier06", this.getClass().getSimpleName() + "::" +  "onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Atelier06", this.getClass().getSimpleName() + "::" +  "onDestroy");

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("Atelier06", this.getClass().getSimpleName() + "::" +  "onSaveInstanceState");
    }

}
