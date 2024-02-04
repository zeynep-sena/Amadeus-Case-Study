package com.example.demo.service;


import java.util.List;

import com.example.demo.dto.FlightDto;

public interface FlightService {

    FlightDto createFlight(FlightDto flightDto);
    List<FlightDto> getAllFlights();
    void deleteFlightById(int id);
}
