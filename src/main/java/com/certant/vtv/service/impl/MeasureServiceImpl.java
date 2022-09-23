package com.certant.vtv.service.impl;

import com.certant.vtv.model.Measurement;
import com.certant.vtv.repository.MeasurementRepository;
import com.certant.vtv.service.MeasurementService;
import com.certant.vtv.utils.State;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MeasureServiceImpl implements MeasurementService {


    private MeasurementRepository measurementRepository;
    @Override
    public Measurement createMeasurement(Measurement measurement) {
        return measurementRepository.save(measurement);
    }

    @Override
    public Measurement getMeasurement(Long id) {
        Optional<Measurement> measurement = measurementRepository.findById(id);
        return measurement.orElse(null);
    }

    @Override
    public List<Measurement> getAll() {
        return measurementRepository.findAll();
    }

    @Override
    public Measurement updateMeasurement(Long id, Measurement measurement) {
        return null;
    }

    @Override
    public void deleteMeasurement(Long id) {
        measurementRepository.deleteById(id);
    }

    public HashMap<String, State> checkMeasurements(Long id){

        Measurement measurement  = getMeasurement(id);
        HashMap<String, State > measurements = new HashMap<>();
        measurements.put("brakes",measurement.getBrakes());
        measurements.put("suspension", measurement.getSuspension());
        measurements.put("gas-emission",measurement.getGasEmisions());
        measurements.put("front-wheel-assembly",measurement.getFrontWheelAssembly());
        return measurements;
    }

    public State validateMeasurements(HashMap<String,State> measurements){
        int rejected = 0;
        int conditional = 0;
        for(String meas : measurements.keySet()){
            if(measurements.get(meas) == State.CONDITIONAL ){
                conditional += 1;
            }else if (measurements.get(meas) == State.REJECTED) {
                rejected += 1;
                break;
            }
        }
        if (rejected != 0){
            return State.REJECTED;
        }
        if(conditional != 0){
            return State.CONDITIONAL;
        }
        return  State.APPROVED;
    }
}
