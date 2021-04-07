package mrmodest.publiclinks.entities.repositories;

import mrmodest.publiclinks.entities.Bundle;
import mrmodest.publiclinks.entities.PublicLink;

public interface PublicLinkRepository {
    PublicLink[] findAllByBundleId(long bundleId);
    PublicLink get(long id);
    PublicLink add(PublicLink newBundle);
    PublicLink update(PublicLink updated);
}
