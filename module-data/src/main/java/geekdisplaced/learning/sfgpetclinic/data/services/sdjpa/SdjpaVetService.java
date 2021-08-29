package geekdisplaced.learning.sfgpetclinic.data.services.sdjpa;

import geekdisplaced.learning.sfgpetclinic.data.model.Vet;
import geekdisplaced.learning.sfgpetclinic.data.repositories.VetRepository;
import geekdisplaced.learning.sfgpetclinic.data.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("sdjpa")
public class SdjpaVetService extends SdjpaAbstractService implements VetService {

    private final VetRepository vetRepository;

    public SdjpaVetService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {

        Set<Vet> vets = new HashSet<>();

        vetRepository.findAll().forEach(vets::add);

        return vets;
    }

    @Override
    public Vet findById(Long id) {

        return vetRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet object) {

        // what about related elements, as was the requirement with map implementation
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {

        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {

        vetRepository.deleteById(id);
    }
}
