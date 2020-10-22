package com.svyat.test.service;

import com.svyat.test.model.Population;
import com.svyat.test.model.Virus;
import com.svyat.test.repository.PopulationRepository;
import com.svyat.test.repository.VirusRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PopulationServiceImplementation implements PopulationService{

    @Autowired
    PopulationRepository populationRepository;

    @Override
    public Population getById(Integer id) {
        log.info("population getById():" + id);
        return populationRepository.getOne(id);
    }

    @Override
    public void save(Population population) {
        populationRepository.save(population);
        log.info("population save():" + population);
    }

    @Override
    public void saveAll(List<Population> population) {
        populationRepository.saveAll(population);
        log.info("population saveAll(): " + population.size());
    }

    @Override
    public void delete(Integer id) {
        populationRepository.deleteById(id);
        log.info("population delete():" + id);
    }

    @Override
    public List<Population> getAll() {
        log.info("population getAll()");
        return populationRepository.findAll();
    }
}
