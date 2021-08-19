package geekdisplaced.learning.geekpetclinic.web.controllers;

import geekdisplaced.learning.geekpetclinic.services.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pets")
public class PetsController {

    private final PetService petService;

    public PetsController(PetService petService) {
        this.petService = petService;
    }

    @RequestMapping({"", "/", "/index", "/index.html" })
    public String index(Model model){

        model.addAttribute("pets", petService.findAll());

        return "pets/index";
    }
}
