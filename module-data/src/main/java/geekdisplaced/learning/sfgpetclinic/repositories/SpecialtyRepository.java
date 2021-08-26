package geekdisplaced.learning.sfgpetclinic.repositories;

import geekdisplaced.learning.sfgpetclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
