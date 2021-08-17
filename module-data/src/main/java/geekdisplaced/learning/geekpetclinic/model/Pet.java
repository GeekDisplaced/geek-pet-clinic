package geekdisplaced.learning.geekpetclinic.model;

import java.util.Date;

public class Pet extends BaseEntity {

    private PetType petype;
    private Owner owner;
    private Date birthDate;

    public Pet(PetType petype, Owner owner, Date birthDate) {
        this.petype = petype;
        this.owner = owner;
        this.birthDate = birthDate;
    }

    public PetType getPetype() {
        return petype;
    }

    public void setPetype(PetType petype) {
        this.petype = petype;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
