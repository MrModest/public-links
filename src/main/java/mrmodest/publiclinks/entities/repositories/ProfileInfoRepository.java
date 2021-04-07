package mrmodest.publiclinks.entities.repositories;

import mrmodest.publiclinks.entities.ProfileInfo;

public interface ProfileInfoRepository {
    ProfileInfo[] findAllByLanguage(long userId, String language);
    ProfileInfo get(long id);
    ProfileInfo add(ProfileInfo newBundle);
    ProfileInfo update(ProfileInfo updated);
}
