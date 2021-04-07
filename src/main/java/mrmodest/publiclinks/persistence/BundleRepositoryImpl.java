package mrmodest.publiclinks.persistence;

import mrmodest.publiclinks.entities.Bundle;
import mrmodest.publiclinks.entities.repositories.BundleRepository;
import org.springframework.stereotype.Repository;

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
    public Bundle get(long id) {
        return bundleDataRepository.getOne(id);
    }

    @Override
    public Bundle add(Bundle newBundle) {
        return bundleDataRepository.save(newBundle);
    }

    @Override
    public Bundle update(Bundle updated) {
        if (updated.getId() <= 0) {
            throw new IllegalArgumentException("You trying update bundle without 'id'!");
        }
        return bundleDataRepository.save(updated);
    }
}