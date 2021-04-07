package mrmodest.publiclinks.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Bundle {
    private final long id;
    private final String title;
    private final String description;
    private final String language;

    private final long userId;
}
