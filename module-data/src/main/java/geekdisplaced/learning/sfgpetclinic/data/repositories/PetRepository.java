package geekdisplaced.learning.sfgpetclinic.data.repositories;

import geekdisplaced.learning.sfgpetclinic.data.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
