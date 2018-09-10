package ca.cours5b5.vickielanglois.activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import ca.cours5b5.vickielanglois.R;

public class AParametres extends Activite {

    static {
        Log.d("Atelier04", AParametres.class.getSimpleName()+"static");

    }

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            Spinner spinnerH, spinnerL, spinnerPourGagner;

            spinnerH = this.findViewById(R.id.spinnerH);

    }

    @Override
    protected void onResume(){
        super.onResume();
        log("onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        log("onPause");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        log("onSaveInstanceState");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        log("onDestroy");
    }
}

