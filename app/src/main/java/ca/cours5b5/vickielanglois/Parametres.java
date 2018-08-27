package ca.cours5b5.vickielanglois;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Parametres extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);
        Log.d("Log", this.getResources().getString(R.string.titre));
        Log.d("Orientation", this.getResources().getString(R.string.orientation));
    }
}

