package com.certant.vtv.service.impl;

import com.certant.vtv.model.Observation;
import com.certant.vtv.repository.ObservationRepository;
import com.certant.vtv.service.ObservationService;
import com.certant.vtv.utils.Condition;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ObservationServiceImpl implements ObservationService {

    private ObservationRepository observationRepository;

    @Override
    public Observation createObservation(Observation observation) {
        return observationRepository.save(observation);
    }

    @Override
    public Observation getObservation(Long id) {
        Optional<Observation> observation = observationRepository.findById(id);
        return observation.orElse(null);
    }

    @Override
    public List<Observation> getAll() {
        return observationRepository.findAll();
    }

    @Override
    public Observation updateObservation(Long id, Observation observation) {
        return null;
    }

    @Override
    public void deleteObservation(Long id) {
        observationRepository.deleteById(id);
    }


    public HashMap<String, Condition> checkObservations(Observation observation){

        HashMap<String, Condition> observations = new HashMap<>();
        observations.put("chassis",observation.getChassis());
        observations.put("lights", observation.getLights());
        observations.put("license-plate",observation.getLicensePlate());
        observations.put("mirrors",observation.getMirrors());
        observations.put("glasses",observation.getGlasses());
        observations.put("security-vehicle",observation.getSecurityVehicle());
        return observations;
    }

    public Condition validateObservations(HashMap<String, Condition> observations){
        int rejected = 0;
        int conditional = 0;
        for(String obs : observations.keySet()){
            if(observations.get(obs) == Condition.CONDITIONAL ){
                conditional += 1;
            }else if (observations.get(obs) == Condition.REJECTED) {
                rejected += 1;
                break;
            }
        }
        if (rejected != 0){
            return Condition.REJECTED;
        }
        if(conditional != 0){
            return Condition.CONDITIONAL;
        }
        return  Condition.APPROVED;
    }
}
