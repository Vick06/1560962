package ca.cours5b5.vickielanglois.vues;

import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

import ca.cours5b5.vickielanglois.R;
import ca.cours5b5.vickielanglois.activites.AParametres;
import ca.cours5b5.vickielanglois.modeles.MParametres;

public class VParametres extends Vue{


    Spinner spinnerH, spinnerL, spinnerG;

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


         List<Integer> listeHauteur = MParametres.instance.getChoixHauteur();
         spinnerH = this.findViewById(R.id.spinnerH);
         spinnerH.setAdapter(new ArrayAdapter<>(getContext(), R.layout.support_simple_spinner_dropdown_item, listeHauteur));
         spinnerH.setSelection(listeHauteur.indexOf(MParametres.instance.hauteur));

         List<Integer> listeLargeur = MParametres.instance.getChoixLargeur();
         spinnerL = this.findViewById(R.id.spinnerL);
         spinnerL.setAdapter(new ArrayAdapter<>(getContext(), R.layout.support_simple_spinner_dropdown_item, listeLargeur));
         spinnerL.setSelection(listeLargeur.indexOf(MParametres.instance.largeur));


         List<Integer> listeGagner = MParametres.instance.getChoixPourGagner();
         spinnerG = this.findViewById(R.id.spinnerG);
         spinnerG.setAdapter(new ArrayAdapter<>(getContext(), R.layout.support_simple_spinner_dropdown_item, listeGagner));
         spinnerG.setSelection(listeGagner.indexOf(MParametres.instance.pourGagner));




         spinnerH.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                 MParametres.instance.hauteur = (Integer) parent.getItemAtPosition(position);
                 //MParametres.instance.hauteur = (Integer) parent.getAdapter().getItem(position);

             }

             @Override
             public void onNothingSelected(AdapterView<?> adapterView) {

             }
         });

         spinnerL.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                 MParametres.instance.largeur = (Integer) parent.getItemAtPosition(position);
                 //MParametres.instance.largeur = (Integer) parent.getAdapter().getItem(position);
             }

             @Override
             public void onNothingSelected(AdapterView<?> adapterView) {

             }
         });

         spinnerG.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                 MParametres.instance.pourGagner = (Integer) parent.getItemAtPosition(position);

                // MParametres.instance.pourGagner = (Integer) parent.getAdapter().getItem(position);
             }

             @Override
             public void onNothingSelected(AdapterView<?> adapterView) {

             }
         });


    }

 /*  public void choixNumero(Spinner spinner, int choixPresent, List<Integer> liste){

        ArrayAdapter<Integer> adapteur = (ArrayAdapter) spinner.getAdapter();
        adapteur.clear();

        for(int i = 0; i <= liste.size(); i++){
            int temp = ((Integer) liste.get(i)).intValue();
            adapteur.add(Integer.valueOf(temp));

            if(choixPresent == temp){

                spinner.setSelection(i);
            }



        }*/

}