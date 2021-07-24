package mrmodest.publiclinks.entities.repositories;

import java.util.Optional;

import mrmodest.publiclinks.entities.PublicLink;

public interface PublicLinkRepository {
    PublicLink[] findAllByBundleId(long bundleId);
    Optional<PublicLink> find(long id);
    PublicLink add(PublicLink newBundle);
    PublicLink update(PublicLink updated);
}
