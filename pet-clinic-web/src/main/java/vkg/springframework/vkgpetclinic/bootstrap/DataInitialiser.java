package vkg.springframework.vkgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import vkg.springframework.vkgpetclinic.model.Owner;
import vkg.springframework.vkgpetclinic.model.Vet;
import vkg.springframework.vkgpetclinic.services.OwnerService;
import vkg.springframework.vkgpetclinic.services.VetService;
import vkg.springframework.vkgpetclinic.services.map.OwnerServiceMapImpl;
import vkg.springframework.vkgpetclinic.services.map.VetServiceMapImpl;

@Component
public class DataInitialiser implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataInitialiser(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Begin Bootstrapping Data");

        System.out.println("Initialising Owners...");
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Micheal");
        owner1.setLastName("Weston");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Jean");
        owner2.setLastName("Paul");
        ownerService.save(owner2);
        System.out.println("Owners Initialised");

        System.out.println("Initialising Vets...");
        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Samuel");
        vet2.setLastName("Albert");
        vetService.save(vet2);
        System.out.println("Vets Initialised");

        System.out.println("Bootstrapping Data Completed");
    }
}
