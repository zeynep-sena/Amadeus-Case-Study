package com.example.demo.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.FlightDto;
import com.example.demo.entity.Flight;
import com.example.demo.mapper.FlightMapper;
import com.example.demo.repository.FlightRepository;
import com.example.demo.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService{

    private FlightRepository flightRepository; // dependency injection

    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public FlightDto createFlight(FlightDto flightDto) {
        Flight flight = FlightMapper.mapToFlight(flightDto);
        Flight newFlight = flightRepository.save(flight);
        return FlightMapper.mapToDto(newFlight);
    }

    @Override
    public List<FlightDto> getAllFlights(){
        
        List<FlightDto> newList = new ArrayList<>();
        
        for (Flight f : flightRepository.findAll()) {
            newList.add(FlightMapper.mapToDto(f));
        }
        return newList;
    }

    @Override
    public void deleteFlightById(int id){
        flightRepository.deleteById(id);
    }
}
