package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.AirportDto;

public interface AirportService {
    AirportDto createAirport(AirportDto airportDto);
    List<AirportDto> getAllAirports();
    void deleteAirportById(int id);
}
