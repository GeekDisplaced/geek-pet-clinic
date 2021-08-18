package geekdisplaced.learning.geekpetclinic.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pets")
public class PetsController {

    @RequestMapping({"", "/", "/index", "/index.html" })
    public String index(){

        return "pets/index";
    }
}
