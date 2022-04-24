package org.ginko.covidstat.dto.mapper;

import org.ginko.covidstat.dto.CityDTO;
import org.ginko.covidstat.model.City;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {

    CityMapper INST = Mappers.getMapper(CityMapper.class);

    CityDTO asCityDTO(City city);

    List<CityDTO> asCityList(List<City> cities);

}
