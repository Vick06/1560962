package ca.cours5b5.vickielanglois.modeles;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import ca.cours5b5.vickielanglois.controleurs.ControleurAction;
import ca.cours5b5.vickielanglois.controleurs.interfaces.Fournisseur;
import ca.cours5b5.vickielanglois.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.vickielanglois.exceptions.ErreurAction;
import ca.cours5b5.vickielanglois.exceptions.ErreurSerialisation;
import ca.cours5b5.vickielanglois.global.GCommande;

public class MPartieIA extends MPartie implements Fournisseur {

    public String IA;
    private String _IA = "parametresIA";

    public MPartieIA(MParametresPartie parametres) {
        super(parametres);
    }

    @Override
    protected void fournirActionPlacerJeton() {
        ControleurAction.fournirAction(this,
                GCommande.PLACER_JETON_ICI,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {
                        try {

                            int colonne = (Integer) args[0];
                            jouerCoup(colonne);
                }catch (ClassCastException e){

                  throw new ErreurAction(e);

        }
      }
        });
    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation {
        super.aPartirObjetJson(objetJson);
        IA = (String) objetJson.get(_IA);
    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurSerialisation {

        Map<String, Object> objetJson = super.enObjetJson();
        objetJson.put(_IA, IA);
        return objetJson;
    }

    private int ia(){
        int ia = ThreadLocalRandom.current().nextInt(0, parametres.getLargeur());
        while(!siCoupLegal(ia)) {
            ia = ThreadLocalRandom.current().nextInt(0, parametres.getLargeur());
        }

        return ia;
    }

    private int ia(int mode) {
        int ai = ThreadLocalRandom.current().nextInt(0, parametres.getLargeur());
        while (!siCoupLegal(ai)) {
            ai = ThreadLocalRandom.current().nextInt(0, parametres.getLargeur());
        }

        return ai;
    }

}
