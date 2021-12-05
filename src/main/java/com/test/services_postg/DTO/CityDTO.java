package com.test.services_postg.DTO;

import com.test.services_postg.domain.City;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class CityDTO {

    private Long id;
    private String name;
    //private List<AddressDTO> addressList;
    private ProvinceDTO province;

    public static CityDTO create (City city) {
        ModelMapper modelMapper = new ModelMapper ();
        CityDTO cityDTO = modelMapper.map (city, CityDTO.class);
        return cityDTO;
    }

    public static City create (CityDTO cityDTO) {
        ModelMapper modelMapper = new ModelMapper ();
        City city = modelMapper.map (cityDTO, City.class);
        return city;
    }
}