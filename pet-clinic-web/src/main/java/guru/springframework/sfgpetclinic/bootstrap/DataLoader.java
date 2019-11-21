package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner o1 = new Owner();
        o1.setFirstName("Antoni");
        o1.setLastName("Macierewicz");

        Owner o2 = new Owner();
        o2.setFirstName("Jan");
        o2.setLastName("Kowalski");

        ownerService.save(o1);
        ownerService.save(o2);

        Vet v1 = new Vet();
        v1.setFirstName("Vet1");
        v1.setLastName("1etv");

        vetService.save(v1);
    }
}
