package geekdisplaced.learning.sfgpetclinic.model;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
