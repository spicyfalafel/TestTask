package com.svyat.test.repository;

import com.svyat.test.model.Population;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface PopulationRepository extends JpaRepository<Population, BigInteger> {
}
