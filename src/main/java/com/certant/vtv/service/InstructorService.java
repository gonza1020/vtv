package com.certant.vtv.service;

import com.certant.vtv.model.Costumer;
import com.certant.vtv.model.Inspector;

import java.util.List;

public interface InstructorService {
    Inspector createInspector(Inspector inspector);
    Inspector getInspector(Long id);
    List<Inspector> getAll();
    Inspector updateInspector(Long id, Inspector inspector);
    void deleteInspector(Long id);
}
