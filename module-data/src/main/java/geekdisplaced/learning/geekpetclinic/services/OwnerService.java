package geekdisplaced.learning.geekpetclinic.services;

import geekdisplaced.learning.geekpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);
}
