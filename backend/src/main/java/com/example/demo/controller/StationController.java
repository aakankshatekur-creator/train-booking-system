package com.example.demo.controller;

import com.example.demo.model.Station;
import com.example.demo.service.StationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stations")
@CrossOrigin(origins = "http://localhost:4200")
public class StationController {

    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @GetMapping
    public List<Station> getAllStations() {
        return stationService.getAllStations();
    }
}