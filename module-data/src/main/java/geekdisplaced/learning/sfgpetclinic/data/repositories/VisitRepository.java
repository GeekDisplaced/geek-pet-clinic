package geekdisplaced.learning.sfgpetclinic.data.repositories;

import geekdisplaced.learning.sfgpetclinic.data.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
