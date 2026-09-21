package com.anshuman.controller;

import com.anshuman.DTO.Request.TrainRequest;
import com.anshuman.DTO.Response.TrainResponse;
import com.anshuman.Service.TrainService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrainController {

    private final TrainService trainService;
    public TrainController(TrainService trainService){
        this.trainService = trainService;
    }

    @GetMapping("/trains")
    public List<TrainResponse> getAllTrains(){
        return trainService.getAllTrains();
    }

    @GetMapping("/train/{id}")
        public TrainResponse getTrainById(@PathVariable Long id){
        return trainService.getTrainByID(id);
    }

    @PostMapping("/train")
    public TrainResponse createTrain(@RequestBody TrainRequest trainRequest){
        return trainService.createTrain(trainRequest);
    }
    @PutMapping("/train/{id}")
        public TrainResponse updateTrain(@PathVariable Long id, @RequestBody TrainRequest trainRequest){
            return trainService.updateTrain(id,trainRequest);
    }

    @DeleteMapping("/train/{id}")
    public TrainResponse deleteTrainById(@PathVariable Long id){
        return trainService.deleteTrain(id);
    }
}
