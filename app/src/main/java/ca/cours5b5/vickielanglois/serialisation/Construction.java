package ca.cours5b5.vickielanglois.serialisation;

import ca.cours5b5.vickielanglois.exceptions.ErreurDeConstruction;

public class Construction {

    public static <T extends  Constructible> T construire(Class<T> classeAInstantier) throws ErreurDeConstruction {

    }

    public static <T extends  Constructible> T finaliserConstruction(Class<T> classeAInstantier, Object obj) {

    }
}
