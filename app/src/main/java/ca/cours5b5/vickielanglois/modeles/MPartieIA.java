package ca.cours5b5.vickielanglois.modeles;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import ca.cours5b5.vickielanglois.controleurs.Action;
import ca.cours5b5.vickielanglois.controleurs.ControleurAction;
import ca.cours5b5.vickielanglois.controleurs.interfaces.Fournisseur;
import ca.cours5b5.vickielanglois.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.vickielanglois.exceptions.ErreurAction;
import ca.cours5b5.vickielanglois.exceptions.ErreurSerialisation;
import ca.cours5b5.vickielanglois.global.GCommande;

public class MPartieIA extends MPartie implements Fournisseur {

    public String IA;
    private String _IA = "parametresIA";

    public List<Integer> listeCoupJoueur;
    private final String _listeCoupJoueur = "ListeCoupJoueur";


    public List<Integer> listeCoupIA;
    private final String get_listeCoupiA = "ListeCoupIA";

    private boolean partiFini;

    private MParametresPartie mParametresPartie;

    public MPartieIA(MParametresPartie parametres) {
        super(parametres);
        this.mParametresPartie = parametres;
    }

    @Override
    protected void initialiser(){
        listeCoupJoueur = new ArrayList<>();
        listeCoupIA = new ArrayList<>();
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

                            jouerCoup(ia());

                           /* if(!partiFini){
                                Action actionIA = ControleurAction.demanderAction(GCommande.IA_JOUER);
                                actionIA.executerDesQuePossible();
                            }*/
                }catch (ClassCastException e){
                throw new ErreurAction(e);
            }
        }
        });

        ControleurAction.fournirAction(this, GCommande.IA_JOUER, new ListenerFournisseur() {
            @Override
            public void executer(Object... args) {
                try{
                    ia();
                }catch(ClassCastException e){
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

    //FIXME
    private int ia(){
        int ia = ThreadLocalRandom.current().nextInt(0, parametres.getLargeur());
        while(!siCoupLegal(ia)) {
            ia = ThreadLocalRandom.current().nextInt(0, parametres.getLargeur());
        }
        return ia;
    }

  /*  private int ia(int mode) {
        int ai = ThreadLocalRandom.current().nextInt(0, parametres.getLargeur());
        while (!siCoupLegal(ai)) {
            ai = ThreadLocalRandom.current().nextInt(0, parametres.getLargeur());
        }

        return ai;
    }*/

}
