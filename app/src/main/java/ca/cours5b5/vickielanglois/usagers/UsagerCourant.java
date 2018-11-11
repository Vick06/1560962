package ca.cours5b5.vickielanglois.usagers;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class UsagerCourant {

    public static boolean userConnected(){

        return FirebaseAuth.getInstance().getCurrentUser() != null;
    }

    public static String getId() {

        String id = "0";

        if(userConnected()){

            id = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser().getUid());
        }

        return id;
    }
}
