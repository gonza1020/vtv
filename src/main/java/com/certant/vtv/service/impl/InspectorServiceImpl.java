package com.certant.vtv.service.impl;

import com.certant.vtv.model.Inspector;
import com.certant.vtv.repository.InspectorRepository;
import com.certant.vtv.service.InspectorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class InspectorServiceImpl implements InspectorService {

    private InspectorRepository inspectorRepository;
    @Override
    public Inspector createInspector(Inspector inspector) {

        return inspectorRepository.save(inspector);
    }

    @Override
    public Inspector getInspector(Long id) {

        Optional<Inspector> inspector = inspectorRepository.findById(id);

        return inspector.orElse(null);
    }

    @Override
    public List<Inspector> getAll() {

        return inspectorRepository.findAll();
    }

    @Override
    public Inspector updateInspector(Long id, Inspector inspector) {
        return null;
    }

    @Override
    public void deleteInspector(Long id) {

        Inspector inspector = inspectorRepository.findById(id).orElse(null);

        assert inspector != null;
        inspectorRepository.delete(inspector);
    }
}
