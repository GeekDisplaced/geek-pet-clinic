package geekdisplaced.learning.geekpetclinic.services;

import geekdisplaced.learning.geekpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findById(Long Id);

    Owner findByLastName(String lastName);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
