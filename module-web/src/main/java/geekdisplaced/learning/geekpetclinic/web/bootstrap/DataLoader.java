package geekdisplaced.learning.geekpetclinic.web.bootstrap;

import geekdisplaced.learning.geekpetclinic.model.*;
import geekdisplaced.learning.geekpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetService petService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        // add check for existing data here...
        if (true) {

            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");

        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");

        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loaded Pet Types... bootstrap data");

        Pet pet1 = new Pet();
        pet1.setName("Fluffy");
        pet1.setType(savedCatPetType);
        pet1.setBirthDate(LocalDate.of(2017,5,1));

        Pet savedPet1 = petService.save(pet1);

        Pet pet2 = new Pet();
        pet2.setName("Butch");
        pet2.setType(savedDogPetType);
        pet2.setBirthDate(LocalDate.of(2017,5,1));

        Pet savedPet2 = petService.save(pet2);

        System.out.println("Loaded Pets... bootstrap data");

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSpecialty1 = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        surgery.setDescription("Dentistry");
        Specialty savedSpecialty2 = specialtyService.save(surgery);

        Specialty radiology = new Specialty();
        surgery.setDescription("Radiology");
        Specialty savedSpecialty3 = specialtyService.save(surgery);

        System.out.println("Loaded Specialties... bootstrap data");

        // Manually copied from guru repo.

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("1 Infinite Loop");
        owner1.setCity("Silicon Vally");
        owner1.setTelephone("555-98721387431207");
        owner1.getPets().add(savedPet1);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("1 Infinite Loop");
        owner2.setCity("Silicon Vally");
        owner2.setTelephone("555-98721387431207");
        owner2.getPets().add(savedPet2);

        ownerService.save(owner2);

        System.out.println("Loaded Owners with Pets... bootstrap data");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(savedSpecialty1);
        vet1.getSpecialties().add(savedSpecialty3);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialties().add(savedSpecialty2);

        vetService.save(vet2);

        System.out.println("Loaded Vets... bootstrap data");
    }
}
