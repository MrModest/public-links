package mrmodest.publiclinks.controllers;

import org.springframework.web.bind.annotation.RestController;

import mrmodest.publiclinks.entities.ProfileInfo;
import mrmodest.publiclinks.entities.repositories.ProfileInfoRepository;
import mrmodest.publiclinks.utils.AuthUtils;

@RestController
public class ProfileInfoController {

    private final ProfileInfoRepository profileInfoRepository;

    public ProfileInfoController(ProfileInfoRepository profileInfoRepository){

        this.profileInfoRepository = profileInfoRepository;
    }

    public ProfileInfo[] getByLanguage(String language){
        var userIdFromHttpContext = 0;
        return profileInfoRepository.findAllByLanguage(userIdFromHttpContext, language);
    }

    public ProfileInfo edit(ProfileInfo profileInfo){
        AuthUtils.CheckOwner(profileInfo);
        return profileInfoRepository.update(profileInfo);
    }

    public ProfileInfo add(ProfileInfo profileInfo){
        AuthUtils.CheckOwner(profileInfo);
        return profileInfoRepository.add(profileInfo);
    }
}
