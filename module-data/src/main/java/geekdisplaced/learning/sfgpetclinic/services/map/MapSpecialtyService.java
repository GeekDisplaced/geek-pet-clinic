package geekdisplaced.learning.sfgpetclinic.services.map;

import geekdisplaced.learning.sfgpetclinic.model.Specialty;
import geekdisplaced.learning.sfgpetclinic.services.SpecialtyService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MapSpecialtyService extends MapAbstractService<Specialty, Long> implements SpecialtyService {

    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public Specialty findById(Long Id) {
        return super.findById(Id);
    }

    @Override
    public Specialty save(Specialty object) {
        return super.save(object);
    }

    @Override
    public void deleteById(Long Id) {
        super.deleteById(Id);
    }

    @Override
    public void delete(Specialty object) {
        super.delete(object);
    }
}
