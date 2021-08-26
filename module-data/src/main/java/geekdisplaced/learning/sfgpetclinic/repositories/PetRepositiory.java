package geekdisplaced.learning.sfgpetclinic.repositories;

import geekdisplaced.learning.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepositiory extends CrudRepository<Pet, Long> {
}
