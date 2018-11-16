package ca.cours5b5.vickielanglois.modeles;

import java.util.HashMap;
import java.util.Map;

import ca.cours5b5.vickielanglois.controleurs.interfaces.Fournisseur;
import ca.cours5b5.vickielanglois.exceptions.ErreurSerialisation;
import ca.cours5b5.vickielanglois.serialisation.AttributSerialisable;

public class MPartieReseau  extends  MPartie implements Fournisseur, Identifiable{

    @Override
    public String getId() {
        return null;
    }

    @AttributSerialisable
    public String idJoueurInvite;
    private String _idJoueurInvite;

    @AttributSerialisable
    public String idJoueurHote;
    private String _idJoueurHote;

    public MPartieReseau(MParametres parametres){
        super(parametres);

        public String getId(){

        }

        private void fournirActionRecevoirCoup(){

        }

        @Override
        protected void fournirActionPlacerJeton(){

        }

        private void recevoirCoupReseau(int colonne){

        }

        @Override
        protected void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation{
            super();
        }

        @Override
        public Map<String, Object> enObjetJson() throws ErreurSerialisation{
            Map<String, Object> objetJson = new HashMap<>();
        }
    }
}
