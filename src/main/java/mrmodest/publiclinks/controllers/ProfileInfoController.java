package mrmodest.publiclinks.controllers;

import org.springframework.web.bind.annotation.RestController;

import mrmodest.publiclinks.entities.ProfileInfo;
import mrmodest.publiclinks.entities.repositories.ProfileInfoRepository;

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
        var userIdFromHttpContext = 0;
        if (profileInfo.getUserId() != userIdFromHttpContext){
            throw new IllegalArgumentException("You can't affect to other user's entities!");
        }
        return profileInfoRepository.update(profileInfo);
    }

    public ProfileInfo add(ProfileInfo profileInfo){
        var userIdFromHttpContext = 0;
        if (profileInfo.getUserId() != userIdFromHttpContext){
            throw new IllegalArgumentException("You can't affect to other user's entities!");
        }
        return profileInfoRepository.add(profileInfo);
    }
}
