package com.test.services_postg.service;


import com.test.services_postg.DTO.CountryDTO;
import com.test.services_postg.domain.Country;
import com.test.services_postg.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public Country create(CountryDTO countryDTO){

        if (countryRepository.findByName(countryDTO.getName()).isPresent()) {
            throw new RuntimeException("This Country already exists");
        }
        return countryRepository.save(CountryDTO.create(countryDTO));
    }


}
