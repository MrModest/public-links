package mrmodest.publiclinks.utils;

import org.springframework.security.core.context.SecurityContextHolder;

import mrmodest.publiclinks.entities.HasOwner;
import mrmodest.publiclinks.entities.User;

public class AuthUtils {
    private AuthUtils() {}

    public static User getUserFromContext() {
        return (User) SecurityContextHolder.getContext()
            .getAuthentication()
            .getPrincipal();
    }

    public static void CheckOwner(HasOwner entity){
        if (entity.getUserId() != getUserFromContext().getId()){
            throw new IllegalArgumentException("You can't affect to other user's entities!");
        }
    }
}
