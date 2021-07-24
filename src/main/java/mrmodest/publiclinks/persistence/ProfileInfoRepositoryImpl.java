package mrmodest.publiclinks.persistence;

import java.util.Optional;

import mrmodest.publiclinks.persistence.jpa.ProfileInfoDataRepository;
import org.springframework.stereotype.Repository;

import mrmodest.publiclinks.entities.ProfileInfo;
import mrmodest.publiclinks.entities.repositories.ProfileInfoRepository;

@Repository
public class ProfileInfoRepositoryImpl implements ProfileInfoRepository {

    private final ProfileInfoDataRepository profileInfoDataRepository;

    public ProfileInfoRepositoryImpl(ProfileInfoDataRepository profileInfoDataRepository){
        this.profileInfoDataRepository = profileInfoDataRepository;
    }

    @Override
    public ProfileInfo[] findAllByLanguage(long userId, String language) {
        return profileInfoDataRepository.findAllByUserIdAndLanguage(userId, language).toArray(new ProfileInfo[0]);
    }

    @Override
    public Optional<ProfileInfo> find(long id) {
        return profileInfoDataRepository.findById(id);
    }

    @Override
    public ProfileInfo add(ProfileInfo newBundle) {
        return profileInfoDataRepository.save(newBundle);
    }

    @Override
    public ProfileInfo update(ProfileInfo updated) {
        if (updated.getId() <= 0) {
            throw new IllegalArgumentException("You trying update bundle without 'id'!");
        }
        return profileInfoDataRepository.save(updated);
    }
}
