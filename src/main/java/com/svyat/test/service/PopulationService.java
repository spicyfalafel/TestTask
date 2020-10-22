package com.svyat.test.service;

import com.svyat.test.model.Population;

import java.util.List;

public interface PopulationService {
    Population getById(Integer id);

    void save(Population population);

    void saveAll(List<Population> population);

    void delete(Integer id);

    List<Population> getAll();
}
