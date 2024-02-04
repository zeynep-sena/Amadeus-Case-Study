package com.example.demo.mapper;

import com.example.demo.dto.AirportDto;
import com.example.demo.entity.Airport;

public class AirportMapper {
 public static Airport mapToAirport(AirportDto airportDto){

        Airport airport = new Airport(
            airportDto.getId(),
            airportDto.getCity()
        );

        return airport;
    }

    public static AirportDto mapToDto(Airport airport){

        AirportDto airportDto = new AirportDto(
            airport.getId(),
            airport.getCity()
        );

        return airportDto;
    }
}
