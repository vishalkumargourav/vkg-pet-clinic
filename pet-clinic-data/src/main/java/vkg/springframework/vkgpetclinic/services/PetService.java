package vkg.springframework.vkgpetclinic.services;

import vkg.springframework.vkgpetclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
