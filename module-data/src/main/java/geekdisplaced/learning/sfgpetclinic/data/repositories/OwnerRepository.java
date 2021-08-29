package geekdisplaced.learning.sfgpetclinic.data.repositories;

import geekdisplaced.learning.sfgpetclinic.data.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
}
