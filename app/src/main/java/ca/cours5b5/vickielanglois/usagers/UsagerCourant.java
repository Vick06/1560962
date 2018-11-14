package ca.cours5b5.vickielanglois.usagers;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class UsagerCourant {

    public static boolean userConnected(){

        return FirebaseAuth.getInstance().getCurrentUser() != null;
    }

    public static String getId() {

        String id = null;

        if(userConnected()){

            id = FirebaseAuth.getInstance().getCurrentUser().getUid();

            //id = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser().getUid());
        }

        return id;
    }
}
