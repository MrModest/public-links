package mrmodest.publiclinks.entities.repositories;

import mrmodest.publiclinks.entities.Bundle;

public interface BundleRepository {
    Bundle[] findAllByLanguage(long userId, String language);
    Bundle get(long id);
    Bundle add(Bundle newBundle);
    Bundle update(Bundle updated);
}
