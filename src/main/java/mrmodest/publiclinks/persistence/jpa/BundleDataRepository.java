package mrmodest.publiclinks.persistence.jpa;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import mrmodest.publiclinks.entities.Bundle;

public interface BundleDataRepository extends JpaRepository<Bundle, Long> {
    List<Bundle> findAllByUserIdAndLanguage(long userId, String language);
}
