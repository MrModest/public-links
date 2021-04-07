package mrmodest.publiclinks.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PublicLink {
    private final long id;
    private final String logo;
    private final String header;
    private final String title;
    private final String subtitle;
    private final String link;
    private final String description;

    private final long bundleId;
}
