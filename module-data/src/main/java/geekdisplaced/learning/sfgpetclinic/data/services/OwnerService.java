package geekdisplaced.learning.sfgpetclinic.data.services;

import geekdisplaced.learning.sfgpetclinic.data.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);
}
