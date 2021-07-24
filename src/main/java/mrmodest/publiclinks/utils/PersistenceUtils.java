package mrmodest.publiclinks.utils;

import mrmodest.publiclinks.entities.IsEntity;

public class PersistenceUtils {
    private PersistenceUtils() {}

    public static void CheckIsNew(IsEntity entity){
        if (entity.getId() < 0) {
            throw new IllegalArgumentException("You trying ADD entity with negative 'id'!");
        }

        if (entity.getId() != 0) {
            throw new IllegalArgumentException("You trying ADD entity with 'id'!");
        }
    }

    public static void CheckIsNotNew(IsEntity entity){
        if (entity.getId() < 0) {
            throw new IllegalArgumentException("You trying UPDATE entity with negative 'id'!");
        }

        if (entity.getId() == 0) {
            throw new IllegalArgumentException("You trying UPDATE entity without 'id'!");
        }
    }
}
