package mrmodest.publiclinks.persistence;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import mrmodest.publiclinks.entities.PublicLink;
import mrmodest.publiclinks.entities.repositories.PublicLinkRepository;
import mrmodest.publiclinks.persistence.jpa.PublicLinkDataRepository;
import mrmodest.publiclinks.utils.PersistenceUtils;

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
    public Optional<PublicLink> find(long id) {
        return publicLinkDataRepository.findById(id);
    }

    @Override
    public PublicLink add(PublicLink newPublicLink) {
        PersistenceUtils.CheckIsNew(newPublicLink);
        return publicLinkDataRepository.save(newPublicLink);
    }

    @Override
    public PublicLink update(PublicLink updated) {
        PersistenceUtils.CheckIsNotNew(updated);
        return publicLinkDataRepository.save(updated);
    }
}
