package com.gocevd.petstore.web;

import com.gocevd.petstore.model.Pet;
import com.gocevd.petstore.service.PetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/list-pets")
    public List<Pet> listPets() {
        return petService.listPets();
    }

    @PostMapping("/create-pets")
    public void createPets() {
        petService.createPets();
    }
}
