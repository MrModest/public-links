package mrmodest.publiclinks.persistence;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import mrmodest.publiclinks.entities.ProfileInfo;
import mrmodest.publiclinks.entities.repositories.ProfileInfoRepository;
import mrmodest.publiclinks.persistence.jpa.ProfileInfoDataRepository;
import mrmodest.publiclinks.utils.PersistenceUtils;

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
    public ProfileInfo add(ProfileInfo newProfileInfo) {
        PersistenceUtils.CheckIsNew(newProfileInfo);
        return profileInfoDataRepository.save(newProfileInfo);
    }

    @Override
    public ProfileInfo update(ProfileInfo updated) {
        PersistenceUtils.CheckIsNotNew(updated);
        return profileInfoDataRepository.save(updated);
    }
}
