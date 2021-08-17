package geekdisplaced.learning.geekpetclinic.services.map;

import geekdisplaced.learning.geekpetclinic.model.Owner;
import geekdisplaced.learning.geekpetclinic.services.CrudService;
import geekdisplaced.learning.geekpetclinic.services.OwnerService;

import java.util.Set;

public class MapOwnerService extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long> {

    @Override
    public Set<Owner> findAll() {

        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {

        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {

        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Owner object) {

        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {

        super.deleteById(id);
    }

}
