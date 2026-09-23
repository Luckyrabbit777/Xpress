package com.anshuman.Service;

import com.anshuman.DTO.Request.TrainRequest;
import com.anshuman.DTO.Response.TrainResponse;
import com.anshuman.Exception.TrainNotFoundException;
import com.anshuman.entity.Train;
import com.anshuman.storage.TrainRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class TrainService {

    private TrainRepository trainRepository;
    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    /* Helper Method :-
    Because it was being repeated several times.

    * */

    private Train findTrainById(Long id) throws TrainNotFoundException{
        Optional<Train> optionalTrain = trainRepository.findById(id);
        if (optionalTrain.isEmpty()) {
            throw new TrainNotFoundException("Train Not Found");
        }
        return optionalTrain.get();
    }

    public TrainResponse createTrain(TrainRequest request) {
        TrainResponse response = new TrainResponse();
        Train train = new Train();
        train.setTrainName(request.getTrainName());
        train.setTrainNumber(request.getTrainNumber());

        Train savedTrain = trainRepository.save(train);
        response.setId(savedTrain.getId());
        response.setTrainName(savedTrain.getTrainName());
        response.setTrainNumber(savedTrain.getTrainNumber());
        response.setMessage("Train Registered Successfully");
        return response;
    }

    public TrainResponse getTrainByID(Long id) {
        Train train =  findTrainById(id);
       TrainResponse response = new TrainResponse();
       response.setId(train.getId());
       response.setTrainName(train.getTrainName());
       response.setTrainNumber(train.getTrainNumber());
       return response;
    }

    public List<TrainResponse> getAllTrains() {
            List<Train> trains = trainRepository.findAll(); //get all trains
            List<TrainResponse> responses = new ArrayList<>();
            for (Train train : trains) { //Take each train one by one
                TrainResponse response = new TrainResponse(); // create a new response object
                //Add the train's information into the response Object.
                response.setId(train.getId());
                response.setTrainName(train.getTrainName());
                response.setTrainNumber(train.getTrainNumber());
                //put that response into response list and finally return the whole response list.
                responses.add(response);
            }
            return responses;
    }
    public TrainResponse updateTrain(Long id, TrainRequest request) {
        Train train = findTrainById(id);
        train.setTrainName(request.getTrainName());
        train.setTrainNumber(request.getTrainNumber());
        Train savedTrain = trainRepository.save(train);
        TrainResponse response = new TrainResponse();
        response.setId(savedTrain.getId());
        response.setTrainName(savedTrain.getTrainName());
        response.setTrainNumber(savedTrain.getTrainNumber());
        response.setMessage("Train Updated Successfully");
        return response;
    }
    public TrainResponse deleteTrain(Long id) {
        Train train = findTrainById(id);
        TrainResponse response = new TrainResponse();
        response.setId(train.getId());
        response.setMessage("Train Deleted Successfully");
        trainRepository.deleteById(id);
        return response;
    }
}
