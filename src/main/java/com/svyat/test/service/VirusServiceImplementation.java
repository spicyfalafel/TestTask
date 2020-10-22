package com.svyat.test.service;

import com.svyat.test.model.Virus;
import com.svyat.test.repository.VirusRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class VirusServiceImplementation implements VirusService {

    @Autowired
    VirusRepository virusRepository;

    @Override
    public Virus getById(Integer id) {
        log.info("getById():" + id);
        return virusRepository.getOne(id);
    }

    @Override
    public void save(Virus virus) {
        virusRepository.save(virus);
        log.info("save():" + virus);
    }

    @Override
    public void saveAll(List<Virus> viruses) {
        virusRepository.saveAll(viruses);
        log.info("saveAll(): " + viruses.size());
    }

    @Override
    public void delete(Integer id) {
        virusRepository.deleteById(id);
        log.info("delete():" + id);
    }

    @Override
    public List<Virus> getAll() {
        log.info("getAll()");
        return virusRepository.findAll();
    }
}
