package geekdisplaced.learning.sfgpetclinic.services.sdjpa;

import geekdisplaced.learning.sfgpetclinic.model.Pet;
import geekdisplaced.learning.sfgpetclinic.repositories.PetRepository;
import geekdisplaced.learning.sfgpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("sdjpa")
public class SdjpaPetService extends SdjpaAbstractService implements PetService {

    private final PetRepository petRepositiory;

    public SdjpaPetService(PetRepository petRepositiory) {
        this.petRepositiory = petRepositiory;
    }

    @Override
    public Set<Pet> findAll() {

        Set<Pet> pets = new HashSet<>();

        petRepositiory.findAll().forEach(pets::add);

        return pets;
    }

    @Override
    public Pet findById(Long id) {

        return petRepositiory.findById(id).orElse(null);
    }

    @Override
    public Pet save(Pet object) {

        return petRepositiory.save(object);
    }

    @Override
    public void delete(Pet object) {

        petRepositiory.delete(object);
    }

    @Override
    public void deleteById(Long id) {

        petRepositiory.deleteById(id);
    }
}
