package com.test.services_postg.repository;

import com.test.services_postg.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {

    Optional <Country> findByName(String nome);
    //Optional <Country> findByIdOrThrowBadRequestBody(Long id);
    Optional<Country> findById(Long id);

}
