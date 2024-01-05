package com.crud.crud.repositories;

import com.crud.crud.entity.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonModel, Long> {
    PersonModel findByEmail(String email);
}
