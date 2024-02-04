package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.FlightDto;
import com.example.demo.service.FlightService;

@RestController
public class FlightController {

    private FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping("/addFlight")
    public ResponseEntity<FlightDto> addFlight(@RequestBody FlightDto flightDto){
        return new ResponseEntity<>(flightService.createFlight(flightDto), HttpStatus.CREATED);
    }

    @GetMapping("/getAllFlights")
    public ResponseEntity<List<FlightDto>> getAllFlights(){
        return new ResponseEntity<>(flightService.getAllFlights(), HttpStatus.FOUND);
    }

    @DeleteMapping("/deleteFlight/{id}")
    public ResponseEntity<String> deleteFlightById(@PathVariable int id) {
        flightService.deleteFlightById(id);
        return ResponseEntity.ok("Deleted successfully");
    }
    
}
