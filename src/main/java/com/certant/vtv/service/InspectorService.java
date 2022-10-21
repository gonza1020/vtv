package com.certant.vtv.service;

import com.certant.vtv.model.Inspector;

import java.util.List;

public interface InspectorService {
    Inspector createInspector(Inspector inspector);
    Inspector getInspector(String id);
    List<Inspector> getAll();
    Inspector updateInspector(String id, Inspector inspector);
    void deleteInspector(String id);
}
