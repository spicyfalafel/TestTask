package com.svyat.test.service;

import com.svyat.test.model.Virus;

import java.util.List;

public interface VirusService {
    Virus getById(Integer id);

    void save(Virus virus);

    void saveAll(List<Virus> viruses);

    void delete(Integer id);

    List<Virus> getAll();
}
