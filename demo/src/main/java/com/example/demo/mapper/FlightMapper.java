package com.example.demo.mapper;

import com.example.demo.dto.FlightDto;
import com.example.demo.entity.Flight;

public class FlightMapper {
    public static Flight mapToFlight(FlightDto flightDto){

        Flight flight = new Flight(
            flightDto.getId(),
            flightDto.getDepartureAirport(),
            flightDto.getArrivalAirport(),
            flightDto.getDepartureDate(),
            flightDto.getReturnDate(),
            flightDto.getPrice()
        );

        return flight;
    }

    public static FlightDto mapToDto(Flight flight){

        FlightDto flightDto = new FlightDto(
            flight.getId(),
            flight.getDepartureAirport(),
            flight.getArrivalAirport(),
            flight.getDepartureDate(),
            flight.getReturnDate(),
            flight.getPrice()
        );

        return flightDto;
    }
}
