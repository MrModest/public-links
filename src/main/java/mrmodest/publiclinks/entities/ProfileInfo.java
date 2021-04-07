package mrmodest.publiclinks.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ProfileInfo {
    private final long id;
    private final String avatar;
    private final String firstName;
    private final String lastName;
    private final String nickname;
    private final Date dateOfBirth;
    private final String about;
    private final String language;

    private final long userId;
}
