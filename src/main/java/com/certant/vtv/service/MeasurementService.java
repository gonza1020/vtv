package com.certant.vtv.service;

import com.certant.vtv.model.Costumer;
import com.certant.vtv.model.Measurement;

import java.util.List;

public interface MeasurementService {
    Measurement createMeasurement(Measurement measurement);
    Measurement getMeasurement(String id);
    List<Measurement> getAll();
    Measurement updateMeasurement(String id, Measurement measurement);
    void deleteMeasurement(String id);
}
