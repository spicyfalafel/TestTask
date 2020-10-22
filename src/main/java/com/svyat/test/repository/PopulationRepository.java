package com.svyat.test.repository;

import com.svyat.test.model.Population;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PopulationRepository extends JpaRepository<Population, Integer> {
}
