package geekdisplaced.learning.geekpetclinic.services;

import geekdisplaced.learning.geekpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long Id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
