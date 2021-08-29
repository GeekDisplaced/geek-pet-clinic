package geekdisplaced.learning.sfgpetclinic.web.controllers;

import geekdisplaced.learning.sfgpetclinic.data.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vets")
public class VetsController {

    private final VetService vetService;

    public VetsController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({ "", "/", "/index", "/index.html"})
    public String index(Model model){

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
}
