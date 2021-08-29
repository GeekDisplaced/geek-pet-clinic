package geekdisplaced.learning.sfgpetclinic.data.repositories;

import geekdisplaced.learning.sfgpetclinic.data.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
