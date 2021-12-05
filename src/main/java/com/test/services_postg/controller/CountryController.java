package com.test.services_postg.controller;


import com.test.services_postg.DTO.CountryDTO;
import com.test.services_postg.service.CountryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "API REST")
@RestController
@RequestMapping("/api/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping
    public ResponseEntity<?>create(@RequestBody CountryDTO countryDTO){
        return new ResponseEntity<>(CountryDTO.create(countryService.create(countryDTO)), HttpStatus.CREATED);
    }
   /* @Secured({ MyConstantsHelper.PROJECT_ROLE })
    public ResponseEntity<?> create(@RequestBody CityDTOPost cityDTOPost,
                                    @RequestHeader(name = "Authorization") String projectToken)
        return new ResponseEntity<>(MyFunctionsHelper.respond(1, "Success: successfully created.",
                cityService.create(cityDTOPost)),
                HttpStatus.CREATED);
    }*/
}
