package com.srm806.srmtools.repository;

import com.srm806.srmtools.domain.EnvironmentParas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnvRepository extends JpaRepository<EnvironmentParas, Integer> {
    EnvironmentParas findBySrmName(String srmName);
}
