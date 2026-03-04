package com.example.demo.controller;

import com.example.demo.model.TrainRoute;
import com.example.demo.service.TrainRouteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/train-routes")
@CrossOrigin(origins = "http://localhost:4200")
public class TrainRouteController {

    private final TrainRouteService trainRouteService;

    public TrainRouteController(TrainRouteService trainRouteService) {
        this.trainRouteService = trainRouteService;
    }

    // 1) Get all train routes
    @GetMapping
    public List<TrainRoute> getAllRoutes() {
        return trainRouteService.getAllRoutes();
    }

    // 2) Search by from & to station ids
    // Example: /api/train-routes/search?from=1&to=3
    @GetMapping("/search")
    public List<TrainRoute> searchRoutes(@RequestParam("fromId")Long fromId, @RequestParam ("toId")Long toId) {
        return trainRouteService.searchRoutes(fromId, toId);
    }

    // 3) Optional: get routes by train id
    // Example: /api/train-routes/train/2
    @GetMapping("/train/{trainId}")
    public List<TrainRoute> getRoutesByTrainId(@PathVariable Long trainId) {
        return trainRouteService.getRoutesByTrainId(trainId);
    }
}