package mrmodest.publiclinks.persistence.jpa;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import mrmodest.publiclinks.entities.ProfileInfo;

public interface ProfileInfoDataRepository extends JpaRepository<ProfileInfo, Long> {
    List<ProfileInfo> findAllByUserIdAndLanguage(long userId, String language);
}
