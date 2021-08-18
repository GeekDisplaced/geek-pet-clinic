package geekdisplaced.learning.geekpetclinic.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(scanBasePackages = "geekdisplaced.learning.geekpetclinic.*")
public class GeekPetClinicApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeekPetClinicApplication.class, args);
    }

}
