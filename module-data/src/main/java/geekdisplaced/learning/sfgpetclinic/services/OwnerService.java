package geekdisplaced.learning.sfgpetclinic.services;

import geekdisplaced.learning.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);
}
