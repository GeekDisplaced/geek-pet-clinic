package geekdisplaced.learning.sfgpetclinic.data.services.sdjpa;

import geekdisplaced.learning.sfgpetclinic.data.model.Owner;
import geekdisplaced.learning.sfgpetclinic.data.repositories.OwnerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SdjpaOwnerServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    SdjpaOwnerService sdjpaOwnerService;

    Long existingOwner1Id;
    String existingOwner1LastName;

    Long existingOwner2Id;
    String existingOwner2LastName;

    Long createOwner3Id;
    String createOwner3LastName;

    Owner existingOwner1;
    Owner existingOwner2;
    Owner createOwner3;

    Set<Owner> existingOwners = new HashSet<>();

    Long absentOwner4Id;
    String absentOwner4LastName;

    @BeforeEach
    void setUp() {

        // mock data
        existingOwner1Id = 1L;
        existingOwner1LastName = "Smith";

        existingOwner1 = new Owner();
        existingOwner1.setId(existingOwner1Id);
        existingOwner1.setLastName(existingOwner1LastName);

        existingOwner2Id = 2L;
        existingOwner2LastName = "Jones";

        existingOwner2 = new Owner();
        existingOwner2.setId(existingOwner2Id);
        existingOwner2.setLastName(existingOwner2LastName);

        existingOwners.add(existingOwner1);
        existingOwners.add(existingOwner2);

        createOwner3Id = 3L;
        createOwner3LastName = "Brown";

        createOwner3 = new Owner();
        createOwner3.setId(createOwner3Id);
        createOwner3.setLastName(createOwner3LastName);

        absentOwner4Id = 4L;
        absentOwner4LastName = "Peters";

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findByLastName() {
        // mock behaviour
        when(ownerRepository.findByLastName(existingOwner1LastName)).thenReturn(existingOwner1);

        // code under test
        Owner mockReturnedOwner = sdjpaOwnerService.findByLastName(existingOwner1LastName);

        // test
        assertEquals( existingOwner1LastName, mockReturnedOwner.getLastName());
        verify(ownerRepository, times(1)).findByLastName(any());
    }

    @Test
    void findAll() {
        // mock behaviour
        when(ownerRepository.findAll()).thenReturn(existingOwners);

        // code under test
        Set<Owner> mockReturnedOwners = sdjpaOwnerService.findAll();

        //test
        assertNotNull(existingOwners);
        assertEquals(2, mockReturnedOwners.size());
        verify(ownerRepository, times(1)).findAll();
    }

    @Test
    void findById_Exists() {
        // mock behaviour
        when(ownerRepository.findById(existingOwner2Id)).thenReturn(Optional.of(existingOwner2));

        // code under test
        Owner mockReturnedOwner = sdjpaOwnerService.findById(existingOwner2Id);

        // test
        assertNotNull(mockReturnedOwner);
        verify(ownerRepository, times(1)).findById(any());
    }

    void findById_Absent() {
        // mock behaviour
        when(ownerRepository.findById(absentOwner4Id)).thenReturn(Optional.empty());

        // code under test
        Owner mockReturnedOwner = sdjpaOwnerService.findById(absentOwner4Id);

        // test
        assertNull(mockReturnedOwner);
        verify(ownerRepository, times(1)).findById(any());
    }

    @Test
    void save() {
        // mock behaviour
        when(ownerRepository.save(createOwner3)).thenReturn(createOwner3);

        // code under test
        Owner mockReturnedOwner = sdjpaOwnerService.save(createOwner3);

        // test
        assertNotNull(mockReturnedOwner);
        verify(ownerRepository, times(1)).save(any());
    }

    @Test
    void delete() {
        // mock behaviour
        // method being tested return void so nothing to mock...

        // code under test
        sdjpaOwnerService.delete(existingOwner1);

        // test
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        // mock behaviour
        // method being tested return void so nothing to mock...

        // code under test
        sdjpaOwnerService.deleteById(existingOwner1Id);

        // test
        verify(ownerRepository, times(1)).deleteById(any());
    }
}