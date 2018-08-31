package ca.cours5b5.vickielanglois.activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import ca.cours5b5.vickielanglois.R;

public class AParametres extends AppCompatActivity {
    Spinner spinnerH, spinnerL, spinnerG;
   // ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);

        spinnerH = this.findViewById(R.id.spinnerH);
        ArrayAdapter<Integer> adapterH = new ArrayAdapter<>(this.getBaseContext(), R.layout.support_simple_spinner_dropdown_item);
        spinnerH.setAdapter(adapterH);
        adapterH.addAll(4, 5, 6, 7, 8, 9, 10);
        spinnerH.setSelection(2);

        spinnerL = this.findViewById(R.id.spinnerL);
        ArrayAdapter<Integer> adapterL = new ArrayAdapter<>(this.getBaseContext(), R.layout.support_simple_spinner_dropdown_item);
        spinnerL.setAdapter(adapterL);
        adapterL.addAll(4, 5, 6, 7, 8, 9, 10);
        spinnerL.setSelection(3);

        spinnerG = this.findViewById(R.id.spinnerG);
        ArrayAdapter<Integer> adapterG = new ArrayAdapter<>(this.getBaseContext(), R.layout.support_simple_spinner_dropdown_item);
        spinnerG.setAdapter(adapterG);
        adapterG.addAll(3,4);
        spinnerG.setSelection(1);

        Log.d("Log", this.getResources().getString(R.string.titre));
        Log.d("Orientation", this.getResources().getString(R.string.orientation));
    }
}

