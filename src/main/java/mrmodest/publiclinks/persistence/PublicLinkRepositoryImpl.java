package mrmodest.publiclinks.persistence;

import org.springframework.stereotype.Repository;

import mrmodest.publiclinks.entities.PublicLink;
import mrmodest.publiclinks.entities.repositories.PublicLinkRepository;

@Repository
public class PublicLinkRepositoryImpl implements PublicLinkRepository {

    private final PublicLinkDataRepository publicLinkDataRepository;

    public PublicLinkRepositoryImpl(PublicLinkDataRepository publicLinkDataRepository){
        this.publicLinkDataRepository = publicLinkDataRepository;
    }

    @Override
    public PublicLink[] findAllByBundleId(long bundleId) {
        return publicLinkDataRepository.findAllByBundleId(bundleId).toArray(new PublicLink[0]);
    }

    @Override
    public PublicLink get(long id) {
        return publicLinkDataRepository.getOne(id);
    }

    @Override
    public PublicLink add(PublicLink newBundle) {
        return publicLinkDataRepository.save(newBundle);
    }

    @Override
    public PublicLink update(PublicLink updated) {
        if (updated.getId() <= 0) {
            throw new IllegalArgumentException("You trying update bundle without 'id'!");
        }
        return publicLinkDataRepository.save(updated);
    }
}