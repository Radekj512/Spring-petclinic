package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialityService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count ==0){
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");

        PetType cat = new PetType();
        cat.setName("Cat");

        PetType savedDogPetType = petTypeService.save(dog);
        PetType savedCatPetType = petTypeService.save(cat);

        Owner o1 = new Owner();
        o1.setFirstName("Antoni");
        o1.setLastName("Macierewicz");
        o1.setAddress("Nowa 15");
        o1.setCity("Lodz");
        o1.setTelephone("534711332");

        Pet p1 = new Pet();
        p1.setPetType(savedCatPetType);
        p1.setOwner(o1);
        p1.setName("rex");
        p1.setBirthDate(LocalDate.of(2017, Month.DECEMBER,25));

        o1.getPets().add(p1);

        Owner o2 = new Owner();
        o2.setFirstName("Jan");
        o2.setLastName("Kowalski");
        o2.setAddress("Nowa 15");
        o2.setCity("Lodz");
        o2.setTelephone("534711332");

        ownerService.save(o1);
        ownerService.save(o2);

        Vet v1 = new Vet();
        v1.setFirstName("Vet1");
        v1.setLastName("1etv");

        Speciality s1 = new Speciality();
        s1.setDescription("radiology");

        Speciality s2 = new Speciality();
        s1.setDescription("surgery");

        Speciality s3 = new Speciality();
        s3.setDescription("dentistry");

        Speciality saveds1 = specialityService.save(s1);
        Speciality saveds2 = specialityService.save(s2);
        Speciality saveds3 = specialityService.save(s3);

        v1.getSpecialities().add(saveds1);
        v1.getSpecialities().add(saveds2);
        v1.getSpecialities().add(saveds3);
        vetService.save(v1);
    }
}
