package com.test.services_postg.DTO;

import lombok.Data;

import java.util.List;

import com.test.services_postg.domain.Province;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class ProvinceDTO {

    private Long id;
    private String name;
    private List<CityDTO> cityList;
    private CountryDTO country;
    private Long id_country;

    public static ProvinceDTO create (Province province) {
        ModelMapper modelMapper = new ModelMapper ();
        ProvinceDTO provinceDTO = modelMapper.map (province, ProvinceDTO.class);
        return provinceDTO;
    }

    public static Province create (ProvinceDTO provinceDTO) {
        ModelMapper modelMapper = new ModelMapper ();
        Province province = modelMapper.map (provinceDTO, Province.class);
        return province;
    }
}
