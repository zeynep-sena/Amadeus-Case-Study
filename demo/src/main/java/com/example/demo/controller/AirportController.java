package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AirportDto;
import com.example.demo.service.AirportService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class AirportController {

    private AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @PostMapping("/addAirport")
    public ResponseEntity<AirportDto> addAirport(@RequestBody AirportDto airportDto) {
        return new ResponseEntity<>(airportService.createAirport(airportDto), HttpStatus.CREATED);
    }
    
    
    @GetMapping("/getAllAirports")
    public ResponseEntity<List<AirportDto>> getAllAirports(){
        return new ResponseEntity<>(airportService.getAllAirports(), HttpStatus.FOUND);
    }

    @DeleteMapping("/deleteAirport/{id}")
    public ResponseEntity<String> deleteAirportById(@PathVariable int id) {
        airportService.deleteAirportById(id);
        return ResponseEntity.ok("Deleted successfully");
    }

}
