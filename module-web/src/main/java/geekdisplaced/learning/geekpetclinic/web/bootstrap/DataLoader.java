package geekdisplaced.learning.geekpetclinic.web.bootstrap;

import geekdisplaced.learning.geekpetclinic.model.Owner;
import geekdisplaced.learning.geekpetclinic.model.Pet;
import geekdisplaced.learning.geekpetclinic.model.PetType;
import geekdisplaced.learning.geekpetclinic.model.Vet;
import geekdisplaced.learning.geekpetclinic.services.OwnerService;
import geekdisplaced.learning.geekpetclinic.services.PetService;
import geekdisplaced.learning.geekpetclinic.services.PetTypeService;
import geekdisplaced.learning.geekpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;
    private final PetTypeService petTypeService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetService petService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");

        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");

        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loaded Pet Types... bootstrap data");

        // Manually copied from guru repo.

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");

        ownerService.save(owner2);

        System.out.println("Loaded Owners... bootstrap data");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded Vets... bootstrap data");

        Pet pet1 = new Pet();
        pet1.setName("Fluffy");
        pet1.setPetType(new PetType("Cat"));
        pet1.setBirthDate(LocalDate.of(2017,5,1));
        petService.save(pet1);

        Pet pet2 = new Pet();
        pet2.setName("Butch");
        pet2.setPetType(new PetType("Dog"));
        pet2.setBirthDate(LocalDate.of(2017,5,1));

        petService.save(pet2);

        System.out.println("Loaded Pets... bootstrap data");

    }
}
