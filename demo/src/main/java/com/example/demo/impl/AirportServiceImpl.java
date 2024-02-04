package com.example.demo.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AirportDto;
import com.example.demo.entity.Airport;
import com.example.demo.mapper.AirportMapper;
import com.example.demo.repository.AirportRepository;
import com.example.demo.service.AirportService;

@Service
public class AirportServiceImpl implements AirportService{
   
    private AirportRepository airportRepository;
    
    public AirportServiceImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public AirportDto createAirport(AirportDto airportDto) {
        Airport airport = AirportMapper.mapToAirport(airportDto);
        Airport newAirport = airportRepository.save(airport);
        return AirportMapper.mapToDto(newAirport);
    }

    @Override
    public List<AirportDto> getAllAirports() {
        List<AirportDto> newList = new ArrayList<>();
        
        for (Airport f : airportRepository.findAll()) {
            newList.add(AirportMapper.mapToDto(f));
        }
        return newList;
    }

    @Override
    public void deleteAirportById(int id) {
        airportRepository.deleteById(id);
    }

}
