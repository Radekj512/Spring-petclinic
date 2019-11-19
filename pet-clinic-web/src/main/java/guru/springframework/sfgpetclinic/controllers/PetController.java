package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PetController {
    @RequestMapping("/pet")
    public String getPetPage(){
        return "pet";
    }
}
