package geekdisplaced.learning.sfgpetclinic.controllers;

import geekdisplaced.learning.sfgpetclinic.data.model.Owner;
import geekdisplaced.learning.sfgpetclinic.data.services.OwnerService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnersControllerTest {

    @Mock
    OwnerService ownerService;

    @InjectMocks
    OwnersController ownersController;

    MockMvc mockMvc;

    Long existingOwner1Id;
    String existingOwner1LastName;

    Long existingOwner2Id;
    String existingOwner2LastName;

    Long existingOwner3Id;
    String existingOwner3LastName;

    Long existingOwner4Id;
    String existingOwner4LastName;

    Owner existingOwner1;
    Owner existingOwner2;
    Owner existingOwner3;
    Owner existingOwner4;

    Set<Owner> existingOwners;

    @BeforeEach
    void setUp() {

        // Mockito added-value UNIT testing context for @Controller
        mockMvc = MockMvcBuilders
                .standaloneSetup(ownersController)
                .build();

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

        existingOwner3Id = 3L;
        existingOwner3LastName = "Brown";

        existingOwner3 = new Owner();
        existingOwner3.setId(existingOwner3Id);
        existingOwner3.setLastName(existingOwner3LastName);

        existingOwner4Id = 4L;
        existingOwner4LastName = "Peters";

        existingOwners = new HashSet<>();

        existingOwners.add(existingOwner1);
        existingOwners.add(existingOwner2);
        existingOwners.add(existingOwner3);
        existingOwners.add(existingOwner4);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void listOwners_Root1() throws Exception {
        // mock behaviour
        when(ownerService.findAll()).thenReturn(existingOwners);

        // code under test
        mockMvc.perform(get("/owners"))
                // test assertions
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", hasSize(4)));
    }

    @Test
    void listOwners_Root2() throws Exception {
        // mock behaviour
        when(ownerService.findAll()).thenReturn(existingOwners);

        // code under test
        mockMvc.perform(get("/owners/"))
                // test assertions
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", hasSize(4)));
    }

    @Test
    void listOwners_Index1() throws Exception {
        // mock behaviour
        when(ownerService.findAll()).thenReturn(existingOwners);

        // code under test
        mockMvc.perform(get("/owners/index"))
                // test assertions
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", hasSize(4)));
    }

    @Test
    void listOwners_Index2() throws Exception {
        // mock behaviour
        when(ownerService.findAll()).thenReturn(existingOwners);

        // code under test
        mockMvc.perform(get("/owners/index.html"))
                // test assertions
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", hasSize(4)));
    }

    @Test
    void findOwners() throws Exception{
        // mock behaviour
        when(ownerService.findAll()).thenReturn(existingOwners);

        // code under test
        mockMvc.perform(get("/owners/find"))
                // test assertions
                // temporary ... this should fail as not implemented ... profession placeholder strategy?
                .andExpect(status().isOk())
                .andExpect(view().name("owners/find"))
                .andExpect(model().attribute("owners", hasSize(4)));

    }
}