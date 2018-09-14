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

import java.util.Map;

import ca.cours5b5.vickielanglois.R;
import ca.cours5b5.vickielanglois.modeles.MParametres;
import ca.cours5b5.vickielanglois.serialisation.Jsonification;
import ca.cours5b5.vickielanglois.vues.VParametres;

public class AParametres extends Activite {

    private VParametres parametres;

    static {
        Log.d("Atelier04", AParametres.class.getSimpleName()+"static");

    }

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_parametres);

            parametres = new VParametres(this);

            if(savedInstanceState != null){
                restaurerParametres(savedInstanceState);
            }
    }

    private void restaurerParametres(Bundle savedInstanceState){

        String json = savedInstanceState.getString("MParametres");
        Map<String, Object> objetJson = Jsonification.enObjetJson(json);
        MParametres.instance.aPartirObjetJson(objetJson);
        Log.d("Atelier05", AParametres.class.getSimpleName()+ "::restaurerParametres, cle: MParametres");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        sauvegarderParametres(outState);

        log("onSaveInstanceState");
    }

    private void sauvegarderParametres(Bundle outState){

        Map<String, Object> objetJson = MParametres.instance.enObjetJson();
        String json = Jsonification.enChaine(objetJson);
        outState.putString("MParametres", json);
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
    protected void onDestroy(){
        super.onDestroy();
        log("onDestroy");
    }
}

