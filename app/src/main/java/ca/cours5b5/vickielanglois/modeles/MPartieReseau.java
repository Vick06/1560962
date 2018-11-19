package ca.cours5b5.vickielanglois.modeles;

import java.util.HashMap;
import java.util.Map;

import ca.cours5b5.vickielanglois.controleurs.ControleurAction;
import ca.cours5b5.vickielanglois.controleurs.ControleurPartieReseau;
import ca.cours5b5.vickielanglois.controleurs.interfaces.Fournisseur;
import ca.cours5b5.vickielanglois.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.vickielanglois.exceptions.ErreurAction;
import ca.cours5b5.vickielanglois.exceptions.ErreurSerialisation;
import ca.cours5b5.vickielanglois.global.GCommande;
import ca.cours5b5.vickielanglois.global.GConstantes;
import ca.cours5b5.vickielanglois.serialisation.AttributSerialisable;

public class MPartieReseau  extends  MPartie implements Fournisseur, Identifiable{

    @AttributSerialisable
    public String idJoueurInvite;
    private String _idJoueurInvite = GConstantes.CLE_ID_JOUEUR_INVITE;

    @AttributSerialisable
    public String idJoueurHote;
    private String _idJoueurHote = GConstantes.CLE_ID_JOUEUR_HOTE;

    public MPartieReseau(MParametresPartie parametres) {
        super(parametres);

        fournirActionRecevoirCoup();

        }

        public String getId(){
            return idJoueurHote;

        }

        private void fournirActionRecevoirCoup(){

            ControleurAction.fournirAction(this, GCommande.RECEVOIR_COUP_RESEAU,
                    new ListenerFournisseur() {
                        @Override
                        public void executer(Object... args) {

                            try{
                                int colonne = ((Long) args[0]).intValue();
                                recevoirCoupReseau(colonne);

                            }catch (ClassCastException e){
                                throw new ErreurAction(e);
                            }
                        }
                    });

        }

        @Override
        protected void fournirActionPlacerJeton(){

            ControleurAction.fournirAction(this, GCommande.JOUER_COUP_ICI,
                    new ListenerFournisseur() {
                        @Override
                        public void executer(Object... args) {
                            try{
                                int colonne = (Integer) args[0];
                                jouerCoup(colonne);
                                ControleurPartieReseau.getInstance().transmettreCoup(colonne);

                            }catch (ClassCastException e){
                                throw new ErreurAction(e);
                            }
                        }
                    });

        }

        private void recevoirCoupReseau(int colonne){

            jouerCoup(colonne);
        }

        @Override
        public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation{


            idJoueurInvite = (String) objetJson.get(_idJoueurInvite);
            idJoueurHote = (String) objetJson.get(_idJoueurHote);
            super.aPartirObjetJson(objetJson);
        }

        @Override
        public Map<String, Object> enObjetJson() throws ErreurSerialisation{
            Map<String, Object> objetJson = new HashMap<>();

            objetJson.put(_idJoueurInvite, idJoueurInvite);
            objetJson.put(_idJoueurHote, idJoueurHote);

            objetJson = super.enObjetJson();

            return objetJson;
        }
    }
