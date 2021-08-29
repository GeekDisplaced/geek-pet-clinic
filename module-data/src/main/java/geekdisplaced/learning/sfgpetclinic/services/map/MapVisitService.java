package geekdisplaced.learning.sfgpetclinic.services.map;

import geekdisplaced.learning.sfgpetclinic.model.Pet;
import geekdisplaced.learning.sfgpetclinic.model.Visit;
import geekdisplaced.learning.sfgpetclinic.repositories.VisitRepository;
import geekdisplaced.learning.sfgpetclinic.services.PetService;
import geekdisplaced.learning.sfgpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile({"default", "map"})
public class MapVisitService extends MapAbstractService<Visit, Long> implements VisitService {

    private final PetService petService;

    public MapVisitService(PetService petService) {
        this.petService = petService;
    }

    @Override
    public Set<Visit> findAll() {

        return super.findAll();
    }

    @Override
    public Visit findById(Long id) {

        return super.findById(id);
    }

    @Override
    public Visit save(Visit object) {

        if(object != null ) {

            // if there is a Pet relationships must be confirmed...
            if(object.getPet() != null) {

                Pet pet = object.getPet();

                if (pet.getId() == null) {
                    Pet savedPet = petService.save(pet);
                    pet.setId(savedPet.getId());
                }

                return super.save(object);
            } else {

                throw new RuntimeException("Pet is required");
            }

        } else {

            return null;
        }

    }

    @Override
    public void deleteById(Long id) {

        super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {

        super.delete(object);
    }
}
