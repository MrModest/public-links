package mrmodest.publiclinks.persistence;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import mrmodest.publiclinks.entities.PublicLink;

public interface PublicLinkDataRepository extends JpaRepository<PublicLink, Long> {
    List<PublicLink> findAllByBundleId(long bundleId);
}
