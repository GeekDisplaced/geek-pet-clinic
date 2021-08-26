package geekdisplaced.learning.sfgpetclinic.repositories;

import geekdisplaced.learning.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
