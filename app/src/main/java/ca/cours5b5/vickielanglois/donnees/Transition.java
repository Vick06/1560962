package ca.cours5b5.vickielanglois.donnees;

import android.os.Bundle;

public class Transition extends SauvegardeTemporaire {

    public Transition(Bundle bundle) {
        super(bundle);
    }

    public Transition(){
        this.bundle = new Bundle();
    }

    public Bundle getBundle() {
        return bundle;
    }

}
