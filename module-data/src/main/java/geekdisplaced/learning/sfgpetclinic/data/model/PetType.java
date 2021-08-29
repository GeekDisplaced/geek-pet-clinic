package geekdisplaced.learning.sfgpetclinic.data.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@RequiredArgsConstructor

@Entity
@Table(name = "types")
public class PetType extends NamedEntity {


}
