package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PetController {
    @RequestMapping("/pets")
    public String getPets(){
        return "pets/index";
    }
}
