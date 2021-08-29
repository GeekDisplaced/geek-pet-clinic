package geekdisplaced.learning.sfgpetclinic.data.services.map;

import geekdisplaced.learning.sfgpetclinic.data.model.Pet;
import geekdisplaced.learning.sfgpetclinic.data.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class MapPetService extends MapAbstractService<Pet, Long> implements PetService {

    @Override
    public Set<Pet> findAll() {

        return super.findAll();
    }

    @Override
    public Pet findById(Long id) {

        return super.findById(id);
    }

    @Override
    public Pet save(Pet object) {

        return super.save(object);
    }

    @Override
    public void delete(Pet object) {

        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {

        super.deleteById(id);
    }
}
