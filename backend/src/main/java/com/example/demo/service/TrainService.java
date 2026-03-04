package com.example.demo.service;

import com.example.demo.model.Train;
import com.example.demo.repository.TrainRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {

    private final TrainRepository trainRepository;

    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    public List<Train> getAllTrains() {
        return trainRepository.findAll();
    }

    public Train saveTrain(Train train) {
        return trainRepository.save(train);
    }
}