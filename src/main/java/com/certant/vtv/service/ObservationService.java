package com.certant.vtv.service;

import com.certant.vtv.model.Costumer;
import com.certant.vtv.model.Observation;

import java.util.List;

public interface ObservationService {
    Observation createObservation(Observation observation);
    Observation getObservation(String id);
    List<Observation> getAll();
    Observation updateObservation(String id, Observation observation);
    void deleteObservation(String id);
}
