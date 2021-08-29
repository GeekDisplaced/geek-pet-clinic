package geekdisplaced.learning.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter

@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

}
