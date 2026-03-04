package com.example.demo.service;

import com.example.demo.model.TrainRoute;
import com.example.demo.repository.TrainRouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainRouteService {

    private final TrainRouteRepository trainRouteRepository;

    public TrainRouteService(TrainRouteRepository trainRouteRepository) {
        this.trainRouteRepository = trainRouteRepository;
    }

    public List<TrainRoute> getAllRoutes() {
        return trainRouteRepository.findAll();
    }

    public List<TrainRoute> searchRoutes(Long fromId, Long toId) {
        return trainRouteRepository.findRoutes(fromId, toId);
    }

    public List<TrainRoute> getRoutesByTrainId(Long trainId) {
        return trainRouteRepository.findByTrainId(trainId);
    }
}