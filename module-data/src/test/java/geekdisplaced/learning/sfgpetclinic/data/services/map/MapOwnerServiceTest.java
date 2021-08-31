package geekdisplaced.learning.sfgpetclinic.data.services.map;

import geekdisplaced.learning.sfgpetclinic.data.model.Owner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MapOwnerServiceTest {

    MapOwnerService mapOwnerService;

    final Long existingOwnerId = 1L;
    final String existingOwnerLastName = "Smith";
    final Long createdOwnerId = 2L;
    final String absentOwnerLastName = "Foo";

    @BeforeEach
    void setUp() {
        mapOwnerService = new MapOwnerService(new MapPetTypeService(), new MapPetService());
        Owner existingOwner = new Owner();
        existingOwner.setId(existingOwnerId);
        existingOwner.setLastName(existingOwnerLastName);
        mapOwnerService.save(existingOwner);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void findAll() {
        Set<Owner> owners = mapOwnerService.findAll();

        assertEquals(1, owners.size());
    }

    @Test
    void findById() {
        Owner owner = mapOwnerService.findById(existingOwnerId);

        assertEquals(existingOwnerId, owner.getId());
    }

    @Test
    void save_IdProvided() {
        Owner createdOwner = new Owner();
        createdOwner.setId(createdOwnerId);

        Owner savedOwner = mapOwnerService.save(createdOwner);

        assertEquals(createdOwnerId, savedOwner.getId());
    }

    @Test
    void save_IdOmitted() {
        Owner createdOwner = new Owner();

        Owner savedOwner = mapOwnerService.save(createdOwner);

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        Owner existingOwner = mapOwnerService.findById(existingOwnerId);

        mapOwnerService.delete(existingOwner);

        assertNull(mapOwnerService.findById(existingOwnerId));
        assertEquals(0, mapOwnerService.findAll().size());
    }

    @Test
    void deleteById() {

        mapOwnerService.deleteById(existingOwnerId);

        assertNull(mapOwnerService.findById(existingOwnerId));
        assertEquals(0, mapOwnerService.findAll().size());
    }

    @Test
    void findByLastName_Exists() {

        Owner existingOwner = mapOwnerService.findByLastName(existingOwnerLastName);

        assertNotNull(existingOwner);
    }

    @Test
    void findByLastName_NonExistent() {

        Owner existingOwner = mapOwnerService.findByLastName(absentOwnerLastName);

        assertNull(existingOwner);
    }
}