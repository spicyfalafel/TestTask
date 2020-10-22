package com.svyat.test.repository;

import com.svyat.test.model.Virus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VirusRepository extends JpaRepository<Virus, Integer> {
}
