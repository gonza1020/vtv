package com.certant.vtv.service.impl;

import com.certant.vtv.model.Costumer;
import com.certant.vtv.repository.CostumerRepository;
import com.certant.vtv.service.CostumerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CostumerServiceImpl implements CostumerService {

    private CostumerRepository costumerRepository;

    @Override
    public Costumer createCostumer(Costumer costumer) {
        return costumerRepository.save(costumer);
    }

    @Override
    public Costumer getCostumer(Long id) {
        Optional<Costumer> costumer = costumerRepository.findById(id);

        return costumer.orElse(null);
    }

    @Override
    public List<Costumer> getAll() {
        return costumerRepository.findAll();
    }

    @Override
    public Costumer updateCostumer(Long id, Costumer costumer) {
        return null;
    }

    @Override
    public void deleteCostumer(Long id) {
        Costumer costumer = costumerRepository.findById(id).orElse(null);

        assert costumer != null;
        costumerRepository.delete(costumer);
    }
}
