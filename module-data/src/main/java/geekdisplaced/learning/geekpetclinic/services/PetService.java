package geekdisplaced.learning.geekpetclinic.services;

import geekdisplaced.learning.geekpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Pet Id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
