package com.gocevd.petstore.repository.jpa;

import com.gocevd.petstore.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    Pet findFirstByOwnerIsNullOrderById();
}
