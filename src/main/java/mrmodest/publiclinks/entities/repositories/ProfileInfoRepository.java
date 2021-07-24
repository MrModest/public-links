package mrmodest.publiclinks.entities.repositories;

import java.util.Optional;

import mrmodest.publiclinks.entities.ProfileInfo;

public interface ProfileInfoRepository {
    ProfileInfo[] findAllByLanguage(long userId, String language);
    Optional<ProfileInfo> find(long id);
    ProfileInfo add(ProfileInfo newBundle);
    ProfileInfo update(ProfileInfo updated);
}
