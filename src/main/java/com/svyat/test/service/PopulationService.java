package com.svyat.test.service;

import com.svyat.test.model.Population;

import java.math.BigInteger;
import java.util.List;

public interface PopulationService {
    Population getById(BigInteger id);

    void save(Population population);

    void saveAll(List<Population> population);

    void delete(BigInteger id);

    List<Population> getAll();
}
