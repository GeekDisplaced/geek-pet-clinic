package geekdisplaced.learning.geekpetclinic.services.map;

import geekdisplaced.learning.geekpetclinic.model.PetType;
import geekdisplaced.learning.geekpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MapPetTypeService extends AbstractMapService<PetType, Long> implements PetTypeService {


    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }
}
