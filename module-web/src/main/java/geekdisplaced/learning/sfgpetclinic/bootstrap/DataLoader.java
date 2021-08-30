package geekdisplaced.learning.sfgpetclinic.web.bootstrap;

import geekdisplaced.learning.sfgpetclinic.data.model.*;
import geekdisplaced.learning.sfgpetclinic.data.services.*;
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
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetService petService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        // add check for existing data here...
        if (true) {

            loadData();
        }

    }

    private void loadData() {
        PetType petType1 = new PetType();
        petType1.setName("Dog");

        PetType savedDogPetType = petTypeService.save(petType1);

        PetType petType2 = new PetType();
        petType2.setName("Cat");

        PetType savedCatPetType = petTypeService.save(petType2);

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
        Specialty savedSpecialty2 = specialtyService.save(dentistry);

        Specialty radiology = new Specialty();
        surgery.setDescription("Radiology");
        Specialty savedSpecialty3 = specialtyService.save(radiology);

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

        Visit visit1 = new Visit();
        visit1.setPet(savedPet1);
        visit1.setDate(LocalDate.now());
        visit1.setDescription("Sick Kitty");

        visitService.save(visit1);

        Visit visit2 = new Visit();
        visit2.setPet(savedPet2);
        visit2.setDate(LocalDate.now());
        visit2.setDescription("Swallowed tennis ball");

        visitService.save(visit2);

        System.out.println("Loaded Visits... bootstrap data");
    }
}
