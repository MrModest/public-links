package mrmodest.publiclinks.controllers;

import org.springframework.web.bind.annotation.*;

import mrmodest.publiclinks.entities.Bundle;
import mrmodest.publiclinks.entities.repositories.BundleRepository;

@RestController
public class BundleController {

    private final BundleRepository bundleRepository;

    public BundleController(BundleRepository bundleRepository){

        this.bundleRepository = bundleRepository;
    }

    @GetMapping("/api/bundles/{language}")
    public Bundle[] getByLanguage(@PathVariable String language){
        var userIdFromHttpContext = 0;
        return bundleRepository.findAllByLanguage(userIdFromHttpContext, language);
    }

    @PutMapping("/api/bundles")
    public Bundle edit(Bundle bundle){
        var userIdFromHttpContext = 0;
        if (bundle.getUserId() != userIdFromHttpContext){
            throw new IllegalArgumentException("You can't affect to other user's entities!");
        }
        return bundleRepository.update(bundle);
    }

    @PostMapping("/api/bundles")
    public Bundle add(Bundle bundle){
        var userIdFromHttpContext = 0;
        if (bundle.getUserId() != userIdFromHttpContext){
            throw new IllegalArgumentException("You can't affect to other user's entities!");
        }
        return bundleRepository.add(bundle);
    }
}
