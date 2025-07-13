package com.gocevd.petstore.service.impl;

import com.gocevd.petstore.model.*;
import com.gocevd.petstore.model.enumerations.Type;
import com.gocevd.petstore.repository.jpa.PetRepository;
import com.gocevd.petstore.service.PetService;
import net.datafaker.Faker;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PetServiceImpl implements PetService {
    Faker faker = new Faker();
    private final PetRepository petRepository;

    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public LocalDate generateRandomBirthDate(){
        return LocalDate.now().minusYears((int)(Math.random()*12)).minusMonths((int)(Math.random()*12)).minusDays((int)(Math.random()*30));
    }

    @Override
    public List<Pet> createPets() {
        List<Pet> createdPets = new ArrayList<>();
        for(int i = 1; i < 11; i++) {
            Dog dog = new Dog();
            Money money = new Money();
            dog.setName(faker.dog().name());
            dog.setDescription(faker.dog().breed());
            dog.setBirthDate(generateRandomBirthDate());
            dog.setRating((int) (Math.random()*10));
            dog.setType(Type.DOG);
            dog.setOwner(null);
            money.setAmount(dog.calculatePrice());
            dog.setPrice(money);
            createdPets.add(petRepository.save(dog));
        }
        for(int i = 1; i < 11; i++) {
            Cat cat = new Cat();
            Money money = new Money();
            cat.setName(faker.cat().name());
            cat.setDescription(faker.cat().breed());
            cat.setBirthDate(generateRandomBirthDate());
            cat.setType(Type.CAT);
            money.setAmount(cat.calculatePrice());
            cat.setPrice(money);
            cat.setOwner(null);
            createdPets.add(petRepository.save(cat));
        }
        return createdPets;
    }

    @Override
    public Pet savePet(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public List<Pet> listPets() {
        return petRepository.findAll();
    }

    @Override
    public Pet findPetWithoutOwner() {
        return petRepository.findFirstByOwnerIsNullOrderById();
    }
}
