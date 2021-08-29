package geekdisplaced.learning.sfgpetclinic.data.services.map;

import geekdisplaced.learning.sfgpetclinic.data.model.Owner;
import geekdisplaced.learning.sfgpetclinic.data.model.Pet;
import geekdisplaced.learning.sfgpetclinic.data.services.OwnerService;
import geekdisplaced.learning.sfgpetclinic.data.services.PetService;
import geekdisplaced.learning.sfgpetclinic.data.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class MapOwnerService extends MapAbstractService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public MapOwnerService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {

        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {

        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {

        if(object != null ) {

            // if there are Pets relationships must be confirmed...
            if(object.getPets() != null) {

                object.getPets().forEach( pet -> {

                    // check PetType relationship / id sync
                    if (pet.getType() != null) {
                        if (pet.getType().getId() == null) {
                            pet.setType(petTypeService.save(pet.getType()));
                        }
                    } else {

                        throw new RuntimeException("Pet Type is required");
                    }

                    // check Pet relationship / id sync
                    if (pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }

                });

            }

            return super.save(object);
        } else {

            return null;
        }


    }

    @Override
    public void delete(Owner object) {

        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {

        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
