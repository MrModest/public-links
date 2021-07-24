package mrmodest.publiclinks.persistence;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import mrmodest.publiclinks.entities.Bundle;
import mrmodest.publiclinks.entities.repositories.BundleRepository;
import mrmodest.publiclinks.persistence.jpa.BundleDataRepository;
import mrmodest.publiclinks.utils.PersistenceUtils;

@Repository
public class BundleRepositoryImpl implements BundleRepository {

    private final BundleDataRepository bundleDataRepository;

    public BundleRepositoryImpl(BundleDataRepository bundleDataRepository){
        this.bundleDataRepository = bundleDataRepository;
    }

    @Override
    public Bundle[] findAllByLanguage(long userId, String language) {
        return bundleDataRepository.findAllByUserIdAndLanguage(userId, language).toArray(new Bundle[0]);
    }

    @Override
    public Optional<Bundle> find(long id) {
        return bundleDataRepository.findById(id);
    }

    @Override
    public Bundle add(Bundle newBundle) {
        PersistenceUtils.CheckIsNew(newBundle);
        return bundleDataRepository.save(newBundle);
    }

    @Override
    public Bundle update(Bundle updated) {
        PersistenceUtils.CheckIsNotNew(updated);
        return bundleDataRepository.save(updated);
    }
}
