package com.test.services_postg.DTO;

import com.test.services_postg.domain.Country;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.List;

@Data
public class CountryDTO {

    private Long id;
    private String name;
    private List<ProvinceDTO> provinceList;


    public static CountryDTO create (Country country) {
        ModelMapper modelMapper = new ModelMapper();
        CountryDTO countryDTO = modelMapper.map (country, CountryDTO.class);
        return countryDTO;
    }

    public static Country create (CountryDTO countryDTO) {
        ModelMapper modelMapper = new ModelMapper ();
        Country country = modelMapper.map (countryDTO, Country.class);
        return country;
    }
}