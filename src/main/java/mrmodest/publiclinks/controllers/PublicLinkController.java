package mrmodest.publiclinks.controllers;

import org.springframework.web.bind.annotation.*;

import mrmodest.publiclinks.entities.PublicLink;
import mrmodest.publiclinks.entities.repositories.PublicLinkRepository;

@RestController
public class PublicLinkController {

    private final PublicLinkRepository publicLinkRepository;

    public PublicLinkController(PublicLinkRepository publicLinkRepository){

        this.publicLinkRepository = publicLinkRepository;
    }

    @GetMapping("/api/public-links/{bundleId}")
    public PublicLink[] getByBundleId(@PathVariable long bundleId){
        return publicLinkRepository.findAllByBundleId(bundleId);
    }

    @PutMapping("/api/public-links")
    public PublicLink edit(PublicLink publicLink){
        return publicLinkRepository.update(publicLink);
    }

    @PostMapping("/api/public-links")
    public PublicLink add(PublicLink publicLink){
        return publicLinkRepository.add(publicLink);
    }
}
