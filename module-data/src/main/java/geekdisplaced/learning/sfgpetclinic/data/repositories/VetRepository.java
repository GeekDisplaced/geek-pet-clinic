package geekdisplaced.learning.sfgpetclinic.data.repositories;

import geekdisplaced.learning.sfgpetclinic.data.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
