package com.gocevd.petstore.web.graphql;

import com.gocevd.petstore.model.Pet;
import com.gocevd.petstore.service.PetService;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PetGraphQLController {


    private final PetService petService;

    public PetGraphQLController(PetService petService) {
        this.petService = petService;
    }


    @QueryMapping
    public List<Pet> listPets() {
        return petService.listPets();
    }

    @MutationMapping
    public List<Pet> createPets() {
        return petService.createPets();
    }


}
