package geekdisplaced.learning.sfgpetclinic.model;

import java.time.LocalDate;

public class Pet extends NamedEntity {

    private PetType type;
    private Owner owner;
    private LocalDate birthDate;

    public PetType getType() {
        return type;
    }

    public void setType(PetType petType) {
        this.type = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
