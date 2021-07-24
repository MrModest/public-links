package mrmodest.publiclinks.entities.repositories;

import java.util.Optional;

import mrmodest.publiclinks.entities.Bundle;

public interface BundleRepository {
    Bundle[] findAllByLanguage(long userId, String language);
    Optional<Bundle> find(long id);
    Bundle add(Bundle newBundle);
    Bundle update(Bundle updated);
}
