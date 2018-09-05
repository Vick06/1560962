package ca.cours5b5.vickielanglois.activites;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import ca.cours5b5.vickielanglois.R;

public class AMenuPrincipal extends Activite {

    static{
        Log.d("Atelier04", AParametres.class.getSimpleName()+"static");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        log("onCreate");

        Button boutonParametres = this.findViewById(R.id.id_boutton);
        boutonParametres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent change = new Intent(AMenuPrincipal.this, AParametres.class);
                AMenuPrincipal.this.startActivity(change);
            }
        });
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
