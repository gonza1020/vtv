package com.certant.vtv.service.impl;

import com.certant.vtv.model.Measurement;
import com.certant.vtv.repository.MeasurementRepository;
import com.certant.vtv.service.MeasurementService;
import com.certant.vtv.utils.Condition;
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

        Measurement measurement = measurementRepository.findById(id).orElse(null);

        assert measurement != null;
        measurementRepository.delete(measurement);
    }

    public HashMap<String, Condition> checkMeasurements(Measurement measurement){

        HashMap<String, Condition> measurements = new HashMap<>();
        measurements.put("brakes",measurement.getBrakes());
        measurements.put("suspension", measurement.getSuspension());
        measurements.put("gas-emission",measurement.getGasEmisions());
        measurements.put("front-wheel-assembly",measurement.getFrontWheelAssembly());
        return measurements;
    }

    public Condition validateMeasurements(HashMap<String, Condition> measurements){
        int rejected = 0;
        int conditional = 0;
        for(String meas : measurements.keySet()){
            if(measurements.get(meas) == Condition.CONDITIONAL ){
                conditional += 1;
            }else if (measurements.get(meas) == Condition.REJECTED) {
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
