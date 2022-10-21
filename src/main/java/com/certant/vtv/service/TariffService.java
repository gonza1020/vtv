package com.certant.vtv.service;

import com.certant.vtv.model.Tariff;
import com.certant.vtv.model.VehicleData;

import java.util.List;

public interface TariffService {

    Tariff createTariff(Tariff tariff);
    Tariff getTariff(String id);
    List<Tariff> getAll();
    Tariff updateTariff(String id, Tariff tariff);
    void deleteTariff(String id);
}
