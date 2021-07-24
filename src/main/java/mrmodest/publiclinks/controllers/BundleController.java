package mrmodest.publiclinks.controllers;

import org.springframework.web.bind.annotation.*;

import mrmodest.publiclinks.entities.Bundle;
import mrmodest.publiclinks.entities.repositories.BundleRepository;
import mrmodest.publiclinks.utils.AuthUtils;

@RestController
public class BundleController {

    private final BundleRepository bundleRepository;

    public BundleController(BundleRepository bundleRepository){

        this.bundleRepository = bundleRepository;
    }

    @GetMapping("/api/bundles/{language}")
    public Bundle[] getByLanguage(@PathVariable String language){
        return bundleRepository.findAllByLanguage(
            AuthUtils.getUserFromContext().getId(),
            language);
    }

    @PutMapping("/api/bundles")
    public Bundle edit(Bundle bundle){
        AuthUtils.CheckOwner(bundle);
        return bundleRepository.update(bundle);
    }

    @PostMapping("/api/bundles")
    public Bundle add(Bundle bundle){
        AuthUtils.CheckOwner(bundle);
        return bundleRepository.add(bundle);
    }
}
